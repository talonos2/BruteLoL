/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.lib;

import brutelol.buildobjs.Build;
import brutelol.buildobjs.ItemSet;
import brutelol.buildobjs.MasterySet;
import brutelol.buildobjs.RunePage;

/**
 *
 * @author Talonos
 */
public abstract class AbstractLolCharacter implements LolCharacter
{
    //Variables representing the starting state
    protected double HP_AT_0 = 0;
    protected double HP_REGEN_AT_0 = 0;
    protected double MANA_AT_0 = 0;
    protected double MANA_REGEN_AT_0 = 0;
    protected double ATTACK_DAMAGE_AT_0 = 0;
    protected double ARMOR_AT_0 = 0;
    protected double MAGIC_RES_AT_0 = 0;
    
    //Attack speed is calculated different.
    protected double ATTACK_SPEED_AT_1 = 0;

    //Variables representing the growth per level.
    protected double HP_PER_LEVEL = 0;
    protected double HP_REGEN_PER_LEVEL = 0;
    protected double MANA_PER_LEVEL = 0;
    protected double MANA_REGEN_PER_LEVEL = 0;
    protected double ATTACK_DAMAGE_PER_LEVEL = 0;
    protected double ATTACK_SPEED_PER_LEVEL = 0;
    protected double ARMOR_PER_LEVEL = 0;
    protected double MAGIC_RES_PER_LEVEL = 0;
    
    //Variables representing more constant attributes.
    protected double MOVE_SPEED = 0;
    protected double RANGE = 0;
}
