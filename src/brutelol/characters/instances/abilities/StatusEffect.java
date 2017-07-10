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
    public static RamSpikedShellEffect RAM_SPIKED_SHELL = new RamSpikedShellEffect();
    
    public static UnimplementedEffect ITEM_QUICKSILVER;
    public static UnimplementedEffect ITEM_BIG_GIANT_SLAYER;
    public static UnimplementedEffect ITEM_SPECTRAL_WALTZ;
    public static UnimplementedEffect ITEM_LAMENT;
    public static UnimplementedEffect ITEM_FIRECANNON;
    public static UnimplementedEffect ITEM_SHIV_LIGHTNING;
    
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
