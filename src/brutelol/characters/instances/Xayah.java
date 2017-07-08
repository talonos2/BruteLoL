/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.instances;

import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.characters.lib.BuildStats;
import brutelol.charbuild.Build;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class Xayah extends AbstractLolCharacter 
{
    public Xayah(Build b)
    {
        super(b);
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

    
}
