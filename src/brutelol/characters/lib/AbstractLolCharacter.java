/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.lib;

import brutelol.buildobjs.Build;
import brutelol.buildobjs.ItemSet;
import brutelol.buildobjs.MasterySet;
import brutelol.buildobjs.RunePage;
import brutelol.characters.instances.BuildInfo;
import brutelol.items.abstracts.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public abstract class AbstractLolCharacter implements LolCharacter
{
    AbstractLolCharacter enemy;
    
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
    
    //Cache: What level is this character?
    protected int level;
    
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

    public int getLevel() 
    {
        return level;
    }

    public double getManaRegen() 
    {
        return this.MANA_REGEN_AT_0+(level*this.MANA_REGEN_PER_LEVEL);
    }

    public double getHealthRegen() 
    {
        return this.HP_REGEN_AT_0+(level*this.HP_REGEN_PER_LEVEL);
    }

    public double getMoveSpeed() 
    {
        return this.MOVE_SPEED;
    }

    public double getMagicResist() 
    {
        return this.MAGIC_RES_AT_0+(level*this.MAGIC_RES_PER_LEVEL);
    }

    public double getArmor() 
    {
        return this.ARMOR_AT_0+(level*this.ARMOR_PER_LEVEL);
    }

    public double getMaxHP() 
    {
        return this.HP_AT_0+(level*this.HP_PER_LEVEL);
    }

    public double getMaxMana() 
    {
        return this.MANA_AT_0+(level*this.MANA_PER_LEVEL);
    }

    public double getAttackSpeed() 
    {
        //Works differently!
        return ((level-1)*this.ATTACK_SPEED_PER_LEVEL);
    }

    public double getAttackDamage() 
    {
        return this.ATTACK_DAMAGE_AT_0+(level*this.ATTACK_DAMAGE_PER_LEVEL);
    }
    
    
    protected double getLifestealPerShot(BuildInfo stats) 
    {
        return getPhysicalDamagePerAttack(stats) * stats.lifeSteal;
    }

    protected double getPhysicalDamagePerAttack(BuildInfo stats) 
    {
        double critChance = Math.min(stats.critChance,1.0);
        
        //Calculate basic damage.
        double damagePerAttack = 0;
        damagePerAttack+=stats.attackDamage;
        
        //Add crit modifiers.
        double damageIncludingCrits = damagePerAttack+(damagePerAttack*stats.critChance*(1+stats.addedCritDamage));
        
        //Apply Armor
        return damageIncludingCrits;
    }

    protected double getBonusPhysicalDamagePerAttack(BuildInfo stats) 
    {
        return 0;
    }

    protected double getOverallAttackSpeed(BuildInfo stats) 
    {
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
}
