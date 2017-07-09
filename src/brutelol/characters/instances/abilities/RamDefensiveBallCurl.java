/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.instances.abilities;

import brutelol.fights.Ability;
import brutelol.fights.Combatant;
import brutelol.fights.TimedFightEvent;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class RamDefensiveBallCurl extends Ability 
{

    public RamDefensiveBallCurl() {
    }


    @Override
    public double getCooldown(Combatant user) 
    {
        return 6*user.getCDR();
    }

    @Override
    public List<TimedFightEvent> resolve(Combatant user, List<Combatant> targets) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
