/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.fights;

import brutelol.characters.instances.abilities.AblAutoAttack;
import java.util.List;

/**
 * Represents a thing a champion can do, such as a QWER, or an auto, or an item active, etc.
 * @author Talonos
 */
public abstract class Ability 
{
    public static Ability AUTO_ATTACK = new AblAutoAttack();

    /**
     * Resolves an ability. Target selection is done HERE, "Targets" is an array of possible targets.
     * @param user the person using the ability.
     * @param targets The targets of the ability.
     */
    public abstract void resolve(Combatant user, List<Combatant> targets);
    
    protected double applyArmor(double damage, Combatant enemy) 
    {
        double armor = enemy.getArmor();
        double ratio = (100.0/(100.0+armor));
        return ratio*damage;
    }
    
    protected double applyMagicResist(double damage, Combatant enemy) 
    {
        double resist = enemy.getMagicResist();
        double ratio = (100.0/(100.0+resist));
        return ratio*damage;
    }

    double getCooldown(Combatant user) 
    {
        return 10;
    }
    
}
