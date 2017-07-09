/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.instances.abilities;

import brutelol.fights.Ability;
import brutelol.fights.AbilityUse;
import brutelol.fights.Combatant;
import brutelol.fights.TimedFightEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class RamTremors extends Ability {

    public RamTremors() {
    }
    
    @Override
    public List<TimedFightEvent> resolve(Combatant user, List<Combatant> targets) 
    {
        TimedFightEvent tremor = new RamTremorFightEvent(user, targets, (user.getChar().getBuild().getLevel()-1)/5);
        List<TimedFightEvent> toReturn = new ArrayList<>();
        toReturn.add(tremor);
        toReturn.add(new AbilityUse(user, targets, this));
        return toReturn;
    }


    @Override
    public double getCooldown(Combatant user) 
    {
        double cd = 1000000;
        if (user.getChar().getBuild().getLevel() >= 6)
        {
            cd = 100;
        }
        if (user.getChar().getBuild().getLevel() >= 11)
        {
            cd = 80;
        }
        if (user.getChar().getBuild().getLevel() >= 16)
        {
            cd = 60;
        }
        cd *= (1.0-user.getCDR());
        return cd;
    }
}
