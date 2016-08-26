/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.instances;

import brutelol.characters.lib.BuildInfo;
import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.characters.lib.HeuristicComponent;
import brutelol.charbuild.Build;
import brutelol.items.abstracts.CPassive;
import brutelol.items.instances.BerserkersGreaves;
import brutelol.items.instances.Bloodthirster;
import brutelol.items.instances.LastWhisper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class AsheReworked extends AbstractLolCharacter
{    
   private double VOLLEY_PERCENT;
   
   public AsheReworked()
    {
        //Required items; lacking these will cause problems.
        this.requiredItems.add(BerserkersGreaves.class);
        //this.requiredItems.add(Bloodthirster.class);
        //this.requiredItems.add(LastWhisper.class);
        //this.requiredItems.add(ArdentCenser.class);
        
        //Variables representing the starting state
        this.HP_AT_0 = 527.72;
        this.HP_REGEN_AT_0 = 5.42;
        this.MANA_AT_0 = 231.8;
        this.MANA_REGEN_AT_0 = 6.97;
        this.ATTACK_DAMAGE_AT_0 = 51.088;
        this.ARMOR_AT_0 = 21.212;
        this.MAGIC_RES_AT_0 = 30;
    
        //Attack speed is calculated different.
        this.ATTACK_SPEED_AT_1 = .658;

        //Variables representing the growth per level.
        this.HP_PER_LEVEL = 79;
        this.HP_REGEN_PER_LEVEL = .55;
        this.MANA_PER_LEVEL = 35;
        this.MANA_REGEN_PER_LEVEL = .4;
        this.ATTACK_DAMAGE_PER_LEVEL = 2.85;
        this.ATTACK_SPEED_PER_LEVEL = .0333;
        this.ARMOR_PER_LEVEL = 3.4;
        this.MAGIC_RES_PER_LEVEL = 0;
    
        //Variables representing more constant attributes.
        this.MOVE_SPEED = 325;
        this.RANGE = 600;
        
        //Variables representing assumptions about baseline performance.
        this.VOLLEY_PERCENT = .7;
    }

    /**
     * When passed a build, returns a numeric representation of how good that 
     * build is at fulfilling the heuristic.
     * @param b the build to evaluate.
     * @param h the component heuristic to get
     * @param selectedHeuristic the heuristic to evaluate.
     * @return 
     */
    @Override
    public double getComponentUtility(Build b, Build enemy, HeuristicComponent h) 
    {
        if (this.missingItems(b.getItems()))
        {
            b.addLineToNotes("Failed because required items are not included!");
            return -0.5;
        }
        //System.out.println("Here at "+h);
        switch(h)
        {
            case BASE_PHYSICAL_DAMAGE_PER_ATTACK:
                return this.getBasePhysicalDamagePerAttack(b, enemy);
            case BONUS_PHYSICAL_DAMAGE_PER_ATTACK:
                return this.getBonusPhysicalDamagePerAttack(b, enemy);
            case MAGIC_DAMAGE_PER_ATTACK:
                return this.getMagicDamagePerAttack(b, enemy, true);
            case ATTACKS_PER_SECOND:
                return this.getAttacksPerSecond(b);
            case LIFE_STOLEN_PER_ATTACK:
                return getLifeStolenPerAttack(b, enemy);
            case LIFE_STOLEN_PER_SECOND:
                return getLifeStolenPerSecond(b, enemy);
            case DAMAGE_PER_SECOND:
                return getDamagePerSecond(b, enemy);
            case ENEMY_ARMOR_DAMAGE_MULTIPLIER:
                return getEnemyArmorDamageMultiplier(b, enemy);
            case ENEMY_MAGIC_RESIST_DAMAGE_MULTIPLIER:
                return getEnemyMagicResistDamageMultiplier(b, enemy);
            case POKE_DAMAGE:
                return getPokeDamage(b, enemy);
            case TOTAL_DAMAGE_PER_ATTACK:
                return getTotalDamagePerAttack(b, enemy);
            default:
                throw new IllegalArgumentException("Bad HeuristicComponent: "+h);
        }
        //return getUtilityAtPointInTime(b.getItems(), h, 100000, 100000, b.getRunes());
    }

    @Override
    public List<HeuristicComponent> supportedComponents() 
    {
        List<HeuristicComponent> toReturn = new ArrayList<>();
        toReturn.add(HeuristicComponent.DAMAGE_PER_SECOND);
        toReturn.add(HeuristicComponent.LIFE_STOLEN_PER_SECOND);
        toReturn.add(HeuristicComponent.BURST_DAMAGE);
        toReturn.add(HeuristicComponent.DAMAGE_PER_ATTACK);
        toReturn.add(HeuristicComponent.KITING_DAMAGE_PER_SECOND);
        toReturn.add(HeuristicComponent.TIME_SURVIVING_AGAINST);
        toReturn.add(HeuristicComponent.MAGIC_BURST_HP);
        toReturn.add(HeuristicComponent.PHYSICAL_BURST_HP);
        toReturn.add(HeuristicComponent.COST);
        return toReturn;
    }

    @Override
    public String getInfo(Build b) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BuildInfo getBuildInfo(Build b, StringBuilder mathNotes) 
    {
        BuildInfo info = new BuildInfo(this, b, mathNotes);
        return info;
    }
    
    @Override
    protected double getBasePhysicalDamagePerAttack(Build b, Build enemy) 
    {
        BuildInfo stats = b.getBuildInfo();
        
        double critChance = stats.critChance;
        double cappedCritChance = Math.min(critChance,1.0);
        
        //Calculate basic damage.
        double damagePerAttack = 0;
        damagePerAttack+=stats.attackDamage;
        
        //Add crit modifiers.
        double damageIncludingCrits = damagePerAttack*(1.1+cappedCritChance*(1+stats.addedCritDamage));
        
        b.addLineToNotes("SPECIAL CALCULATION OF ASHE'S BASE PHYSICAL DAMAGE PER ATTACK: ");
        b.addLineToNotes(" - Crit chance is "+(critChance*100)+"%.");
        if (critChance >= 1.0)
        {
            b.addLineToNotes(" - That's above the crit chance cap, so we cap it at "+(cappedCritChance*100)+"%");
        }
        b.addLineToNotes(" - Base attack damage is "+damagePerAttack+"×1.1"+".");
        b.addLineToNotes(" - Assuming target is already slowed (Average case scenareo): "+damagePerAttack+"×"+cappedCritChance+"×(1 + "+stats.addedCritDamage+").");
        b.addLineToNotes(" - Total damage so far is "+damageIncludingCrits+".");
        b.addLineToNotes(" - We then apply enemy armor: ");
        
        //Apply Armor
        double damageAfterArmor = applyEnemyArmor(damageIncludingCrits, b, enemy);
        
        b.addLineToNotes(" - Final base physical damage per attack: "+damageAfterArmor);
        
        return damageAfterArmor;
    }

    //@Override
    public double getPokeDamarge(Build b, Build enemy) 
    {
        double volley = b.getComponent(HeuristicComponent.TOTAL_DAMAGE_PER_W, enemy);
        double aa = b.getComponent(HeuristicComponent.TOTAL_DAMAGE_PER_ATTACK, enemy);
        double totalBad = getJunkAADamage(b, enemy);
        b.addLineToNotes("CALCULATION OF ASHE'S POKE DAMAGE:");
        b.addLineToNotes(" - Assume, for a poke, you try to hit with both an auto and a volley:");
        b.addLineToNotes(" - The volley applies frost, and the AA goes off as normal if the volley hits.");
        b.addLineToNotes(" - BUT Let's assume you only hit with the volley "+(VOLLEY_PERCENT*100)+"% of the time.");
        b.addLineToNotes(" - On a miss, the AA is kinda junky, because it can't crit.");
        b.addLineToNotes("   - On a hit, as previously mentioned, a volley does "+volley+" damage.");
        b.addLineToNotes("   - the AA does "+aa+"damage.");
        double shivDamage = 0;
        if (b.getBuildInfo().hasPassive(CPassive.STATIKK_PASSIVE))
        {
            double critChance = b.getBuildInfo().critChance;
            double critDamage = b.getBuildInfo().addedCritDamage;
            double cappedCritChance = Math.min(critChance,1.0);
            shivDamage = 100 * .9;
            shivDamage=shivDamage+(shivDamage*cappedCritChance*(1+critDamage));
            b.addLineToNotes("   - Assuming this is a fully charged poke, stattick shiv deals more damage:");
            b.addLineToNotes("   - Assume stattick shiv (100 extra damage) goes off an extra 90% of the time beyond previously calculated (total 100%):");
            b.addLineToNotes("     - 90 damage with a "+cappedCritChance*100+"% chance of doing "+(1+critDamage)*100+"% normal damage:");
            b.addLineToNotes("     - 90 + (90 × ("+cappedCritChance*100+" × "+(1+critDamage)*100+"%))");
            b.addLineToNotes("     - "+shivDamage+" extra damage from Shiv");
            shivDamage = this.applyEnemyMagicResist(shivDamage, b, enemy);
        }
        double totalgood = volley+aa+shivDamage;
        b.addLineToNotes("   - That's a total of "+totalgood+" damage.");
        b.addLineToNotes("   - On a failed hit, you do "+totalBad+" damage.");
        double totalDamage = totalgood*VOLLEY_PERCENT+totalBad*(1-VOLLEY_PERCENT);
        b.addLineToNotes("   - that's a total of "+(VOLLEY_PERCENT*100)+"% × "+totalgood+" + "+((VOLLEY_PERCENT-1)*100)+"% × "+totalBad+" = "+totalDamage+" total damage.");
        
        

        
        return totalDamage;
    }

    private double getJunkAADamage(Build b, Build enemy) 
    {
        double bonusPhysicalDamage = b.getComponent(HeuristicComponent.BONUS_PHYSICAL_DAMAGE_PER_ATTACK, enemy);
        b.addLineToNotes("CALCULATION OF JUNKY AA DAMAGE:");
        BuildInfo stats = b.getBuildInfo();

        //Calculate basic damage.
        double damagePerAttack=stats.attackDamage;
        
        b.addLineToNotes(" - Basic attack damage (which cannot crit) is "+damagePerAttack);
        b.addLineToNotes(" - We then apply enemy armor: ");
        
        //Apply Armor
        double damageAfterArmor = applyEnemyArmor(damagePerAttack, b, enemy);
        damageAfterArmor += bonusPhysicalDamage;
        
        b.addLineToNotes(" - To this, we add the previously calculated "+bonusPhysicalDamage+" bonus physical damage, totalling "+damageAfterArmor);
        
        b.addLineToNotes(" - To this, we add an adjusted magical damage: ");
        
        double magic = this.getMagicDamagePerAttack(b, enemy, false);
        
        b.addLineToNotes(" - Final Damage per junky auto-attack: "+damageAfterArmor);
        
        return damageAfterArmor;
    }


}
