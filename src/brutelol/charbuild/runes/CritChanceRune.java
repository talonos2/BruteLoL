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
class CritChanceRune extends Rune {

    public CritChanceRune() {
    }

    @Override
    public void applyChangesAsMark(BuildInfo bi) 
    {
        bi.critChance += .0093;
    }

    @Override
    public void applyChangesAsSeal(BuildInfo bi) 
    {
        bi.critChance += .0042;
    }

    @Override
    public void applyChangesAsGlyph(BuildInfo bi) 
    {
        bi.critChance += .0028;
    }

    @Override
    public void applyChangesAsQuint(BuildInfo bi) 
    {
        bi.critChance += .0186;
    }
    
    @Override
    public String toString()
    {
        return "CC";
    }
    
}
