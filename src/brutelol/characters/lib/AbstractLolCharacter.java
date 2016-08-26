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
import brutelol.charbuild.runes.RunePage;
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
        return this.MANA_REGEN_AT_0+((getLevel(b)-1)*this.MANA_REGEN_PER_LEVEL);
    }

    public double getHealthRegen(Build b) 
    {
        return this.HP_REGEN_AT_0+((getLevel(b)-1)*this.HP_REGEN_PER_LEVEL);
    }

    public double getMoveSpeed(Build b) 
    {
        return this.MOVE_SPEED;
    }

    public double getMagicResist(Build b) 
    {
        return this.MAGIC_RES_AT_0+((getLevel(b)-1)*this.MAGIC_RES_PER_LEVEL);
    }

    public double getArmor(Build b) 
    {
        return this.ARMOR_AT_0+((getLevel(b)-1)*this.ARMOR_PER_LEVEL);
    }

    public double getMaxHP(Build b) 
    {
        return this.HP_AT_0+((getLevel(b)-1)*this.HP_PER_LEVEL);
    }

    public double getMaxMana(Build b) 
    {
        return this.MANA_AT_0+((getLevel(b)-1)*this.MANA_PER_LEVEL);
    }

    public double getAttackSpeed(Build b) 
    {
        //Works differently!
        return ((getLevel(b)-1)*this.ATTACK_SPEED_PER_LEVEL);
    }

    public double getAttackDamage(Build b) 
    {
        return this.ATTACK_DAMAGE_AT_0+((getLevel(b)-1)*this.ATTACK_DAMAGE_PER_LEVEL);
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
        double damageIncludingCrits = damagePerAttack+(damagePerAttack*cappedCritChance*(1+stats.addedCritDamage));
        
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
        
        b.addLineToNotes(" - Final base physical damage per attack: "+damageAfterArmor);
        
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
        
        b.addLineToNotes("CALCULATION OF ATTACKS PER SECOND: ");
        b.addLineToNotes(" - Attack speed starts at "+ATTACK_SPEED_AT_1+" for "+this.getClass().getName()+".");
        b.addLineToNotes(" - From items, levels, and powers, we get a "+(addedAttackSpeed*100)+"% bonus.");
        b.addLineToNotes(" - Thus, attacks per second is "+ATTACK_SPEED_AT_1+" × (1+"+addedAttackSpeed+") = "+attacksPerSecond);
        
        
        
        if (attacksPerSecond > 2.5)
        {
            attacksPerSecond = 2.5;
            b.addLineToNotes(" - That's over the cap of 2.5, so we cap it at "+attacksPerSecond);
        }
        
        return attacksPerSecond;
    }
    
    protected double getMagicDamagePerAttack(Build b, Build enemy, boolean crits) 
    {
        double toReturn = 0;
        double shivDamage = 0;
        double cappedCritChance = 0;
        double critDamage = 0;
        if (b.getBuildInfo().hasPassive(CPassive.NASHOR_PASSIVE))
        {
            toReturn += b.getBuildInfo().abilityPower*.15;
            toReturn += 15;
        }
        if (b.getBuildInfo().hasPassive(CPassive.WITS_END_PASSIVE))
        {
            toReturn += 42;
        }
        if (b.getBuildInfo().hasPassive(CPassive.FERAL_FLARE_PASSIVE))
        {
            toReturn += 55;
        }
        if (b.getBuildInfo().hasPassive(CPassive.STATIKK_PASSIVE))
        {
            BuildInfo stats = b.getBuildInfo();
            double critChance = stats.critChance;
            cappedCritChance = Math.min(critChance,1.0);
            critDamage = stats.addedCritDamage;
            shivDamage = 100 * .1;
            shivDamage=shivDamage+(shivDamage*cappedCritChance*(1+critDamage));
            toReturn += shivDamage;
        }
        if (toReturn != 0)
        {
            b.addLineToNotes("CALCULATION OF BONUS MAGICAL DAMAGE PER ATTACK: ");
            if (b.getBuildInfo().hasPassive(CPassive.NASHOR_PASSIVE))
            {
                b.addLineToNotes(" - Nashors Tooth adds (AP × 15% to the attack, or "+b.getBuildInfo().abilityPower +" × .15 = "+(b.getBuildInfo().abilityPower * .15));
                b.addLineToNotes(" - It also adds another flat 15 damage.");
            }
            if (b.getBuildInfo().hasPassive(CPassive.WITS_END_PASSIVE))
            {
                b.addLineToNotes(" - Wits End adds 42 damage.");
            }
            if (b.getBuildInfo().hasPassive(CPassive.FERAL_FLARE_PASSIVE))
            {
                b.addLineToNotes(" - Feral flare adds 55 damage (Because we assume super late game).");
            }
            if (b.getBuildInfo().hasPassive(CPassive.STATIKK_PASSIVE))
            {
                b.addLineToNotes(" - Assume stattick shiv (100 extra damage) goes off 10% of the time:");
                b.addLineToNotes("   - 10 damage with a "+cappedCritChance*100+"% chance of doing "+(1+critDamage)*100+"% normal damage:");
                b.addLineToNotes("   - 10 + (10 × ("+cappedCritChance*100+" × "+(1+critDamage)*100+"%))");
                b.addLineToNotes("   - "+shivDamage+" extra damage from Shiv");
            }
            b.addLineToNotes(" - Subtotal bonus damage per attack: "+toReturn);
            toReturn = this.applyEnemyMagicResist(toReturn, b, enemy);
            b.addLineToNotes(" - final bonus damage per attack: "+toReturn);
        }
        
        return toReturn;
    }
    
    protected double getLifeStolenPerAttack(Build b, Build enemy) 
    {
        double damage = b.getComponent(HeuristicComponent.BASE_PHYSICAL_DAMAGE_PER_ATTACK, enemy);
        damage += b.getComponent(HeuristicComponent.BONUS_PHYSICAL_DAMAGE_PER_ATTACK, enemy);
        
        double lifeStealPercent = b.getBuildInfo().lifeSteal;
        
        return damage*lifeStealPercent;
    }
    
    protected double getDamagePerSecond(Build b, Build enemy) 
    {
        double totalDamage = b.getComponent(HeuristicComponent.TOTAL_DAMAGE_PER_ATTACK, enemy);
        double attacks = b.getComponent(HeuristicComponent.ATTACKS_PER_SECOND, enemy);
        b.addLineToNotes("CALCULATION OF TOTAL DAMAGE PER SECOND: ");
        b.addLineToNotes(" - As stated earlier, we have "+attacks+" attacks per second.");
        b.addLineToNotes(" - Also stated earlier, we have "+totalDamage+" damage per attack.");
        b.addLineToNotes(" - multiply that by "+attacks+" to give you a total of "+attacks*(totalDamage));
        
        return attacks*(totalDamage);
    }

    protected double getTotalDamagePerAttack(Build b, Build enemy) 
    {
        double basePhysicalDamage = b.getComponent(HeuristicComponent.BASE_PHYSICAL_DAMAGE_PER_ATTACK, enemy);
        double bonusPhysicalDamage = b.getComponent(HeuristicComponent.BONUS_PHYSICAL_DAMAGE_PER_ATTACK, enemy);
        double bonusMagicDamage = b.getComponent(HeuristicComponent.MAGIC_DAMAGE_PER_ATTACK, enemy);
        double totalDamage = basePhysicalDamage+bonusPhysicalDamage+bonusMagicDamage;
        b.addLineToNotes("CALCULATION OF DAMAGE PER ATTACK: ");
        b.addLineToNotes(" - Also stated earlier, we have "+basePhysicalDamage+" base damage.");
        b.addLineToNotes("                              + "+bonusPhysicalDamage+" bonus damage.");
        b.addLineToNotes("                              + "+bonusMagicDamage+" magic damage.");
        b.addLineToNotes("                                -----------------------------------");
        b.addLineToNotes("                              = "+totalDamage+" total damage. ");
        return totalDamage;
    }

    protected double getLifeStolenPerSecond(Build b, Build enemy) 
    {
        double attacks = b.getComponent(HeuristicComponent.ATTACKS_PER_SECOND, enemy);
        double lifesteal = b.getComponent(HeuristicComponent.LIFE_STOLEN_PER_ATTACK, enemy);
        return attacks*lifesteal;
    }
    
    protected double getEnemyArmorDamageMultiplier(Build b, Build enemy) 
    {
        double armor = enemy.getBuildInfo().armor;
        b.addLineToNotes("CALCULATION OF DAMAGE MULTIPLIER DUE TO ENEMY ARMOR:");
        b.addLineToNotes(" - Enemy armor is "+armor);
        
        if (b.getBuildInfo().armorPenetrationPercent > 0)
        {
            double apenpercent = b.getBuildInfo().armorPenetrationPercent;
            armor*=(1.0-apenpercent);
            b.addLineToNotes(" - It is reduced to "+((1.0-apenpercent)*100)+" % effectiveness by our "+(apenpercent*100)+"% Armor Penetration, leaving it at "+armor+".");
        }

        if (b.getBuildInfo().armorPenetrationFlat > 0)
        {
            double apenflat = b.getBuildInfo().armorPenetrationFlat;
            armor-=apenflat;
            b.addLineToNotes(" - It is reduced by another "+apenflat+" by our flat armor penetration, leaving it at "+armor);
        }
        
        if (armor < 0)
        {
            armor = 0;
            b.addLineToNotes(" - This is below zero, so we set armor to "+armor);
        }
        
        double ratio = (100.0/(100.0+armor));
        
        b.addLineToNotes(" - the armor ratio is:  (100)/(100+"+armor+") = "+ratio+".");
        
        return ratio;
    }
    
    protected double getEnemyMagicResistDamageMultiplier(Build b, Build enemy) 
    {
        double mr = enemy.getBuildInfo().magicResist;
        b.addLineToNotes("CALCULATION OF DAMAGE MULTIPLIER DUE TO ENEMY MAGIC RESIST:");
        b.addLineToNotes(" - Enemy magic resist is "+mr);
        
        if (b.getBuildInfo().hasPassive(CPassive.WITS_END_PASSIVE))
        {
            mr-=12.5;
            b.addLineToNotes(" - We assume your opponent has an average of 2.5 stacks of wits end on him. That's -12.5 Magic resist, for "+mr+" resist. ");
        }
        
        if (b.getBuildInfo().magicPenetrationPercent > 0)
        {
            double mpenpercent = b.getBuildInfo().magicPenetrationPercent;
            mr*=(1.0-mpenpercent);
            b.addLineToNotes(" - It is reduced to "+((1.0-mpenpercent)*100)+" % effectiveness by our "+(mpenpercent*100)+"% Magic Penetration, leaving it at "+mr+".");
        }

        if (b.getBuildInfo().magicPenetrationFlat > 0)
        {
            double mpenflat = b.getBuildInfo().magicPenetrationFlat;
            mr-=mpenflat;
            b.addLineToNotes(" - It is reduced by another "+mpenflat+" by our flat magic penetration, leaving it at "+mr);
        }
        
        if (mr < 0)
        {
            mr = 0;
            b.addLineToNotes(" - This is below zero, so we set magic resist to "+mr);
        }
        
        double ratio = (100.0/(100.0+mr));
        
        b.addLineToNotes(" - the magic resist ratio is:  (100)/(100+"+mr+") = "+ratio+".");
        
        return ratio;
    }

    protected double applyEnemyArmor(double damage, Build b, Build enemy) 
    {
        double ratio = b.getComponent(HeuristicComponent.ENEMY_ARMOR_DAMAGE_MULTIPLIER, enemy);
        double newDamage = damage * ratio;
        
        b.addLineToNotes("   - The damage of "+damage+" is multiplied by the armor ratio: "+ratio+", leaving us with "+newDamage+".");
        
        return newDamage;
    }
    
    protected double applyEnemyMagicResist(double damage, Build b, Build enemy) 
    {
        double ratio = b.getComponent(HeuristicComponent.ENEMY_MAGIC_RESIST_DAMAGE_MULTIPLIER, enemy);
        double newDamage = damage * ratio;
        
        b.addLineToNotes("   - The damage of "+damage+" is multiplied by the magic resist ratio: "+ratio+", leaving us with "+newDamage+".");
        
        return newDamage;
    }

    public Object getColorString() 
    {
        return "0";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Poke damage represents the damage dealt by a single "Quick combo." For a
     * generic character, let's assume this is just an auto-attack.
     * @param b the build doing the poking.
     * @param enemy the enemy being poked.
     * @return 
     */
    public double getPokeDamage(Build b, Build enemy) 
    {
        double totalDamage = b.getComponent(HeuristicComponent.TOTAL_DAMAGE_PER_ATTACK, enemy);
        b.addLineToNotes("CALCULATION OF POKE DAMAGE:");
        b.addLineToNotes(" - The character pokes with an auto attack, doing, as previously stated, "+totalDamage+"damage.");
        if (b.getBuildInfo().hasPassive(CPassive.STATIKK_PASSIVE))
        {
            double critChance = b.getBuildInfo().critChance;
            double critDamage = b.getBuildInfo().addedCritDamage;
            double cappedCritChance = Math.min(critChance,1.0);
            double shivDamage = 100 * .9;
            shivDamage=shivDamage+(shivDamage*cappedCritChance*(1+critDamage));
            b.addLineToNotes(" - Assuming this is a fully charged poke, stattick shiv deals more damage:");
            b.addLineToNotes(" - Assume stattick shiv (100 extra damage) goes off an extra 90% of the time (total 100%):");
            b.addLineToNotes("   - 90 damage with a "+cappedCritChance*100+"% chance of doing "+(1+critDamage)*100+"% normal damage:");
            b.addLineToNotes("   - 90 + (90 × ("+cappedCritChance*100+" × "+(1+critDamage)*100+"%))");
            b.addLineToNotes("   - "+shivDamage+" extra damage from Shiv");
            shivDamage = this.applyEnemyMagicResist(shivDamage, b, enemy);
            totalDamage += shivDamage;
        }
        b.addLineToNotes(" - Total of "+totalDamage+" poke damage.");
        return totalDamage;
    }
    
    public double getTotalDamagePerWDamage(Build b, Build enemy) 
    {
        throw new UnsupportedOperationException("Abstract characters have no W!");
    }
}
