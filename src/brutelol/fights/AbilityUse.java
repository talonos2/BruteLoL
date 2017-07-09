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
public class AbilityUse extends TimedFightEvent
{
    private Combatant user;
    private List<Combatant> targets;
    private Ability ability;
    
    public AbilityUse(Combatant user, List<Combatant> targets, Ability ability)
    {
        this.user = user;
        this.targets = targets;
        this.ability = ability;
    }

    @Override
    public List<TimedFightEvent> resolve() 
    {
        return ability.resolve(user, targets);
    }
    
    public Ability getAbility()
    {
        return ability;
    }

    @Override
    public Combatant getSource() {
                return user;
    }

    @Override
    public double getTime() 
    {
        return ability.getCooldown(user);
    }
    
}
