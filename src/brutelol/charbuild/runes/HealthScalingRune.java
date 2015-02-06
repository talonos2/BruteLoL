/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.charbuild.runes;

import brutelol.characters.lib.BuildInfo;

/**
 *
 * @author Talonos
 */
class HealthScalingRune extends Rune {

    public HealthScalingRune() {
    }

    @Override
    public void applyChangesAsMark(BuildInfo bi) {
        bi.hp += bi.level*.54;
    }

    @Override
    public void applyChangesAsSeal(BuildInfo bi) {
        bi.hp += bi.level*1.33;
    }

    @Override
    public void applyChangesAsGlyph(BuildInfo bi) {
        bi.hp += bi.level*.54;
    }

    @Override
    public void applyChangesAsQuint(BuildInfo bi) {
        bi.hp += bi.level*2.7;
    }
    
    @Override
    public String toString()
    {
        return "H(s)";
    }
}
