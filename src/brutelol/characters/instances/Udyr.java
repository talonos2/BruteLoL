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
import brutelol.items.instances.BootsOfSwiftness;
import brutelol.items.instances.NashorsTooth;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class Udyr extends AbstractLolCharacter
{
    //To figure out lifesteal health gain
    private double TIME_SPENT_AUTOATTACKING = .5;
    private double STANCE_CD = 6;
    
    public Udyr()
    {
        //Required items; lacking these will cause problems.
        //this.requiredItems.add(BootsOfSpeed.class);
        //this.requiredItems.add(ArdentCenser.class);
        
        //Variables representing the starting state
        this.HP_AT_0 = 427;
        this.HP_REGEN_AT_0 = 7.45;
        this.MANA_AT_0 = 220;
        this.MANA_REGEN_AT_0 = 6.75;
        this.ATTACK_DAMAGE_AT_0 = 52.91;
        this.ARMOR_AT_0 = 18.75;
        this.MAGIC_RES_AT_0 = 30;;
    
        //Attack speed is calculated different.
        this.ATTACK_SPEED_AT_1 = .658;

        //Variables representing the growth per level.
        this.HP_PER_LEVEL = 99;
        this.HP_REGEN_PER_LEVEL = .75;
        this.MANA_PER_LEVEL = 30;
        this.MANA_REGEN_PER_LEVEL = .45;
        this.ATTACK_DAMAGE_PER_LEVEL = 3.2;
        this.ATTACK_SPEED_PER_LEVEL = .0267;
        this.ARMOR_PER_LEVEL = 4;
        this.MAGIC_RES_PER_LEVEL = 1.25;
    
        //Variables representing more constant attributes.
        this.MOVE_SPEED = 345;
        this.RANGE = 125;
        
        this.requiredItems.add(BootsOfSwiftness.class);
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
                return getMagicDamagePerAttack(b, enemy);
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
            case STANCE_COOLDOWN:
                return getStanceCooldown(b);
            default:
                throw new IllegalArgumentException("Bad HeuristicComponent: "+h);
        }
    }
    
    @Override
    protected double getMagicDamagePerAttack(Build b, Build enemy) 
    {
        double base = super.getMagicDamagePerAttack(b, enemy);
        double cooldown = b.getComponent(HeuristicComponent.STANCE_COOLDOWN, enemy);
        b.addLineToNotes("BECAUSE WE ARE UDYR, WE ADD TO THE EXTRA MAGIC DAMAGE AS FOLLOWS:");
        
        double timePerRotation = cooldown;
        double timePerPhoenix = cooldown-2;
        double timeInPhoenix = timePerPhoenix/timePerRotation;

        b.addLineToNotes(" - We are in phoenix stance whenever we are able. A rotation is : "+cooldown+" seconds, and we're in tiger for 2 of them.");
        b.addLineToNotes(" - That implies we're in phoenix for "+timePerPhoenix+" seconds out of "+cooldown+", or "+(timeInPhoenix*100)+"% of the time.");
        
        double damagePerPhoenixBurst = 200+(b.getBuildInfo().abilityPower * .45);
        
        b.addLineToNotes(" - Every \"Phoenix burst\", we deal 200+"+b.getBuildInfo().abilityPower+" * 45%, or "+damagePerPhoenixBurst+" damage.");
        
        double toReturn = timeInPhoenix*damagePerPhoenixBurst*.333;
        
        b.addLineToNotes(" - One out of three attacks is a burst while in phoenix. That's "+timeInPhoenix+"*.333*"+timeInPhoenix+" is "+toReturn);
        toReturn = this.applyEnemyMagicResist(toReturn, b, enemy);
        b.addLineToNotes(" - So, the base damage of "+base+" plus the new phoenix damage of "+toReturn+" is "+(base+toReturn));
        
        return base+toReturn;
    }
    
    @Override
    protected double getDamagePerSecond(Build b, Build enemy) 
    {
        double base = super.getDamagePerSecond(b, enemy);
        b.addLineToNotes("BECAUSE WE ARE UDYR, WE ADJUST THE DAMAGE OF "+base+" AS FOLLOWS:");
        
        double cooldown = b.getComponent(HeuristicComponent.STANCE_COOLDOWN, enemy);
        
        double timeBurning = 5.0/cooldown;
        
        double imOnFire = 55+b.getBuildInfo().abilityPower*.25;
        
        b.addLineToNotes(" - Because you are on fire, you deal 55 + "+b.getBuildInfo().abilityPower+" * 25% damage extra per second.");
        b.addLineToNotes(" - That's an extra "+imOnFire+" damage");
        
        imOnFire*=timeBurning;
        b.addLineToNotes(" - Because you are on fire for 5 of the "+cooldown+" seconds, we multiply it by "+timeBurning+" to get "+imOnFire);

        imOnFire = this.applyEnemyMagicResist(imOnFire, b, enemy);
        
        double tigerStrikeDamage = 230 + b.getBuildInfo().attackDamage*1.6;
        
        b.addLineToNotes(" - Every "+cooldown+" seconds, you do a tiger strike for 230 + 160% AD ("+(b.getBuildInfo().attackDamage*1.6)+") damage.");
        b.addLineToNotes(" - That's "+tigerStrikeDamage+" per "+cooldown+" seconds, or "+(tigerStrikeDamage/cooldown)+" damage per second.");
        
        tigerStrikeDamage /= cooldown;
        
        tigerStrikeDamage = this.applyEnemyArmor(tigerStrikeDamage, b, enemy);
        
        b.addLineToNotes(" - So, to our "+base+" damage, we add "+tigerStrikeDamage+" and "+imOnFire+" to get "+(base+imOnFire+tigerStrikeDamage)+".");        
        
        return base+imOnFire+tigerStrikeDamage;
    }
    
    @Override
    protected double getBonusPhysicalDamagePerAttack(Build b, Build enemy) 
    {
        double base = super.getBonusPhysicalDamagePerAttack(b, enemy);
        
        double cooldown = b.getComponent(HeuristicComponent.STANCE_COOLDOWN, enemy);
        
        double timePerRotation = cooldown;
        double timePerTiger = 2;
        
        double timeInTiger = timePerTiger/timePerRotation;
        
        double tigerBuff = b.getBuildInfo().attackDamage*.15*timeInTiger;
        tigerBuff = this.applyEnemyArmor(tigerBuff, b, enemy);
        
        return base+tigerBuff;
    }

    @Override
    public List<HeuristicComponent> supportedComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInfo(Build b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BuildInfo getBuildInfo(Build b) 
    {
        BuildInfo info = new BuildInfo(this, b);
        info.moveSpeed+= 15;
        info.attackSpeed += .30;
        
        double cooldown = STANCE_CD * (1-info.cooldownReduction);
        if (cooldown < 5) {cooldown = 5;}
        double attackSpeed = .7*(5.0/cooldown);
        
        info.attackSpeed += attackSpeed;
        
        return info;
    }    

    private double getStanceCooldown(Build b) 
    {
        b.addLineToNotes("CALCULATION OF STANCE COOLDOWN:");
        b.addLineToNotes(" - Cooldown starts at :"+STANCE_CD);
        b.addLineToNotes(" - Cooldown reduction is "+b.getBuildInfo().cooldownReduction);
        double cooldown = STANCE_CD * (1-b.getBuildInfo().cooldownReduction);
        b.addLineToNotes(" - This gives us a cooldown of "+cooldown+".");
        if (cooldown < 5)
        {
            cooldown = 5;
            b.addLineToNotes(" - Because this is shorter than the ideal stance length of 5, we lengthen it to "+cooldown+".");
        }
        return cooldown;
    }
}
