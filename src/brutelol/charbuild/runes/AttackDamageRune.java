/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.charbuild.runes;

import brutelol.characters.lib.BuildInfo;
import java.util.EnumMap;

/**
 *
 * @author Talonos
 */
class AttackDamageRune extends Rune 
{
    @Override
    public void applyChangesAsMark(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) 
    {
        bi.attackDamage += .95;
    }

    @Override
    public void applyChangesAsSeal(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) 
    {
        bi.attackDamage += .43;
    }

    @Override
    public void applyChangesAsGlyph(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) 
    {
        bi.attackDamage += .28;
    }

    @Override
    public void applyChangesAsQuint(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) 
    {
        bi.attackDamage += 2.25;
    }
    
    @Override
    public String toString()
    {
        return "AD";
    }
}
