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
class ArmorPenRune extends Rune {

    public ArmorPenRune() {
    }

    @Override
    public void applyChangesAsMark(BuildInfo bi) 
    {
        bi.armorPenetrationFlat+=1.28;
    }

    @Override
    public void applyChangesAsSeal(BuildInfo bi) 
    {
    }

    @Override
    public void applyChangesAsGlyph(BuildInfo bi) 
    {
    }

    @Override
    public void applyChangesAsQuint(BuildInfo bi) 
    {
        bi.armorPenetrationFlat+=2.56;
    }
    
        @Override
    public String toString()
    {
        return "APen";
    }
    
}
