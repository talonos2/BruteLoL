/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brutelol.characters.lib;

/**
 *
 * @author Emily
 */
public enum HeuristicComponent 
{
    BASE_PHYSICAL_DAMAGE_PER_ATTACK,
    BONUS_PHYSICAL_DAMAGE_PER_ATTACK,
    MAGIC_DAMAGE_PER_ATTACK,
    ATTACKS_PER_SECOND,
    LIFE_STOLEN_PER_ATTACK,
    LIFE_STOLEN_PER_SECOND,
    HEALING_PER_SECOND, 
    DAMAGE_PER_SECOND,
    ENEMY_ARMOR_DAMAGE_MULTIPLIER,
    ENEMY_MAGIC_RESIST_DAMAGE_MULTIPLIER,
    STANCE_COOLDOWN, 
    BURST_DAMAGE, 
    DAMAGE_PER_ATTACK, 
    KITING_DAMAGE_PER_SECOND, 
    TIME_SURVIVING_AGAINST, 
    MAGIC_BURST_HP, 
    PHYSICAL_BURST_HP, 
    COST;

    public String getName() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getBoldPostfix() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getNotBoldPostfix() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
