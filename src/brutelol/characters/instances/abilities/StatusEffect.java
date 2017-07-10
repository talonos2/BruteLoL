/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.instances.abilities;

import brutelol.fights.Combatant;

/**
 *
 * @author Talonos
 */
public class StatusEffect 
{
    public static RamDefensiveBallCurlEffect RAM_DBC = new RamDefensiveBallCurlEffect();
    public static StatusEffect RAM_SPIKED_SHELL = new RamSpikedShellEffect();
    
    public void doHitRetaliation(Combatant attacker, Combatant Defender, double physicalDam, double magicalDam)
    {
        
    }
    
    public double onHitMagicAddition(Combatant attacker, Combatant target)
    {
        return 0;
    }
    
    public double onHitPhysicalAddition(Combatant attacker, Combatant target)
    {
        return 0;
    }
}
