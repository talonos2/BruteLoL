package brutelol.characters.instances;

import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.characters.lib.BuildInfo;
import brutelol.characters.lib.HeuristicComponent;
import brutelol.charbuild.Build;
import brutelol.items.abstracts.CPassive;
import brutelol.items.instances.BerserkersGreaves;
import java.util.ArrayList;
import java.util.List;

public class MasterYi extends AbstractLolCharacter
{    
   
   public MasterYi()
    {
        //Required items; lacking these will cause problems.
        this.requiredItems.add(BerserkersGreaves.class);
        
        //Variables representing the starting state
        this.HP_AT_0 = 598.56;
        this.HP_REGEN_AT_0 = 7.59;
        this.MANA_AT_0 = 250.56;
        this.MANA_REGEN_AT_0 = 7.255;
        this.ATTACK_DAMAGE_AT_0 = 60.04;
        this.ARMOR_AT_0 = 24.04;
        this.MAGIC_RES_AT_0 = 32.1;
    
        //Attack speed is calculated different.
        this.ATTACK_SPEED_AT_1 = .679;

        //Variables representing the growth per level.
        this.HP_PER_LEVEL = 92;
        this.HP_REGEN_PER_LEVEL = .65;
        this.MANA_PER_LEVEL = 42;
        this.MANA_REGEN_PER_LEVEL = .45;
        this.ATTACK_DAMAGE_PER_LEVEL = 3;
        this.ATTACK_SPEED_PER_LEVEL = .02;
        this.ARMOR_PER_LEVEL = 3;
        this.MAGIC_RES_PER_LEVEL = 1.25;
    
        //Variables representing more constant attributes.
        this.MOVE_SPEED = 355;
        this.RANGE = 125;
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


}
