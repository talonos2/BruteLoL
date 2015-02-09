/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.lib;

import java.util.EnumMap;

/**
 * Represents JhoiJhoi's Ashes to Ashes guide's masteries.
 * 
 * 
 * 
 * @author Talonos
 */
public class AshesToAshesMasteries extends Masteries
{

    @Override
    public void applyMasteries(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) 
    {
        bi.attackSpeed += .0375;
        bi.attackDamage += .55*bi.level;
        bi.attackDamage += 4;
        bi.attackDamage *= 1.05;  //Warlord: Only applies to *bonus* attack damage.
        bi.armorPenetrationPercent += .06;
        bi.magicPenetrationFlat += .06;
    }

    @Override
    public boolean hasMastery(Mastery m) 
    {
        switch (m)
        {
            case BUTCHER:
            case FEAST:
            case EXECUTIONER_1:
            case EXECUTIONER_2:
            case EXECUTIONER_3:
            case DANGEROUS_GAME:
            case HAVOC:    
            case FRENZY: 
                return true;
            default:
                return false;
        }
    }
}
