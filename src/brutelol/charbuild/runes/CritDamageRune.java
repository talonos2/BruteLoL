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
class CritDamageRune extends Rune {

    public CritDamageRune() {
    }

    @Override
    public void applyChangesAsMark(BuildInfo bi) 
    {
        bi.addedCritDamage += .0223;
    }

    @Override
    public void applyChangesAsSeal(BuildInfo bi) {
        bi.addedCritDamage += .0078;
    }

    @Override
    public void applyChangesAsGlyph(BuildInfo bi) {
        bi.addedCritDamage += .0056;
    }

    @Override
    public void applyChangesAsQuint(BuildInfo bi) {
        bi.addedCritDamage += .0446;
    }
    
    @Override
    public String toString()
    {
        return "CD";
    }
    
}
