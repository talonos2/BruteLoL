package brutelol.characters.instances.abilities;

import brutelol.characters.lib.TargetedHeuristicComponent;
import brutelol.fights.Ability;
import brutelol.fights.Combatant;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class AblAutoAttack extends Ability
{

    @Override
    public void resolve(Combatant user, List<Combatant> targets) 
    {
        //For now, just target whoever has the least health, I guess.            
        Combatant target = Collections.max(targets, new HpComparator());
        
        user.getBuild().getBuildInfo().attackSpeed;
    }
    
    private class HpComparator implements Comparator<Combatant> 
    {
    
        @Override
        public int compare(Combatant first, Combatant second) 
        {
            if (first.getCurrentHP() > second.getCurrentHP())
                return 1;
            else if (first.getCurrentHP() < second.getCurrentHP())
                return -1;
            return 0;
        }
    }
}
