/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.instances;

import brutelol.buildobjs.Build;
import brutelol.buildobjs.ItemSet;
import brutelol.buildobjs.MasterySet;
import brutelol.buildobjs.RunePage;
import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.characters.lib.LolHeuristic;

/**
 *
 * @author Talonos
 */
public class Soraka extends AbstractLolCharacter
{
    public Soraka()
    {
        this.ARMOR_AT_0 = 17;
        this.ARMOR_PER_LEVEL = 3.8;
        this.ATTACK_DAMAGE_AT_0 = 48.8;
        this.ATTACK_DAMAGE_PER_LEVEL = 3;
        this.ATTACK_SPEED_AT_1 = .625;
        this.ATTACK_SPEED_PER_LEVEL = .0214;
        this.HP_AT_0 = 405;
        this.HP_PER_LEVEL = 76;
        this.HP_REGEN_AT_0 = 4.5;
        this.HP_REGEN_PER_LEVEL = .55;
        this.MAGIC_RES_AT_0 = 30;
        this.MAGIC_RES_PER_LEVEL = 0;
        this.MANA_AT_0 = 240;
        this.MANA_PER_LEVEL = 60;
        this.MANA_REGEN_AT_0 = 6.8;
        this.MANA_REGEN_PER_LEVEL = .65;
        this.MOVE_SPEED = 340;
        this.RANGE = 550;
    }

    @Override
    public RunePage optimizeRunepageFor(ItemSet items, MasterySet masteries) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showWork(Build b) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * When passed an itemset, returns a build that best makes use of that itemset.
     * The build is a combination of items, runes, masteries, etc. It also contains
     * a "utility" that can be extracted for comparing purposes.
     * @param items
     * @param selectedHeuristic
     * @return 
     */
    @Override
    public Build getFinalUtility(ItemSet items, LolHeuristic selectedHeuristic) 
    {
        
    }
}
