/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.fights;

import brutelol.characters.instances.abilities.RamDefensiveBallCurl;
import brutelol.characters.instances.abilities.RamTremors;
import brutelol.characters.instances.abilities.BasicAttack;
import java.util.List;

/**
 * Represents a thing a champion can do, such as a QWER, or an auto, or an item active, etc.
 * @author Talonos
 */
public abstract class Ability 
{
    public static Ability AUTO_ATTACK = new BasicAttack();
    public static Ability DEFENSIVE_BALL_CURL = new RamDefensiveBallCurl();
    public static Ability TREMORS = new RamTremors();

    /**
     * Resolves an ability. Target selection is done HERE, "Targets" is an array of possible targets.
     * @param user the person using the ability.
     * @param targets The targets of the ability.
     */
    public abstract List<TimedFightEvent> resolve(Combatant user, List<Combatant> targets);
    
    public static double applyArmor(double damage, Combatant enemy) 
    {
        double armor = enemy.getArmor();
        double ratio = (100.0/(100.0+armor));
        return ratio*damage;
    }
    
    public static double applyMagicResist(double damage, Combatant enemy) 
    {
        double resist = enemy.getMagicResist();
        double ratio = (100.0/(100.0+resist));
        return ratio*damage;
    }

    public abstract double getCooldown(Combatant user);    
}
