/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.charbuild.runes;

import brutelol.characters.lib.BuildInfo;
import brutelol.characters.lib.BuildInfo.Ability;
import java.util.EnumMap;

/**
 *
 * @author Talonos
 */
class AbilityPowerRune extends Rune 
{

    @Override
    public void applyChangesAsMark(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) 
    {
        bi.abilityPower += .59;
        logs.get(Ability.ABILITY_POWER).append(" +.59 from AP mark\n");
    }

    @Override
    public void applyChangesAsSeal(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) 
    {
        bi.abilityPower += .59;
        logs.get(Ability.ABILITY_POWER).append(" +.59 from AP seal\n");
    }

    @Override
    public void applyChangesAsGlyph(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) 
    {
        bi.abilityPower += 1.19;
        logs.get(Ability.ABILITY_POWER).append(" +.59 from AP glyph\n");
    }

    @Override
    public void applyChangesAsQuint(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) 
    {
        bi.abilityPower += 4.95;
    }
    
    @Override
    public String toString()
    {
        return "AP";
    }

    
}
