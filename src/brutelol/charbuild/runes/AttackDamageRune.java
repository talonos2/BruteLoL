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
class AttackDamageRune extends Rune 
{
    @Override
    public void applyChangesAsMark(BuildInfo bi) 
    {
        bi.attackDamage += .95;
    }

    @Override
    public void applyChangesAsSeal(BuildInfo bi) 
    {
        bi.attackDamage += .43;
    }

    @Override
    public void applyChangesAsGlyph(BuildInfo bi) 
    {
        bi.attackDamage += .28;
    }

    @Override
    public void applyChangesAsQuint(BuildInfo bi) 
    {
        bi.attackDamage += 2.25;
    }
    
    @Override
    public String toString()
    {
        return "AD";
    }
}
