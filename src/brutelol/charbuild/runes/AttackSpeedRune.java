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
class AttackSpeedRune extends Rune 
{

    @Override
    public void applyChangesAsMark(BuildInfo bi) 
    {
        bi.attackSpeed += .017;
    }

    @Override
    public void applyChangesAsSeal(BuildInfo bi) 
    {
        bi.attackSpeed += .0076;
    }

    @Override
    public void applyChangesAsGlyph(BuildInfo bi) 
    {
        bi.attackSpeed += .0064;
    }

    @Override
    public void applyChangesAsQuint(BuildInfo bi) 
    {
        bi.attackSpeed += .045;
    }
    
    @Override
    public String toString()
    {
        return "AS";
    }
    
}
