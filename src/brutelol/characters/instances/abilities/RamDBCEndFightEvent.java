/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.instances.abilities;

import brutelol.fights.AbilityUse;
import brutelol.fights.Combatant;
import brutelol.fights.TimedFightEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class RamDBCEndFightEvent extends TimedFightEvent 
{
    private Combatant rammus;
    RamDefensiveBallCurl dbc;

    public RamDBCEndFightEvent(Combatant rammus, RamDefensiveBallCurl dbc) 
    {
        this.rammus = rammus;
        this.dbc=dbc;
    }

    @Override
    public Combatant getSource() 
    {
        return rammus;
    }

    @Override
    public List<TimedFightEvent> resolve() 
    {
        System.out.println("Rammus' Defensive Ball Curl expires!");
        List<TimedFightEvent> toReturn = new ArrayList<>();
        rammus.loseStatusEffect(StatusEffect.RAM_DBC);
        AbilityUse startDBCCooldown = new AbilityUse(rammus, null, dbc);
        toReturn.add(startDBCCooldown);
        return toReturn;
    }

    @Override
    public double getTime() 
    {
        return 6;
    }
    
}
