/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.lib;

import brutelol.Funcs;
import brutelol.charbuild.Build;
import brutelol.charbuild.ItemSet;
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
    protected double ATTACK_SPEED_AT_1 = 0;

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
    
    //List of items required for this character. Used to add items that we know
    //are "core" but that the algorithm might not catch. (Like boots)
    protected List<Class<? extends Item>> requiredItems = new ArrayList<>();
    
    //Other attributes of a champion that we might need to calculate its attributes.
    protected boolean isMelee = false;
    
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
    
    public double getManaRegen(Build b) 
    {
        return this.MANA_REGEN_AT_0+((b.getLevel()-1)*this.MANA_REGEN_PER_LEVEL);
    }

    public double getHealthRegen(Build b) 
    {
        return this.HP_REGEN_AT_0+((b.getLevel()-1)*this.HP_REGEN_PER_LEVEL);
    }

    public double getMoveSpeed(Build b) 
    {
        return this.MOVE_SPEED;
    }

    public double getMagicResist(Build b) 
    {
        return this.MAGIC_RES_AT_0+((b.getLevel()-1)*this.MAGIC_RES_PER_LEVEL);
    }

    public double getArmor(Build b) 
    {
        return this.ARMOR_AT_0+((b.getLevel()-1)*this.ARMOR_PER_LEVEL);
    }

    public double getMaxHP(Build b) 
    {
        return this.HP_AT_0+((b.getLevel()-1)*this.HP_PER_LEVEL);
    }

    public double getMaxMana(Build b) 
    {
        return this.MANA_AT_0+((b.getLevel()-1)*this.MANA_PER_LEVEL);
    }

    public double getAttackSpeed(Build b) 
    {
        //Works differently!
        return ((b.getLevel()-1)*this.ATTACK_SPEED_PER_LEVEL);
    }

    public double getAttackDamage(Build b) 
    {
        return this.ATTACK_DAMAGE_AT_0+((b.getLevel()-1)*this.ATTACK_DAMAGE_PER_LEVEL);
    }
    
    //From this point forward, we have generic functions that calculate components.
    //Most of these are good for most champions, but specific champion passives will
    //require the author to overwrite these. (I'm looking at you, Ashe and Jhin!)

    protected double getBasePhysicalDamagePerAttack(Build b) 
    {
        BuildInfo stats = b.getBuildInfo();
        
        double critChance = stats.critChance;
        double cappedCritChance = Math.min(critChance,1.0);
        
        //Calculate basic damage.
        double damagePerAttack = 0;
        damagePerAttack+=stats.attackDamage;
        
        //Add crit modifiers.
        double damageIncludingCrits = damagePerAttack+(damagePerAttack*cappedCritChance*(1+stats.addedCritDamage));
        
        return damageIncludingCrits;
    }

    /**
     * Gets the bonus physical damage on an auto-attack that are independent of
     * target. (I think there are none for now, but I'll see later.)
     * @param b the build to get data from.
     * @return 
     */
    protected double getBonusPhysicalDamagePerAttack(Build b) 
    {
        return 0;
    }

    /**
     * Gets the number of Auto-attacks per second of firing.
     * @param b the build to evaluate.
     * @return 
     */
    protected double getAttacksPerSecond(Build b) 
    {
        BuildInfo stats = b.getBuildInfo();
        double attacksPerSecond = ATTACK_SPEED_AT_1;
        double addedAttackSpeed = stats.attackSpeed;
        
        //Calculate final atacks per second.
        attacksPerSecond *= (1+addedAttackSpeed);
        
        if (attacksPerSecond > 2.5)
        {
            attacksPerSecond = 2.5;
        }
        
        return attacksPerSecond;
    }
    
    /**
     * Gets the magic damage per auto-attack from, for instance, wits end.
     * @param b the build to evaluate
     * @return the magic damage dealt per auto-attack.
     */
    protected double getMagicDamagePerAttack(Build b) 
    {
        double toReturn = 0;
        
        return toReturn;
    }
    
    /**
     * Returns the amount of life stolen per auto-attack.
     * @param b the build to evaluate
     * @return the life stolen per auto-attack.
     */
    protected double getRawLifeStolenPerAttack(Build b) 
    {
        //This is the first time we see this: One Heuristic Component might rely on another. We don't
        //want to recalculate it if we already have it for other reasons, so we cache calculations
        //we have already done in the build. We retrieve those (or perhaps calculate them for
        //the first time) in Build.getComponent(component, foe)
        double damage = b.getComponent(HeuristicComponent.BASE_PHYSICAL_DAMAGE_PER_ATTACK);
        damage += b.getComponent(HeuristicComponent.BONUS_PHYSICAL_DAMAGE_PER_ATTACK);
        
        double lifeStealPercent = b.getBuildInfo().lifeSteal;
        
        return damage*lifeStealPercent;
    }
    
    /**
     * Returns the damage per second dealt while auto-attacking.
     * @param b the build to evaluate.
     * @return the damage per second.
     */
    protected double getRawDamagePerSecond(Build b) 
    {
        double totalDamage = b.getComponent(HeuristicComponent.RAW_TOTAL_DAMAGE_PER_ATTACK);
        double attacks = b.getComponent(HeuristicComponent.ATTACKS_PER_SECOND);
        
        return attacks*(totalDamage);
    }

    /**
     * Returns the total damage per auto-attack.
     * @param b the build to evaluate.
     * @param enemy the enemy we are auto-attacking.
     * @return the damage per auto-attack.
     */
    protected double getRawTotalDamagePerAttack(Build b) 
    {
        double basePhysicalDamage = b.getComponent(HeuristicComponent.BASE_PHYSICAL_DAMAGE_PER_ATTACK);
        double bonusPhysicalDamage = b.getComponent(HeuristicComponent.BONUS_PHYSICAL_DAMAGE_PER_ATTACK);
        double bonusMagicDamage = b.getComponent(HeuristicComponent.BONUS_MAGIC_DAMAGE_PER_ATTACK);
        double totalDamage = basePhysicalDamage+bonusPhysicalDamage+bonusMagicDamage;
        return totalDamage;
    }

    /**
     * Get the total life stolen per second.
     * @param b the build to evaluate
     * @return 
     */
    protected double getLifeStolenPerSecond(Build b) 
    {
        double attacks = b.getComponent(HeuristicComponent.ATTACKS_PER_SECOND);
        double lifesteal = b.getComponent(HeuristicComponent.LIFE_STOLEN_PER_ATTACK);
        return attacks*lifesteal;
    }
    
    protected double getArmorRatio(Build b, Build enemy) 
    {
        double armor = enemy.getBuildInfo().armor;
        
        if (b.getBuildInfo().armorPenetrationPercent > 0)
        {
            double apenpercent = b.getBuildInfo().armorPenetrationPercent;
            armor*=(1.0-apenpercent);
        }

        if (b.getBuildInfo().armorPenetrationFlat > 0)
        {
            double apenflat = b.getBuildInfo().armorPenetrationFlat;
            armor-=apenflat;
        }
        
        if (armor < 0)
        {
            armor = 0;
        }
        
        double ratio = (100.0/(100.0+armor));
        
        return ratio;
    }
    
    protected double getMagicResistRatio(Build b, Build enemy) 
    {
        double mr = enemy.getBuildInfo().magicResist;
        
        /*if (b.getBuildInfo().hasPassive(CPassive.WITS_END_PASSIVE))
        {
            mr-=12.5;
            b.addLineToNotes(" - We assume your opponent has an average of 2.5 stacks of wits end on him. That's -12.5 Magic resist, for "+mr+" resist. ");
        }*/
        
        if (b.getBuildInfo().magicPenetrationPercent > 0)
        {
            double mpenpercent = b.getBuildInfo().magicPenetrationPercent;
            mr*=(1.0-mpenpercent);
        }

        if (b.getBuildInfo().magicPenetrationFlat > 0)
        {
            double mpenflat = b.getBuildInfo().magicPenetrationFlat;
            mr-=mpenflat;
        }
        
        if (mr < 0)
        {
            mr = 0;
        }
        
        double ratio = (100.0/(100.0+mr));
        
        return ratio;
    }

    protected double applyEnemyArmor(double damage, Build b, Build enemy) 
    {
        double ratio = enemy.getComponent(HeuristicComponent.ARMOR_DAMAGE_MULTIPLIER);
        double newDamage = damage * ratio;
        
        return newDamage;
    }
    
    protected double applyEnemyMagicResist(double damage, Build b, Build enemy) 
    {
        double ratio = enemy.getComponent(HeuristicComponent.RESIST_DAMAGE_MULTIPLIER);
        double newDamage = damage * ratio;
        
        return newDamage;
    }

    public Object getColorString() 
    {
        return "0";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Poke damage represents the damage dealt by a single "Quick combo," like an ashe volley+AA
     * or a Xayah Q-AA-E. For a generic character, let's assume this is just an auto-attack.
     * @param b the build doing the poking.
     * @return the poke damage.
     */
    public double getRawPokeDamage(Build b) 
    {
        double totalDamage = b.getComponent(HeuristicComponent.RAW_TOTAL_DAMAGE_PER_ATTACK);
        return totalDamage;
    }
}
