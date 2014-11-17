/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.instances;

import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.characters.lib.HeuristicComponent;
import brutelol.charbuild.Build;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class Minions extends AbstractLolCharacter
{

    public Minions() 
    {
        //Variables representing the starting state
        this.HP_AT_0 = 750;
        this.HP_REGEN_AT_0 = 0;
        this.MANA_AT_0 = 0;
        this.MANA_REGEN_AT_0 = 0;
        this.ATTACK_DAMAGE_AT_0 = 0;
        this.ARMOR_AT_0 = 0;
        this.MAGIC_RES_AT_0 = 0;
    
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
    public double getComponentUtility(Build b, Build enemy, HeuristicComponent selectedHeuristic) 
    {
        throw new UnsupportedOperationException("Not supported on minions."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HeuristicComponent> supportedComponents() 
    {
        throw new UnsupportedOperationException("Not supported on minions."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInfo(Build b) 
    {
        throw new UnsupportedOperationException("Not supported on minions."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BuildInfo getBuildInfo(Build b) 
    {
        BuildInfo info = new BuildInfo(this, b);
        return info;
    }
}
