/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.lib;

import brutelol.Funcs;
import brutelol.charbuild.Build;
import brutelol.charbuild.ItemSet;
import brutelol.fights.Ability;
import brutelol.fights.Combatant;
import brutelol.items.abstracts.CUnique;
import brutelol.items.abstracts.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public abstract class AbstractLolCharacter implements LolCharacter
{   
    /**
     * A stringbuilder to hold math notes so we can show our work.
     */
    private final StringBuilder notes = null;
    
    //Variables representing the starting state
    protected double HP_AT_0 = 0;
    protected double HP_REGEN_AT_0 = 0;
    protected double MANA_AT_0 = 0;
    protected double MANA_REGEN_AT_0 = 0;
    protected double ATTACK_DAMAGE_AT_0 = 0;
    protected double ARMOR_AT_0 = 0;
    protected double MAGIC_RES_AT_0 = 0;
    
    //Attack speed is calculated different, so it's "at one" instead of "at zero"
    public double ATTACK_SPEED_AT_1 = 0;

    //Variables representing the growth per level.
    protected double HP_PER_LEVEL = 0;
    protected double HP_REGEN_PER_LEVEL = 0;
    protected double MANA_PER_LEVEL = 0;
    protected double MANA_REGEN_PER_LEVEL = 0;
    protected double ATTACK_DAMAGE_PER_LEVEL = 0;
    protected double ARMOR_PER_LEVEL = 0;
    protected double MAGIC_RES_PER_LEVEL = 0;
    protected double ATTACK_SPEED_PER_LEVEL = 0;
    
    //Variables representing more constant attributes.
    protected double MOVE_SPEED = 0;
    protected double RANGE = 0;
    
    //Info about our build and where we are in the build:
    BuildStats stats;
    Build b;
    
    //List of items required for this character. Used to add items that we know
    //are "core" but that the algorithm might not catch. (Like boots)
    protected List<Class<? extends Item>> requiredItems = new ArrayList<>();
    
    //Other attributes of a champion that we might need to calculate its attributes.
    protected boolean isMelee = false;
    
    
    public AbstractLolCharacter(Build b)
    {
        this.b=b;
        this.stats = new BuildStats(this, b, null);
    }
    
    /**
     * Returns whether or not any items are missing.
     * @param items the items to check.
     * @return whether there are any required items missing from the itemset. True
     * if items are missing, false otherwise.
     */
    protected boolean missingItems(ItemSet items)
    {
        for (Class<? extends Item> reqItem : requiredItems)
        {
            boolean foundIt = false;
            for (Item buildItem : items.itemsInList)
            {
                if (reqItem.isAssignableFrom(buildItem.getClass()))
                {
                    foundIt = true;
                }
            }
            if (foundIt == false)
            {
                return true;
            }
        }
        
        for (Item buildItem : items.itemsInList)
        {
            if (isMelee&&buildItem.isRangedOnly()||!isMelee&&buildItem.isMeleeOnly())
                {
                    return true;
                }
        }
        return false;
    }

    //The following functions get different aspects of an unequipped champion.
    //They can all be overwritten by subclasses. Please note that you should NEVER
    //use these when calculating heuristic components: Use the "BuildInfo" data
    //structure instead!
    
    public double getBaseManaRegen() 
    {
        return this.MANA_REGEN_AT_0+((b.getLevel()-1)*this.MANA_REGEN_PER_LEVEL);
    }

    public double getBaseHealthRegen() 
    {
        return this.HP_REGEN_AT_0+((b.getLevel()-1)*this.HP_REGEN_PER_LEVEL);
    }

    public double getBaseMoveSpeed() 
    {
        return this.MOVE_SPEED;
    }

    public double getBaseMagicResist() 
    {
        return this.MAGIC_RES_AT_0+((b.getLevel()-1)*this.MAGIC_RES_PER_LEVEL);
    }

    public double getBaseArmor() 
    {
        return this.ARMOR_AT_0+((b.getLevel()-1)*this.ARMOR_PER_LEVEL);
    }

    public double getBaseMaxHP() 
    {
        return this.HP_AT_0+((b.getLevel()-1)*this.HP_PER_LEVEL);
    }

    public double getBaseMaxMana() 
    {
        return this.MANA_AT_0+((b.getLevel()-1)*this.MANA_PER_LEVEL);
    }

    public double getBaseAttackSpeedBonus() 
    {
        //Works differently!
        return ((b.getLevel()-1)*this.ATTACK_SPEED_PER_LEVEL);
    }

    public double getBaseAttackDamage() 
    {
        return this.ATTACK_DAMAGE_AT_0+((b.getLevel()-1)*this.ATTACK_DAMAGE_PER_LEVEL);
    }
    
    //From this point forward, we have generic functions that calculate components.
    //Most of these are good for most champions, but specific champion passives will
    //require the author to overwrite these. (I'm looking at you, Ashe and Jhin!)



    /**
     * Gets the bonus physical damage on an auto-attack that are independent of
     * target. (I think there are none for now, but I'll see later.)
     * @param b the build to get data from.
     * @return 
     */
    public double getBonusPhysicalDamagePerAttack() 
    {
        return 0;
    }


    
    /**
     * Gets the magic damage per auto-attack from, for instance, wits end.
     * @param b the build to evaluate
     * @return the magic damage dealt per auto-attack.
     */
    public double getMagicDamagePerAttack() 
    {
        double toReturn = 0;
        
        return toReturn;
    }
    
    /**
     * Returns the amount of life stolen per auto-attack.
     * @param b the build to evaluate
     * @return the life stolen per auto-attack.
     */
    public double getRawLifeStolenPerAttack() 
    {
        //This is the first time we see this: One Heuristic Component might rely on another. We don't
        //want to recalculate it if we already have it for other reasons, so we cache calculations
        //we have already done in the build. We retrieve those (or perhaps calculate them for
        //the first time) in Build.getComponent(component, foe)
        double damage = 0;//getBasePhysicalDamagePerAttack();
        damage += getBonusPhysicalDamagePerAttack();
        
        double lifeStealPercent = stats.lifeSteal;
        
        return damage*lifeStealPercent;
    }
    
    /**
     * Returns the damage per second dealt while auto-attacking.
     * @param b the build to evaluate.
     * @return the damage per second.
     */
    public double getRawDamagePerSecond() 
    {
        double totalDamage = getRawTotalDamagePerAttack();
        double attacks = 0;//getAttacksPerSecond();
        
        return attacks*(totalDamage);
    }

    /**
     * Returns the total damage per auto-attack.
     * @param b the build to evaluate.
     * @param enemy the enemy we are auto-attacking.
     * @return the damage per auto-attack.
     */
    public double getRawTotalDamagePerAttack() 
    {
        double basePhysicalDamage = 0;//getBasePhysicalDamagePerAttack();
        double bonusPhysicalDamage = getBonusPhysicalDamagePerAttack();
        double bonusMagicDamage = getMagicDamagePerAttack();
        double totalDamage = basePhysicalDamage+bonusPhysicalDamage+bonusMagicDamage;
        return totalDamage;
    }

    /**
     * Get the total life stolen per second.
     * @param b the build to evaluate
     * @return 
     */
    public double getLifeStolenPerSecond() 
    {
        double attacks = 0;//getAttacksPerSecond();
        double lifesteal = getRawLifeStolenPerAttack();
        return attacks*lifesteal;
    }

    public BuildStats getStats() 
    {
        return stats;
    }

    public List<Ability> getAbilities() 
    {
        List<Ability>toReturn = new ArrayList<>();
        toReturn.add(Ability.AUTO_ATTACK);
        return toReturn;
    }
}
