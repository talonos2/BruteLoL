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
public interface LoLCharacter 
{
    public double getUtility(Build b);
    
    public RunePage optimizeRunepageFor(ItemSet items, MasterySet masteries);
}
