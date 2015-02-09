/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.charbuild.runes;

import brutelol.characters.lib.BuildInfo;
import java.util.EnumMap;

/**
 *
 * @author Talonos
 */
class AttackDamageScalingRune extends Rune {

    public AttackDamageScalingRune() {
    }

    @Override
    public void applyChangesAsMark(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) 
    {
        bi.attackDamage+= bi.level*.13;
    }

    @Override
    public void applyChangesAsSeal(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) 
    {
        bi.attackDamage+= bi.level*.06;
    }

    @Override
    public void applyChangesAsGlyph(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) 
    {
        bi.attackDamage+= bi.level*.04;
    }

    @Override
    public void applyChangesAsQuint(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) 
    {
        bi.attackDamage+= bi.level*.25;
    }
    
    @Override
    public String toString()
    {
        return "AD+";
    }
    
}
