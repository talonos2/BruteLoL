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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import org.paukov.combinatorics.CombinatoricsVector;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;
import org.paukov.combinatorics.combination.multi.MultiCombinationGenerator;

/**
 * This class optimizes builds, and is where the bulk of the work is done.
 * 
 * @author Talonos
 */
public class BuildOptimizer 
{
    /**
     * How much worse can a build be than the "suggested" build and still be considered
     * as a candidate worthy of testing rune pages?
     * Expressed as a ratio, 1 = 100% = test any build with rune pages.
     */
    private static final double WIGGLE_AMOUNT = .2;
    
    /**
     * How many builds do we save when we prune?
     */
    private static final int NUM_TOP_BUILDS = 10;
    
    /**
     * How large of a population do we keep in the genetic rune-page optimization
     * algorithm?
     */
    private static final int POPULATION_SIZE = 16;
    
    /**
     * How many "pointless" iterations do we allow the genetic algorithm to
     * undergo before deciding we're as good as we're going to get?
     */
    private static final int MAX_POINTLESS_ITERATIONS = 500;    
    
    private static Random dice = new Random(0);
    
    

    /**
     * Find an optimal build for the given heuristic component against the given enemy for the given character.
     * @param selectedCharacter The character to test on. This character's getHeuristicComponent's method will
     * be called to evaluate the utility of any given build.
     * @param enemy The enemy to test against.
     * @param h The heuristic component to optimize.
     * @param suggested This is a proposed build that is used as a "fail fast". Any build that is not at least
     * this good will not have a rune page evaluated, to save on computation time.
     * @return the optimal build found.
     */
    public static Build deriveOptimalBuild(AbstractLolCharacter selectedCharacter, Build enemy, HeuristicComponent h, Build suggested) 
    {
        //Get a fail-fast amount. Any builds that to not meet this minimum build will not have their
        //runes evaluated, to save on computation time.
        double amountToBeat = suggested.getComponent(h);
        amountToBeat *= (1-WIGGLE_AMOUNT); //Leave a little wiggle room.
        
        // create array of initial items
        List<Item> array = new ArrayList<>();
        array.addAll(Items.generateOptimalItemsForMap(MapEnum.SUMMONERS_RIFT));

        // create combinatorics vector. This holds the items we're going to make a multicombination from.
        CombinatoricsVector<Item> initialVector = new CombinatoricsVector<>(array);

        // create multi-combination generator.
        Generator<Item> gen = new MultiCombinationGenerator<>(initialVector, 6);
        //Generator<Item> gen = new SimpleCombinationGenerator<Item>(initialVector , 6);
    
        // create an iterator to pull combinations from.
        Iterator<ICombinatoricsVector<Item>> itr = gen.iterator();
    
        //Find the best combination as follows:
        
        //Get all possible itemsets.
        List<List<Item>> allItemsets = new ArrayList<>();
        Item noItem = new NoItem();
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
        
        //Set up a data structure to store builds:
        double bestSoFar = suggested.getComponent(h);
        Map<Double, Build> bestBuilds = new TreeMap<>();
        bestBuilds.put(bestSoFar, suggested);

        //Check each itemset to evaluate its utility:
        int numberOfItemsets = allItemsets.size();
        System.out.println("Total number of Itemsets to check: "+numberOfItemsets);
        
        int numberOfTrials = 0;
        int viablePossibilities = 0;
        
        for (List<Item> itemList : allItemsets)
        {
            numberOfTrials++;
            //Progress report so we don't die of boredom.
            //Also, clear out old builds so we don't run out of memory.
            if (numberOfTrials % 10000 == 0)
            {
                pruneBestBuilds(bestBuilds);
                System.out.println("Progress: "+numberOfTrials+"/"+numberOfItemsets);
            }
            
            ItemSet items = new ItemSet(itemList);
            Build build = new Build(items, selectedCharacter, 18, 2400);
            double utility = build.getComponent(h);
            
            //If the build is good enough to be considered viably better...
            if (utility > amountToBeat)
            {
                viablePossibilities++;
                utility = build.getComponent(h);
            }
            
            if (utility > bestSoFar)
            {
                System.out.println("Build: "+items);
                System.out.println("Utility: "+utility);
                bestSoFar = utility;
            }
            
            bestBuilds.put(1.0-utility, build);
        }
        
        //All done. Print results
        System.out.println("=-=-=-=Results:=-=-=-=-=");
        pruneBestBuilds(bestBuilds);
        for (Build b : bestBuilds.values())
        {
            System.out.println(b.getItems());
            System.out.println(b.getComponent(h));
            //selectedCharacter.showWork(b);
        }
        
        System.out.println("Of the possible builds, "+(viablePossibilities*100.0/numberOfTrials)+"% were viable.");
        return bestBuilds.values().iterator().next();
    }

    /**
     * Prunes the list of builds to keep only a certain amount, as defined by
     * NUM_TOP_BUILDS.
     * @param bestBuilds the list of builds to modify.
     */
    private static void pruneBestBuilds(Map<Double, Build> bestBuilds) 
    {
        int top = NUM_TOP_BUILDS;
        Map<Double, Build> newMap = new TreeMap<>();
        for (Map.Entry<Double, Build> d : bestBuilds.entrySet())
        {
            newMap.put(d.getKey(), d.getValue());
            //System.out.println("  "+top+": ("+d+")"+d.getValue().getItems());
            //System.out.println("  Total Utility: "+d.getValue().getComponent(h, enemy));
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