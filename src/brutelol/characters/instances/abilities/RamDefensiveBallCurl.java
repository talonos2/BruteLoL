/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.instances.abilities;

import brutelol.fights.Ability;
import brutelol.fights.Combatant;
import brutelol.fights.TimedFightEvent;
import java.util.ArrayList;
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
        return 6*(1.0-user.getCDR());
    }

    @Override
    public List<TimedFightEvent> resolve(Combatant user, List<Combatant> targets) 
    {
        System.out.println("Rammus uses Defensive Ball Curl!");
        TimedFightEvent ballCurlEnd = new RamDBCEndFightEvent(user, this);
        user.gainStatusEffect(StatusEffect.RAM_DBC);
        
        List<TimedFightEvent> toReturn = new ArrayList<>();
        toReturn.add(ballCurlEnd);
        return toReturn;
    }
    
}
