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
import brutelol.items.instances.BerserkersGreaves;
import brutelol.items.instances.Bloodthirster;
import brutelol.items.instances.LastWhisper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class Ashe extends AbstractLolCharacter
{    
    public Ashe()
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
        this.ATTACK_SPEED_PER_LEVEL = .04;
        this.ARMOR_PER_LEVEL = 3.4;
        this.MAGIC_RES_PER_LEVEL = 0;
    
        //Variables representing more constant attributes.
        this.MOVE_SPEED = 340;
        this.RANGE = 550;
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
                return this.getMagicDamagePerAttack(b, enemy);
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
    public BuildInfo getBuildInfo(Build b) 
    {
        BuildInfo info = new BuildInfo(this, b, null);
        return info;
    }
}
