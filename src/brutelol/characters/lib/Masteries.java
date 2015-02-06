/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.lib;

import brutelol.characters.lib.BuildInfo;

/**
 *
 * @author Talonos
 */
public abstract class Masteries 
{
    public abstract void applyMasteries(BuildInfo bi);
    
    public abstract boolean hasMastery(Mastery m);
}
