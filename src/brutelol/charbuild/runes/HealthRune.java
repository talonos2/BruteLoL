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
class HealthRune extends Rune {

    public HealthRune() {
    }

    @Override
    public void applyChangesAsMark(BuildInfo bi) {
        bi.hp += 3.47;
    }

    @Override
    public void applyChangesAsSeal(BuildInfo bi) {
        bi.hp += 8;
    }

    @Override
    public void applyChangesAsGlyph(BuildInfo bi) {
        bi.hp += 2.67;
    }

    @Override
    public void applyChangesAsQuint(BuildInfo bi) {
        bi.hp += 326;
    }
    
    @Override
    public String toString()
    {
        return "HP";
    }
    
}