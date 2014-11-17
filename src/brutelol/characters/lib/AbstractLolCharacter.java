/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.lib;

import brutelol.Funcs;
import brutelol.charbuild.Build;
import brutelol.charbuild.ItemSet;
import brutelol.charbuild.MasterySet;
import brutelol.charbuild.RunePage;
import brutelol.characters.instances.BuildInfo;
import brutelol.items.abstracts.CPassive;
import brutelol.items.abstracts.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public abstract class AbstractLolCharacter implements LolCharacter
{   
    private StringBuilder notes = null;
    
    //Variables representing the starting state
    protected double HP_AT_0 = 0;
    protected double HP_REGEN_AT_0 = 0;
    protected double MANA_AT_0 = 0;
    protected double MANA_REGEN_AT_0 = 0;
    protected double ATTACK_DAMAGE_AT_0 = 0;
    protected double ARMOR_AT_0 = 0;
    protected double MAGIC_RES_AT_0 = 0;
    
    //Attack speed is calculated different.
    protected double ATTACK_SPEED_AT_1 = 0;

    //Variables representing the growth per level.
    protected double HP_PER_LEVEL = 0;
    protected double HP_REGEN_PER_LEVEL = 0;
    protected double MANA_PER_LEVEL = 0;
    protected double MANA_REGEN_PER_LEVEL = 0;
    protected double ATTACK_DAMAGE_PER_LEVEL = 0;
    protected double ATTACK_SPEED_PER_LEVEL = 0;
    protected double ARMOR_PER_LEVEL = 0;
    protected double MAGIC_RES_PER_LEVEL = 0;
    
    //Variables representing more constant attributes.
    protected double MOVE_SPEED = 0;
    protected double RANGE = 0;
    
    //List of items required.
    protected List<Class<? extends Item>> requiredItems = new ArrayList<>();
    
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
    
    public String getNotes()
    {
        return notes.toString();
    }
    
    protected void addLineToNotes(String s)
    {
        if (notes != null)
        {
            notes.append(s);
        }
    }
    
    protected void turnOnNotes()
    {
        notes = new StringBuilder();
    }

    public int getLevel(Build b) 
    {
        return Funcs.getLevelFromXP(b.getXP());
    }

    public double getManaRegen(Build b) 
    {
        return this.MANA_REGEN_AT_0+(getLevel(b)*this.MANA_REGEN_PER_LEVEL);
    }

    public double getHealthRegen(Build b) 
    {
        return this.HP_REGEN_AT_0+(getLevel(b)*this.HP_REGEN_PER_LEVEL);
    }

    public double getMoveSpeed(Build b) 
    {
        return this.MOVE_SPEED;
    }

    public double getMagicResist(Build b) 
    {
        return this.MAGIC_RES_AT_0+(getLevel(b)*this.MAGIC_RES_PER_LEVEL);
    }

    public double getArmor(Build b) 
    {
        return this.ARMOR_AT_0+(getLevel(b)*this.ARMOR_PER_LEVEL);
    }

    public double getMaxHP(Build b) 
    {
        return this.HP_AT_0+(getLevel(b)*this.HP_PER_LEVEL);
    }

    public double getMaxMana(Build b) 
    {
        return this.MANA_AT_0+(getLevel(b)*this.MANA_PER_LEVEL);
    }

    public double getAttackSpeed(Build b) 
    {
        //Works differently!
        return ((getLevel(b)-1)*this.ATTACK_SPEED_PER_LEVEL);
    }

    public double getAttackDamage(Build b) 
    {
        return this.ATTACK_DAMAGE_AT_0+(getLevel(b)*this.ATTACK_DAMAGE_PER_LEVEL);
    }

    protected double getBasePhysicalDamagePerAttack(Build b, Build enemy) 
    {
        BuildInfo stats = b.getBuildInfo();
        double critChance = Math.min(stats.critChance,1.0);
        
        //Calculate basic damage.
        double damagePerAttack = 0;
        damagePerAttack+=stats.attackDamage;
        
        //Add crit modifiers.
        double damageIncludingCrits = damagePerAttack+(damagePerAttack*stats.critChance*(1+stats.addedCritDamage));
        
        //Apply Armor
        damageIncludingCrits = applyEnemyArmor(damageIncludingCrits, b, enemy);
        
        return damageIncludingCrits;
    }

    protected double getBonusPhysicalDamagePerAttack(Build b, Build enemy) 
    {
        double bonusDamage = 0;
        if (b.getBuildInfo().hasPassive(CPassive.RUINED_KING_PASSIVE))
        {
            bonusDamage += enemy.getBuildInfo().hp * .08;
        }
        bonusDamage = applyEnemyArmor(bonusDamage, b, enemy);
        return bonusDamage;
    }

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
    
    protected double getMagicDamagePerAttack(Build b) 
    {
        //Nashors tooth... Um... IDK.
        return 0;
    }
    
    protected double getLifeStolenPerAttack(Build b, Build enemy) 
    {
        double damage = b.getComponent(HeuristicComponent.BASE_PHYSICAL_DAMAGE_PER_ATTACK, enemy);
        damage += b.getComponent(HeuristicComponent.BONUS_PHYSICAL_DAMAGE_PER_ATTACK, enemy);
        
        double lifeStealPercent = b.getBuildInfo().lifeSteal;
        
        return damage*lifeStealPercent;
    }

    protected double getLifeStolenPerSecond(Build b, Build enemy) 
    {
        double attacks = b.getComponent(HeuristicComponent.ATTACKS_PER_SECOND, enemy);
        double lifesteal = b.getComponent(HeuristicComponent.LIFE_STOLEN_PER_ATTACK, enemy);
        return attacks*lifesteal;
    }

    private double applyEnemyArmor(double damage, Build b, Build enemy) 
    {
        double armor = enemy.getBuildInfo().armor;
        armor*=(1.0-b.getBuildInfo().armorPenetrationPercent);
        armor-=b.getBuildInfo().armorPenetrationFlat;
        if (armor < 0)
        {
            armor = 0;
        }
        damage *= (100.0/(100.0+armor));
        return damage;
    }
    
    private double applyEnemyMagicResist(double damage, Build b, Build enemy) 
    {
        double armor = enemy.getBuildInfo().magicResist;
        armor*=(1.0-b.getBuildInfo().magicPenetrationPercent);
        armor-=b.getBuildInfo().magicPenetrationFlat;
        if (armor < 0)
        {
            armor = 0;
        }
        damage *= (100.0/(100.0+armor));
        return damage;
    }
}
