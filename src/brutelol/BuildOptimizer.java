/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol;

import brutelol.charbuild.Build;
import brutelol.charbuild.ItemSet;
import brutelol.charbuild.MapEnum;
import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.characters.lib.LolCharacter;
import brutelol.characters.lib.HeuristicComponent;
import brutelol.items.abstracts.Item;
import brutelol.items.instances.Items;
import brutelol.items.instances.NoItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.paukov.combinatorics.CombinatoricsVector;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;
import org.paukov.combinatorics.combination.multi.MultiCombinationGenerator;

/**
 *
 * @author Talonos
 */
public class BuildOptimizer 
{

    public static Build deriveOptimalBuild(AbstractLolCharacter selectedCharacter, Build enemy, HeuristicComponent h) 
    {
        // create array of initial items
        List<Item> array = new ArrayList<>();
        array.addAll(Items.getAllPOptimalItems(MapEnum.SUMMONERS_RIFT));

        // create combinatorics vector. This holds the items we're going to make a multicombination from.
        CombinatoricsVector<Item> initialVector = new CombinatoricsVector<Item>(array);

        // create multi-combination generator.
        Generator<Item> gen = new MultiCombinationGenerator<Item>(initialVector , 6);
        //Generator<Item> gen = new SimpleCombinationGenerator<Item>(initialVector , 6);
    
        // create an iterator to pull combinations from.
        Iterator<ICombinatoricsVector<Item>> itr = gen.iterator();
    
        //Find the best combination:
        
        //Set up some base objects:
        double bestSoFar = Double.NEGATIVE_INFINITY;
        Map<Double, Build> bestBuilds = new TreeMap<>();
        int numberOfTrials = 0;
        List<List<Item>> allItemsets = new ArrayList<>();
        Item noItem = new NoItem();
        
        //Get all possible itemsets.
        while (itr.hasNext())
        {
            ICombinatoricsVector<Item> combination = itr.next();
            List<Item> itemList = new ArrayList<>();
            for (Item i : combination)
            {
                itemList.add(i);
            }
            while(itemList.size()<6)
            {
                itemList.add(noItem);
            }
            allItemsets.add(itemList);
        }
        
        //Check each one to see how good it is.
        int numberOfItemsets = allItemsets.size();
        System.out.println("Total number of Itemsets to check: "+numberOfItemsets);
        
        for (List<Item> itemList : allItemsets)
        {
            numberOfTrials++;
            if (numberOfTrials % 25000 == 0)
            {
                pruneBestBuilds(bestBuilds, enemy, h);
                System.out.println("Progress: "+numberOfTrials+"/"+numberOfItemsets);
            }
            ItemSet items = new ItemSet(itemList);
            Build build = new Build(items, selectedCharacter, 100000, 100000, 100000);
            double utility = build.getComponent(h, enemy);
            if (utility > bestSoFar)
            {
                System.out.println("Build: "+items);
                System.out.println("Utility1: "+build);
                bestSoFar = utility;
            }
            
            bestBuilds.put(1.0-utility, build);
        }
        System.out.println("=-=-=-=Results:=-=-=-=-=");
        pruneBestBuilds(bestBuilds, enemy, h);
        for (Build b : bestBuilds.values())
        {
            //selectedCharacter.showWork(b);
        }
        
        return bestBuilds.get(bestSoFar);
    }

    private static void pruneBestBuilds(Map<Double, Build> bestBuilds, Build enemy, HeuristicComponent h) 
    {
        System.out.println("Current top 10 builds:");
        int top = 10;
        Map<Double, Build> newMap = new TreeMap<>();
        for (Map.Entry<Double, Build> d : bestBuilds.entrySet())
        {
            newMap.put(d.getKey(), d.getValue());
            System.out.println("  "+top+": ("+d+")"+d.getValue().getItems());
            System.out.println("  Total Utility: "+d.getValue().getComponent(h, enemy));
            top -=1;
            if (top == 0)
            {
                break;
            }
        }
        
        bestBuilds.clear();
        
        for (Double d : newMap.keySet())
        {
            bestBuilds.put(d, newMap.get(d));
        }
    }
    
}
