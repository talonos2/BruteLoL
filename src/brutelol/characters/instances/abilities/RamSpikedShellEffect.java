/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.instances.abilities;

import brutelol.fights.Ability;
import brutelol.fights.Combatant;

/**
 *
 * @author Talonos
 */
public class RamSpikedShellEffect extends StatusEffect
{

    @Override
    public double onHitMagicAddition(Combatant attacker, Combatant target) 
    {
        double magicDamage = attacker.getArmor() * .1;
        if (attacker.hasEffect(StatusEffect.RAM_DBC))
        {
            magicDamage *= 1.5;
        }
        return magicDamage;
    }
}
