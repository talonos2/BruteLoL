/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol;

import brutelol.characters.instances.Ashe;
import brutelol.charbuild.Build;
import brutelol.characters.lib.HeuristicComponent;
import brutelol.characters.instances.Soraka;
import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.characters.lib.AshesToAshesMasteries;
import brutelol.charbuild.ItemSet;
import brutelol.charbuild.runes.RunePage;
import brutelol.items.abstracts.Item;
import brutelol.items.instances.BerserkersGreaves;
import brutelol.items.instances.BladeOfTheRuinedKing;
import brutelol.items.instances.Bloodthirster;
import brutelol.items.instances.GuardianAngel;
import brutelol.items.instances.InfinityEdge;
import brutelol.items.instances.Items;
import brutelol.items.instances.LastWhisper;
import brutelol.items.instances.PhantomDancer;
import brutelol.items.instances.ZhonyasHourglass;
import java.util.ArrayList;
import java.util.List;

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
        AbstractLolCharacter selectedCharacter = new Ashe();
        //TODO: Provide a way for the player to select a heuristic.
        HeuristicComponent h = HeuristicComponent.DAMAGE_PER_SECOND;
        Items.getAllItems();
        
        List<Item> items = new ArrayList<Item>();
        items.add(new ZhonyasHourglass());
        items.add(new GuardianAngel());
        
        Build enemy = new Build(new ItemSet(items), new Soraka(), 100000, 10000, 10000, new RunePage(), new AshesToAshesMasteries());
        
        List<Item> proposedItems = new ArrayList<Item>();
        proposedItems.add(new PhantomDancer());
        proposedItems.add(new LastWhisper());
        proposedItems.add(new Bloodthirster());
        proposedItems.add(new InfinityEdge());
        proposedItems.add(new BerserkersGreaves());
        proposedItems.add(new BladeOfTheRuinedKing());
        
        Build b = new Build(new ItemSet(proposedItems), selectedCharacter, 100000, 10000, 10000, new RunePage(), new AshesToAshesMasteries());
        
        Build bestBuild = BuildOptimizer.deriveOptimalBuild(selectedCharacter, enemy, h, b);
        
        System.out.println(bestBuild.getComponentMathNotes(h, enemy));
    }
    
}
