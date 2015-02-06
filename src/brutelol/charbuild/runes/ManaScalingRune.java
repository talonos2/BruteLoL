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
class ManaScalingRune extends Rune {

    public ManaScalingRune() {
    }

    @Override
    public void applyChangesAsMark(BuildInfo bi) {
        bi.mana += 1.17*bi.level;
    }

    @Override
    public void applyChangesAsSeal(BuildInfo bi) {
        bi.mana += 1.17*bi.level;
    }

    @Override
    public void applyChangesAsGlyph(BuildInfo bi) {
        bi.mana += 1.42*bi.level;
    }

    @Override
    public void applyChangesAsQuint(BuildInfo bi) {
        bi.mana += 4.17*bi.level;
    }
    
}
