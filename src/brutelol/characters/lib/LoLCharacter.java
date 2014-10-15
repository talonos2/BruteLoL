/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.lib;

import brutelol.buildobjs.ItemSet;
import brutelol.buildobjs.MasterySet;
import brutelol.buildobjs.RunePage;
import brutelol.buildobjs.Build;

/**
 *
 * @author Talonos
 */
public interface LolCharacter 
{
    /**
     * Gets the utility of a given, inputted build at level 18 with essentially infinite
     * gold.
     * @param b the build to evaluate.
     * @return the utility of the build, where "Utility" is often defined differently
     * on a per character basis. (Example: Ashe would be DPS, Soraka would be Healing/Sec,
     * etc.)
     */
    //public double getUtility(Build b);
    
    /**
     * Given an item and mastery set, returns an optimized runeset.
     * @param items the ItemSet to optimize for.
     * @param masteries the MasterySet to optimize for.
     * @return the RuneSet that will maximize the utility for the given item and mastery set.
     */
    public RunePage optimizeRunepageFor(ItemSet items, MasterySet masteries);
    
    /**
     * Prints, to the console, all the relevant math to determine the utility of
     * the given build.
     * @param b the Build to show for.
     */
    public void showWork (Build b);

    public Build getFinalUtility(ItemSet items, LolHeuristic selectedHeuristic);
}
