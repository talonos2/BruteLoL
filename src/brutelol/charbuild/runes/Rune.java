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
public abstract class Rune 
{
    public abstract void applyChangesAsMark(BuildInfo bi);
    public abstract void applyChangesAsSeal(BuildInfo bi);
    public abstract void applyChangesAsGlyph(BuildInfo bi);
    public abstract void applyChangesAsQuint(BuildInfo bi);
}
