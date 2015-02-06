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
class AbilityPowerRune extends Rune 
{

    @Override
    public void applyChangesAsMark(BuildInfo bi) 
    {
        bi.abilityPower += .59;
    }

    @Override
    public void applyChangesAsSeal(BuildInfo bi) 
    {
        bi.abilityPower += .59;
    }

    @Override
    public void applyChangesAsGlyph(BuildInfo bi) 
    {
        bi.abilityPower += 1.19;
    }

    @Override
    public void applyChangesAsQuint(BuildInfo bi) 
    {
        bi.abilityPower += 4.95;
    }
    
    @Override
    public String toString()
    {
        return "AP";
    }

    
}
