/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol;

import brutelol.characters.instances.Xayah;
import brutelol.charbuild.Build;
import brutelol.characters.lib.HeuristicComponent;
import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.charbuild.ItemSet;
import brutelol.items.abstracts.Item;
import brutelol.items.instances.Items;
import brutelol.items.instances.NoItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Main Entry point into the Program
 * @author Talonos
 */
public class BruteLoL 
{

    /**
     * The base method. Currently just runs using hard-coded options.
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //Who is the character, and what do we want him to be good at?
        //TODO: Provide a way for the player to select a character.
        AbstractLolCharacter selectedCharacter = new Xayah();       
        //TODO: Provide a way for the player to select a heuristic.
        HeuristicComponent h = HeuristicComponent.RAW_DAMAGE_PER_SECOND;
        
        //Initialize items:
        Items.getAllItems();
        
        //We need an enemy to test damage against. We create one here:
        List<Item> enemyItems = new ArrayList<Item>();
        //enemyItems.add(new LastWhisper());
        Build enemy = new Build(new ItemSet(enemyItems), new Xayah(), 18, 2400);
        
        //Having a list of proposed items lets us cut bad search avenues quickly.
        //Enter a proposed item list here.
        List<Item> proposedItems = new ArrayList<Item>();
        proposedItems.add(new NoItem());
        proposedItems.add(new NoItem());
        proposedItems.add(new NoItem());
        proposedItems.add(new NoItem());
        proposedItems.add(new NoItem());
        proposedItems.add(new NoItem());
        Build proposedBuild = new Build(new ItemSet(proposedItems), selectedCharacter, 18, 2400);
        
        //The work is done here.
        Build bestBuild = BuildOptimizer.deriveOptimalBuild(selectedCharacter, enemy, h, proposedBuild);
    }
    
}
