/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.fights;

import java.util.List;

/**
 *
 * @author Talonos
 */
public abstract class TimedFightEvent {

    public abstract Combatant getSource();

    public abstract List<TimedFightEvent> resolve();

    public abstract double getTime();
    
}
