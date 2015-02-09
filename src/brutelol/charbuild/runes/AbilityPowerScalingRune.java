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
class AbilityPowerScalingRune extends Rune 
{

    public AbilityPowerScalingRune() 
    {
    }

    @Override
    public void applyChangesAsMark(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) 
    {
        bi.abilityPower+=bi.level*.1;
    }

    @Override
    public void applyChangesAsSeal(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) 
    {
        bi.abilityPower+=bi.level*.1;
    }

    @Override
    public void applyChangesAsGlyph(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) 
    {
        bi.abilityPower+=bi.level*.17;
    }

    @Override
    public void applyChangesAsQuint(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) 
    {
        bi.abilityPower+=bi.level*.43;
    }
    
        @Override
    public String toString()
    {
        return "AP+";
    }
    
}
