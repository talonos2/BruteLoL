/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.charbuild.runes;

import brutelol.characters.instances.BuildInfo;

/**
 *
 * @author Talonos
 */
class MagicPenRune extends Rune {

    public MagicPenRune() {
    }

    @Override
    public void applyChangesAsMark(BuildInfo bi) {
        bi.magicPenetrationFlat+=.87;
    }

    @Override
    public void applyChangesAsSeal(BuildInfo bi) {
    }

    @Override
    public void applyChangesAsGlyph(BuildInfo bi) {
        bi.magicPenetrationFlat+=.63;
    }

    @Override
    public void applyChangesAsQuint(BuildInfo bi) {
        bi.magicPenetrationFlat+=2.01;
    }
    
    @Override
    public String toString()
    {
        return "MPen";
    }
    
}
