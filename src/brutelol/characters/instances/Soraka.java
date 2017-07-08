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
public class Soraka extends AbstractLolCharacter 
{

    public Soraka(Build b)
    {
        super(b);
        //Required items; lacking these will invalidate a build.
        //this.requiredItems.add(BerserkersGreaves.class);
        
        //Variables representing the starting state
        this.HP_AT_0 = 529.04;
        this.HP_REGEN_AT_0 = 2.5;
        this.MANA_AT_0 = 350.8;
        this.MANA_REGEN_AT_0 = 11.5;
        this.ATTACK_DAMAGE_AT_0 = 50.04;
        this.ARMOR_AT_0 = 23.384;
        this.MAGIC_RES_AT_0 = 30;
    
        //Attack speed is calculated different.
        this.ATTACK_SPEED_AT_1 = .625;

        //Variables representing the growth per level.
        this.HP_PER_LEVEL = 78;
        this.HP_REGEN_PER_LEVEL = 0.5;
        this.MANA_PER_LEVEL = 60;
        this.MANA_REGEN_PER_LEVEL = .4;
        this.ATTACK_DAMAGE_PER_LEVEL = 3;
        this.ATTACK_SPEED_PER_LEVEL = .0214;
        this.ARMOR_PER_LEVEL = 3.8;
        this.MAGIC_RES_PER_LEVEL = .5;
        
        this.MOVE_SPEED = 325;
        this.RANGE = 550;
        
        this.stats = new BuildStats(this, b, null);
    }
    
    public String getName() 
    {
        return "Soraka";
    }
}