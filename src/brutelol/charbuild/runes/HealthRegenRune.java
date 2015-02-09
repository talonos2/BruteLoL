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
class HealthRegenRune extends Rune {

    public HealthRegenRune() {
    }

    
    @Override
    public String toString()
    {
        return "HR";
    }

    @Override
    public void applyChangesAsMark(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void applyChangesAsSeal(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void applyChangesAsGlyph(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void applyChangesAsQuint(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
