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
public class RamDefensiveBallCurlEffect extends StatusEffect
{

    @Override
    public void doHitRetaliation(Combatant attacker, Combatant defender, double physicalDam, double magicalDam) 
    {
        double damage = defender.getArmor()*.10;
        damage += 7 + defender.getLevel();
        damage *= 1.5;
        damage = Ability.applyMagicResist(damage, attacker);
        attacker.dealDamage(damage);
        System.out.println(" - DBC does "+(int)damage+" to "+attacker+" in response!");
    }
}
