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
class HybridPenRune extends Rune {

    public HybridPenRune() {
    }

    @Override
    public void applyChangesAsMark(BuildInfo bi) {
        bi.armorPenetrationFlat+=.9;
        bi.magicPenetrationFlat+=.62;
    }

    @Override
    public void applyChangesAsSeal(BuildInfo bi) {
    }

    @Override
    public void applyChangesAsGlyph(BuildInfo bi) {
    }

    @Override
    public void applyChangesAsQuint(BuildInfo bi) {
        bi.armorPenetrationFlat+=1.79;
        bi.magicPenetrationFlat+=1.4;
    }
    
    @Override
    public String toString()
    {
        return "HPen";
    }
    
}
