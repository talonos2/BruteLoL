/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.instances;

import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.characters.lib.BuildInfo;
import brutelol.characters.lib.HeuristicComponent;
import brutelol.characters.lib.TargetedHeuristicComponent;
import brutelol.charbuild.Build;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class Xayah extends AbstractLolCharacter 
{
    public Xayah()
    {
        //Required items; lacking these will cause problems.
        //this.requiredItems.add(BerserkersGreaves.class);
        
        //Variables representing the starting state
        this.HP_AT_0 = 545;
        this.HP_REGEN_AT_0 = 6;
        this.MANA_AT_0 = 340;
        this.MANA_REGEN_AT_0 = 8.25;
        this.ATTACK_DAMAGE_AT_0 = 56;
        this.ARMOR_AT_0 = 24;
        this.MAGIC_RES_AT_0 = 30;
    
        //Attack speed is calculated different.
        this.ATTACK_SPEED_AT_1 = .625;

        //Variables representing the growth per level.
        this.HP_PER_LEVEL = 80;
        this.HP_REGEN_PER_LEVEL = .75;
        this.MANA_PER_LEVEL = 40;
        this.MANA_REGEN_PER_LEVEL = .75;
        this.ATTACK_DAMAGE_PER_LEVEL = 2.2;
        this.ATTACK_SPEED_PER_LEVEL = .0206;
        this.ARMOR_PER_LEVEL = 3;
        this.MAGIC_RES_PER_LEVEL = 0;
        
        this.MOVE_SPEED = 325;
        this.RANGE = 525;

    }

    @Override
    public double getComponentUtility(Build b, HeuristicComponent h) 
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
                return this.getBasePhysicalDamagePerAttack(b);
            case BONUS_PHYSICAL_DAMAGE_PER_ATTACK:
                return this.getBonusPhysicalDamagePerAttack(b);
            case BONUS_MAGIC_DAMAGE_PER_ATTACK:
                return this.getMagicDamagePerAttack(b);
            case ATTACKS_PER_SECOND:
                return this.getAttacksPerSecond(b);
            case RAW_DAMAGE_PER_SECOND:
                return getRawDamagePerSecond(b);
            case RAW_TOTAL_DAMAGE_PER_ATTACK:
                return getRawTotalDamagePerAttack(b);
            default:
                throw new IllegalArgumentException("Bad HeuristicComponent: "+h);
        }
    }

    @Override
    public List<HeuristicComponent> supportedComponents() 
    {
        List<HeuristicComponent> toReturn = new ArrayList<>();
        toReturn.add(HeuristicComponent.RAW_DAMAGE_PER_SECOND);
        toReturn.add(HeuristicComponent.RAW_TOTAL_DAMAGE_PER_ATTACK);
        toReturn.add(HeuristicComponent.BONUS_PHYSICAL_DAMAGE_PER_ATTACK);
        toReturn.add(HeuristicComponent.BONUS_MAGIC_DAMAGE_PER_ATTACK);
        toReturn.add(HeuristicComponent.ATTACKS_PER_SECOND);
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
    public double getTargetedComponentUtility(Build b, Build target, TargetedHeuristicComponent selectedHeuristic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
