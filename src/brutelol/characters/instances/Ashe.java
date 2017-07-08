/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.instances;

import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.characters.lib.BuildStats;
import brutelol.charbuild.Build;

/**
 *
 * @author Talonos
 */
public class Ashe extends AbstractLolCharacter 
{
    public Ashe(Build b)
    {
        super(b);
        
        //Variables representing the starting state
        this.HP_AT_0 = 527.72;
        this.HP_REGEN_AT_0 = 5.424;
        this.MANA_AT_0 = 280;
        this.MANA_REGEN_AT_0 = 6.972;
        this.ATTACK_DAMAGE_AT_0 = 56.508;
        this.ARMOR_AT_0 = 31.384;
        this.MAGIC_RES_AT_0 = 30;
    
        //Attack speed is calculated different.
        this.ATTACK_SPEED_AT_1 = .658;

        //Variables representing the growth per level.
        this.HP_PER_LEVEL = 79;
        this.HP_REGEN_PER_LEVEL = 0.55;
        this.MANA_PER_LEVEL = 32;
        this.MANA_REGEN_PER_LEVEL = .4;
        this.ATTACK_DAMAGE_PER_LEVEL = 2.26;
        this.ATTACK_SPEED_PER_LEVEL = .0333;
        this.ARMOR_PER_LEVEL = 3.4;
        this.MAGIC_RES_PER_LEVEL = .5;
        
        this.MOVE_SPEED = 325;
        this.RANGE = 600;
        
        this.stats = new BuildStats(this, b, null);

    }
    
    public String getName() 
    {
        return "Ashe";
    }
}
