package brutelol;

import brutelol.charbuild.Build;
import brutelol.charbuild.ItemSet;
import brutelol.charbuild.MapEnum;
import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.characters.lib.BlankMasteries;
import brutelol.characters.lib.LolCharacter;
import brutelol.characters.lib.HeuristicComponent;
import brutelol.characters.lib.Masteries;
import brutelol.charbuild.runes.RunePage;
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
    
    private static final RunePage blankPage = new RunePage();
    private static final Masteries sampleMasteries = new BlankMasteries();
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
        double amountToBeat = suggested.getComponent(h, enemy);
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
        double bestSoFar = suggested.getComponent(h, enemy);
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
            Build build = new Build(items, selectedCharacter, 100000, 100000, 100000, blankPage, sampleMasteries);
            double utility = build.getComponent(h, enemy);
            
            //If the build is good enough to be considered viably better...
            if (utility > amountToBeat)
            {
                viablePossibilities++;
                //Optimize its runepage.
                build = optimizeRunePage(build, enemy, h);
                utility = build.getComponent(h, enemy);
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
            System.out.println(b.getComponent(h, enemy));
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

    /**
     * Attempts to optimize a rune page using a genetic algorithm.
     * @param pb the proposed build we will try to optimize.
     * @param enemy the enemy we are trying to optimize against.
     * @param h the component we are trying to optimize.
     * @return 
     */
    public static Build optimizeRunePage(Build pb, Build enemy, HeuristicComponent h) 
    {
        //create an initial population of runePages, in a map.
        Map<RunePage, Double> populationFitness = new HashMap<>();
        List<RunePage> population = new ArrayList<>();
        
        for (int x = 0; x < POPULATION_SIZE; x++)
        {
            RunePage r = RunePage.getRandomPage(dice);
            double fitness = new Build(pb.getItems(), pb.getCharacter(), 100000, 100000, 100000, r, sampleMasteries).getComponent(h, enemy);
            populationFitness.put(r, fitness);
            population.add(r);
        }
        
        //Every time we iterate over runepages, but it does not change, we mark it as
        //a "pointless" iteration. Once the number of pointless iterations goes past
        //MAX_POINTLESS_ITERATIONS, we decide it's as good as it will get.
        int pointlessIterations = 0;
        while (pointlessIterations < MAX_POINTLESS_ITERATIONS)
        {
            RunePage r1 = population.get(dice.nextInt(POPULATION_SIZE));
            RunePage r2 = population.get(dice.nextInt(POPULATION_SIZE));
            RunePage babyRunePage = r1.mergeWith(r2, dice);
            
            //Test the runepage against it's closest competitor to preserve genetic
            //diversity.
            RunePage contender = getClosestRunePage(babyRunePage, population);
            
            double babyFitness = new Build(pb.getItems(), pb.getCharacter(), 100000, 100000, 100000, babyRunePage, sampleMasteries).getComponent(h, enemy);
            double contenderFitness = populationFitness.get(contender);
            //Yes, I'm totally pitting baby runepages against fully grown ones in a
            //gladiatorial arena.
            if (babyFitness > contenderFitness)
            {
                //See? My faith in the baby was justified.
                //He grows up and is part of the population.
                population.remove(contender);
                population.add(babyRunePage);
                populationFitness.remove(contender);
                populationFitness.put(babyRunePage, babyFitness);
                pointlessIterations = 0;
            }
            else
            {
                //The baby was garbage, and will be collected as such when he falls out of scope.
                pointlessIterations++;
            }
        }
        
        //Get the best runepage from our population.
        return getBestRunepage(populationFitness, pb, enemy, h);
    }

    private static Build getBestRunepage(Map<RunePage, Double> population, Build pb, Build enemy, HeuristicComponent h) 
    {
        RunePage bestSoFar = null;
        double utility = -1;
        for (RunePage p : population.keySet())
        {
            double newUtility = population.get(p);
            if (newUtility > utility)
            {
                bestSoFar = p;
                utility = newUtility;
            }
        }
        return new Build(pb.getItems(), pb.getCharacter(), 100000, 100000, 100000, bestSoFar, sampleMasteries);
    }

    private static RunePage getClosestRunePage(RunePage toCompare, List<RunePage> population) 
    {
        RunePage bestSoFar = null;
        double similarity = -1;
        for (RunePage p : population)
        {
            double newSim = p.getSimilarity(toCompare);
            if (newSim > similarity)
            {
                bestSoFar = p;
                similarity = newSim;
            }
        }
        return bestSoFar;
    }
    
}
