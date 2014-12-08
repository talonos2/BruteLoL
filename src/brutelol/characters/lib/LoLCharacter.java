/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.lib;

import brutelol.charbuild.ItemSet;
import brutelol.charbuild.MasterySet;
import brutelol.charbuild.runes.RunePage;
import brutelol.charbuild.Build;
import brutelol.characters.instances.BuildInfo;
import java.util.List;

/**
 *
 * @author Talonos
 */
public interface LolCharacter 
{       
    /**
     * When passed a build and heuristic, returns how high that heuristic is.
     * @param b the build to evaluate.
     * @param enemies the build representing the enemy you are "doing" this to. Often 
     * doesn't matter. Also often only uses the first index as the "target".
     * @param selectedHeuristic the heuristic to evaluate.
     * @return 
     */
    public double getComponentUtility(Build b, Build enemy, HeuristicComponent selectedHeuristic);
    
    /**
     * Returns a list of all heuristics that could be applied to this character.
     * @return the aforementioned list.
     */
    public List<HeuristicComponent>supportedComponents();
    
    /**
     * Returns a string that describes information about the character, given the
     * build you pass in. I envision this being implemented as an iteration over
     * all possible heuristics.
     * @return 
     */
    public String getInfo(Build b);

    public BuildInfo getBuildInfo(Build aThis);

}
