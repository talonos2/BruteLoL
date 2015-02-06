/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.charbuild.runes;

import brutelol.charbuild.runes.Rune;
import brutelol.characters.lib.BuildInfo;

/**
 *
 * @author Talonos
 */
class BlankRune extends Rune 
{

    @Override
    public void applyChangesAsMark(BuildInfo bi) 
    {
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
    }
    
    @Override
    public String toString()
    {
        return "--";
    }
    
}
