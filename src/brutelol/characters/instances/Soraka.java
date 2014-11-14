/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.instances;

import brutelol.Funcs;
import brutelol.buildobjs.Build;
import brutelol.buildobjs.ItemSet;
import brutelol.buildobjs.MasterySet;
import brutelol.buildobjs.RunePage;
import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.characters.lib.LolHeuristic;
import brutelol.items.instances.ArdentCenser;
import brutelol.items.instances.BootsOfSpeed;

/**
 *
 * @author Talonos
 */
public class Soraka extends AbstractLolCharacter
{
    //TODO: Ability order. Right now, we're just constantly assuming max. :/
    private double COOLDOWN_OF_INFUSE = 2;
    private double MANA_COST_OF_INFUSE = 40;
    private double HEALING_PER_INFUSE = 240;
    private double PERCENT_AP_ON_INFUSE = .6;
    
    //To figure out lifesteal health gain
    private double TIME_SPENT_AUTOATTACKING = .25;
    
    //For both starcall lifegain types:
    private double STARCALL_MANA_COST = 90;
    private double STARCALL_COOLDOWN = 5;
    
    //To figure out spellvamp starcall health gain.
    private double MINIONS_HIT_PER_STARCALL = 2;
    private double STARCALL_DAMAGE = (230+345)/2;
    private double STARCALL_DAMAGE_AP = (.35+.525)/2;
    
    //To figure out starcall/Infuse synergy health gain.
    private double CHANCE_PER_STARCALL_TO_HIT_CHAMPION = .25;
    private double HEALING_PER_STARCALL = (65+130)/2;
    private double HEALING_PER_STARCALL_AP = .3;
    
    public Soraka()
    {
        //Required items; lacking these will cause problems.
        this.requiredItems.add(BootsOfSpeed.class);
        this.requiredItems.add(ArdentCenser.class);
        
        //Variables representing the starting state
        this.HP_AT_0 = 405;
        this.HP_REGEN_AT_0 = 4.5;
        this.MANA_AT_0 = 240;
        this.MANA_REGEN_AT_0 = 6.8;
        this.ATTACK_DAMAGE_AT_0 = 48.8;
        this.ARMOR_AT_0 = 17;
        this.MAGIC_RES_AT_0 = 30;;
    
        //Attack speed is calculated different.
        this.ATTACK_SPEED_AT_1 = .625;

        //Variables representing the growth per level.
        this.HP_PER_LEVEL = 76;
        this.HP_REGEN_PER_LEVEL = .55;
        this.MANA_PER_LEVEL = 60;
        this.MANA_REGEN_PER_LEVEL = .65;
        this.ATTACK_DAMAGE_PER_LEVEL = 3;
        this.ATTACK_SPEED_PER_LEVEL = .0214;
        this.ARMOR_PER_LEVEL = 3.8;
        this.MAGIC_RES_PER_LEVEL = 0;
    
    //Variables representing more constant attributes.
        this.MOVE_SPEED = 340;
        this.RANGE = 550;
    }

    @Override
    public RunePage optimizeRunepageFor(ItemSet items, MasterySet masteries) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showWork(Build b) 
    {
        this.turnOnNotes();
        this.getFinalUtility(b.getItems(), null);
    }

    /**
     * When passed an itemset, returns a build that best makes use of that itemset.
     * The build is a combination of items, runes, masteries, etc. It also contains
     * a "utility" that can be extracted for comparing purposes.
     * @param items
     * @param selectedHeuristic
     * @return 
     */
    @Override
    public Build getFinalUtility(ItemSet items, LolHeuristic selectedHeuristic) 
    {
        return new Build(getUtilityAtPointInTime(items, selectedHeuristic, 1000000, 1000000, null), items);
    }
    
    public double getUtilityAtPointInTime(ItemSet items, LolHeuristic selectedHeuristic,
            int xp, int time, RunePage runes)
    {
        if (this.missingItems(items))
        {
            return 0;
        }
        
        this.level = Funcs.getLevelFromXP(xp);
        
        BuildInfo stats = new BuildInfo(this, items, runes, null);
        
        double basePhysicalDamagePerAttack = getPhysicalDamagePerAttack(stats);
        double bonusPhysicalDamagePerAttack = getBonusPhysicalDamagePerAttack(stats);
        double numberOfAttacksPerSecond = getOverallAttackSpeed(stats);
        
        ///LIMITING GREAGENT: COOLDOWN
        double cdr = stats.cooldownReduction;
        double cooldownOnInfuse = COOLDOWN_OF_INFUSE * (1-cdr);
        double infusesPerSecondCooldown = 1/cooldownOnInfuse;
        
        ///LIMITING GREAGENT: MANA
        double manaPerSecond = stats.manaRegen;
        //TODO: All passives
        /*if (ii.reaverEffect)
        {
            double manaStolenPerShot = getLifestealPerShot(enemy, physicalDamagePerAttack, 0, ii, mathNotes, .05);
            double manastealPerSecond = numberOfAttacksOn1*manaStolenPerShot;
            manaPerSecond += (manastealPerSecond*TIME_SPENT_AUTOATTACKING);
        }*/
        
        double manaCostOfInfuse = MANA_COST_OF_INFUSE;
        double infusesPerSecondMP = manaPerSecond/manaCostOfInfuse;
        
        ///LIMITING GREAGENT: HEALTH
        double lifestealPerShotAgainstEnemy = getLifestealPerShot(stats);
        double lifestealPerSecond = numberOfAttacksPerSecond*lifestealPerShotAgainstEnemy;
        
        double healthRegennedPerSecond = stats.healthRegen/5;
        double extraHealthPerSecond = 0;

        //Conditional: If we have mana to spare.
        if (infusesPerSecondMP > infusesPerSecondCooldown)
        {
            double spareManaPerSecond = manaPerSecond - (manaCostOfInfuse*infusesPerSecondCooldown);
            double starcallsPerSecond = spareManaPerSecond/STARCALL_MANA_COST;
            starcallsPerSecond = Math.min(starcallsPerSecond, STARCALL_COOLDOWN/(1-cdr));
            double healthStolenPerStarcallNative = (HEALING_PER_STARCALL + HEALING_PER_STARCALL_AP*stats.abilityPower)*CHANCE_PER_STARCALL_TO_HIT_CHAMPION;
            double healthStolenStarcallPerSecond = healthStolenPerStarcallNative*starcallsPerSecond;
            double spellvampStarcall = (STARCALL_DAMAGE+STARCALL_DAMAGE_AP*stats.abilityPower)*stats.spellvamp/3*MINIONS_HIT_PER_STARCALL;
            double spellvampStarcallPerSecond = spellvampStarcall*starcallsPerSecond;
            extraHealthPerSecond = healthStolenStarcallPerSecond+spellvampStarcallPerSecond;
        }
        
        double healthPerSecond = (lifestealPerSecond*TIME_SPENT_AUTOATTACKING)+healthRegennedPerSecond+extraHealthPerSecond;
        double costOfInfuse = stats.hp/10;
        double infusesPerSecondHP = healthPerSecond/costOfInfuse;
        
        
        double healingPerInfuse = HEALING_PER_INFUSE+PERCENT_AP_ON_INFUSE*stats.abilityPower;
        
        double infusesPerSecond = Math.min(infusesPerSecondCooldown, Math.min(infusesPerSecondHP, infusesPerSecondMP));
        
        return healingPerInfuse * infusesPerSecond;
    }
}
