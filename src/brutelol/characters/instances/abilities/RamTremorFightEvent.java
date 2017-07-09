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
public class RamTremorFightEvent extends TimedFightEvent {
    
    private int timesRun = 0;
    private Combatant rammus;
    private List<Combatant> targets;
    private int rank;

    public RamTremorFightEvent(Combatant rammus, List<Combatant> targets, int rank)
    {
        this.rammus = rammus;
        this.targets = targets;
        this.rank = rank;
    }

    @Override
    public Combatant getSource() 
    {
        return rammus;
    }

    @Override
    public List<TimedFightEvent> resolve() 
    {
        List<TimedFightEvent> toReturn = new ArrayList<>();
        this.timesRun++;
        if (this.timesRun < 8)
        {
            toReturn.add(this);
        }
        
        for (Combatant t : targets)
        {
            double rawDamage = rank*40.0+(rammus.getAP()*.2);
            double damage = Ability.applyMagicResist(rawDamage, t);
            t.dealDamage(damage);
            System.out.println("Tremors deals "+(int)damage+" to "+t);
        }
        return toReturn;
    }

    @Override
    public double getTime() 
    {
        return 1;
    }
    
}
