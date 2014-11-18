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
    
    //From this point forward, we have generic functions that calculate components.

    protected double getBasePhysicalDamagePerAttack(Build b, Build enemy) 
    {
        BuildInfo stats = b.getBuildInfo();
        
        double critChance = stats.critChance;
        double cappedCritChance = Math.min(critChance,1.0);
        
        //Calculate basic damage.
        double damagePerAttack = 0;
        damagePerAttack+=stats.attackDamage;
        
        //Add crit modifiers.
        double damageIncludingCrits = damagePerAttack+(damagePerAttack*critChance*(1+stats.addedCritDamage));
        
        b.addLineToNotes("CALCULATION OF BASE PHYSICAL DAMAGE PER ATTACK: ");
        b.addLineToNotes(" - Crit chance is "+(critChance*100)+"%.");
        if (critChance >= 1.0)
        {
            b.addLineToNotes(" - That's above the crit chance cap, so we cap it at "+(cappedCritChance*100)+"%");
        }
        b.addLineToNotes(" - Base attack damage is "+damagePerAttack+".");
        b.addLineToNotes(" - We add average crit damage: "+damagePerAttack+"×"+cappedCritChance+"×(1 + "+stats.addedCritDamage+").");
        b.addLineToNotes(" - Total damage so far is "+damageIncludingCrits+".");
        b.addLineToNotes(" - We then apply enemy armor: ");
        
        //Apply Armor
        double damageAfterArmor = applyEnemyArmor(damageIncludingCrits, b, enemy);
        
        b.addLineToNotes(" - Final base physical damager per attack: "+damageAfterArmor);
        
        return damageAfterArmor;
    }

    protected double getBonusPhysicalDamagePerAttack(Build b, Build enemy) 
    {
        double bonusDamage = 0;
        if (b.getBuildInfo().hasPassive(CPassive.RUINED_KING_PASSIVE))
        {
            bonusDamage += enemy.getBuildInfo().hp * .08;
        }
        
        if (bonusDamage != 0)
        {
            b.addLineToNotes("CALCULATION OF BONUS PHYSICAL DAMAGE PER ATTACK: ");
            if (b.getBuildInfo().hasPassive(CPassive.RUINED_KING_PASSIVE))
            {
                b.addLineToNotes(" - The Ruin passive adds (Enemy max HP × 8% to the attack, or "+enemy.getBuildInfo().hp +" × .08 = "+(enemy.getBuildInfo().hp * .08));
            }
            b.addLineToNotes(" - Subtotal bonus damage per attack: "+bonusDamage);
            
            bonusDamage = this.applyEnemyArmor(bonusDamage, b, enemy);
            b.addLineToNotes(" - final bonus damage per attack: "+bonusDamage);
        }
        
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
        b.addLineToNotes("   - Enemy armor is "+armor);
        
        if (b.getBuildInfo().armorPenetrationPercent > 0)
        {
            double apenpercent = b.getBuildInfo().armorPenetrationPercent;
            armor*=(1.0-apenpercent);
            b.addLineToNotes("   - It is reduced to "+((1.0-apenpercent)*100)+" % effectiveness by our "+(apenpercent*100)+"% Armor Penetration, leaving it at "+armor+".");
        }

        if (b.getBuildInfo().armorPenetrationFlat > 0)
        {
            double apenflat = b.getBuildInfo().armorPenetrationFlat;
            armor-=apenflat;
            b.addLineToNotes("   - It is reduced by another "+apenflat+" by our flat armor penetration, leaving it at "+armor);
        }
        
        if (armor < 0)
        {
            armor = 0;
            b.addLineToNotes("   - This is below zero, so we set armor to "+armor);
        }
        
        double newDamage = damage*(100.0/(100.0+armor));
        b.addLineToNotes("   - The damage of "+damage+" is multiplied by the armor ratio:  (100)/(100+"+armor+"), leaving us with "+newDamage+".");
        
        return damage;
    }
}
