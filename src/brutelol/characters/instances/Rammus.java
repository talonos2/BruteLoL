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
public class Rammus extends AbstractLolCharacter 
{
    public Rammus(Build b)
    {
        super(b);
        //Required items; lacking these will invalidate a build.
        //this.requiredItems.add(BerserkersGreaves.class);
        
        //Variables representing the starting state
        this.HP_AT_0 = 564.48;
        this.HP_REGEN_AT_0 = 7.92;
        this.MANA_AT_0 = 310.44;
        this.MANA_REGEN_AT_0 = 7.84;
        this.ATTACK_DAMAGE_AT_0 = 55.88;
        this.ARMOR_AT_0 = 31.384;
        this.MAGIC_RES_AT_0 = 32.1;
    
        //Attack speed is calculated different.
        this.ATTACK_SPEED_AT_1 = .625;

        //Variables representing the growth per level.
        this.HP_PER_LEVEL = 86;
        this.HP_REGEN_PER_LEVEL = 0.55;
        this.MANA_PER_LEVEL = 33;
        this.MANA_REGEN_PER_LEVEL = .5;
        this.ATTACK_DAMAGE_PER_LEVEL = 3.5;
        this.ATTACK_SPEED_PER_LEVEL = .02215;
        this.ARMOR_PER_LEVEL = 4.3;
        this.MAGIC_RES_PER_LEVEL = 1.25;
        
        this.MOVE_SPEED = 335;
        this.RANGE = 125;
        
        this.stats = new BuildStats(this, b, null);

    }
    
    public String getName() 
    {
        return "Rammus";
    }
}
