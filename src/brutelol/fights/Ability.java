/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.fights;

import java.util.List;

/**
 * Represents a thing a champion can do, such as a QWER, or an auto, or an item active, etc.
 * @author Talonos
 */
public abstract class Ability {

    /**
     * Resolves an ability. Target selection is done HERE, "Targets" is an array of possible targets.
     * @param user the person using the ability.
     * @param targets The targets of the ability.
     */
    public abstract void resolve(Combatant user, List<Combatant> targets);
    
}
