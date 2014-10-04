/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol;

import brutelol.characters.lib.LolHeuristic;
import brutelol.characters.instances.Soraka;
import brutelol.characters.lib.LolCharacter;

/**
 * Main Entry point into the Program
 * @author Talonos
 */
public class BruteLoL 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //TODO: Provide a way for the player to select a character.
        LolCharacter selectedCharacter = new Soraka();
        //TODO: Provide a way for the player to select a heuristic.
        LolHeuristic selectedHeuristic = new HealingPerSecond();
    }
    
}
