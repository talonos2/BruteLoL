/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.buildobjs;

import brutelol.items.abstracts.Item;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.paukov.combinatorics.CombinatoricsVector;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;
import org.paukov.combinatorics.combination.simple.SimpleCombinationGenerator;

/**
 *
 * @author Talonos
 */
public class ItemSet 
{
    /**
     * This array of items represent the items currently in the itemset.
     */
    public Item[] itemsInList = new Item[6];
    
    /**
     * Takes a list of items and puts them into a new ItemSet.
     * @param items 
     */
    public ItemSet(List<Item> items)
    {   
        //Fail if you have the wrong number of items.
        if (items.size() > 6)
        {
            throw new IllegalArgumentException("Too many items in the set!)");
        }
        
        //Copy items into the array.
        int n = 0;
        for (Item i : items)
        {
            itemsInList[n++] = i;
        }
        
        //Sorts the items, putting null items at the end.
        Arrays.sort(itemsInList, new nullSorter());
    }
    
    /**
     * Decompose the items in this itemset into itemsets that build up to this one.
     * This method is used when determining build paths by creating a Directed
     * Acyclic Graph representing all possible paths to get to a final build.
     * @return a list of itemsets that are one "step" before this one.
     */
    public List<ItemSet> getDecompositions()
    {
        //Make a list to return.
        List<ItemSet> toReturn = new ArrayList<>();
        
        //For each item...
        for (int itemIndexImOn = 0; itemIndexImOn < 6; itemIndexImOn++)
        {
            Item i = itemsInList[itemIndexImOn];
            //If it's not null...
            if (i == null)
            {
                continue;
            }
            
            //Figure out what it could have been built from.
            List<Item> thingsThisCanBreakDownInto = i.getPrerequisites();
            
            //If the item has no prerequisites, it's just a base item. In that
            //case, return an item set just like this one, but missing the item
            //in question.
            if (thingsThisCanBreakDownInto.isEmpty())
            {
                List<Item> newItemList = new ArrayList<>();
                //Copy all items over except the decomposing one.
                for (int x = 0; x < 6; x++)
                {
                    if (itemsInList[x] != null && x != itemIndexImOn)
                    {
                        newItemList.add(itemsInList[x]);
                    }
                }
                
                //Package it in an itemset, add it, and move on.
                ItemSet newItemSet = new ItemSet(newItemList);
                toReturn.add(newItemSet);
                continue;
            }
            
            //How many slots do we have for new Items?
            int emptySpots = countEmptySpots();
            
            //Create combinatorics vector to represent all possible combinations of items
            CombinatoricsVector<Item> initialVector = new CombinatoricsVector<>(thingsThisCanBreakDownInto);
            Generator<Item> gen = new SimpleCombinationGenerator<>(initialVector, Math.min(emptySpots, thingsThisCanBreakDownInto.size()));
            Iterator<ICombinatoricsVector<Item>> itr = gen.iterator();
            
            //For each possible combinations of items...
            while (itr.hasNext())
            {
                ICombinatoricsVector<Item> compost = itr.next();
                
                List<Item> newItemList = new ArrayList<>();
                //Copy all items over except the decomposing one into a new list.
                for (int x = 0; x < 6; x++)
                {
                    if (itemsInList[x] != null && x != itemIndexImOn)
                    {
                        newItemList.add(itemsInList[x]);
                    }
                } //Finish Copy
                
                //Add to this list the newly decomposed items.
                newItemList.addAll(compost.getVector());
                
                //Package it into an item set and send it into the list we'll return.
                ItemSet newItemSet = new ItemSet(newItemList);
                toReturn.add(newItemSet);
                    
            }//End iteration over compost items.
        }//End iteration over items in itemset.
        return toReturn;
    }

    private int countEmptySpots() 
    {
        int spots = 0;
        for (int x = 0; x < 6; x++)
        {
            if (this.itemsInList[x] == null)
            {
                spots++;
            }
        }
        return spots+1; //We add one to it because we are leaving space for the item in the process of decomposing.
    }

    /**
     * A private class that sorts items in a way that doesn't throw null-pointer exceptions.
     */
    private class nullSorter implements Comparator<Item>
    {
        @Override
        public int compare(Item o1, Item o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o1.compareTo(o2);
        }
    }
    
    /**
     * ToString for Debug Convenience.
     * @return the string
     */
    public String toString()
    {
        return new StringBuilder().append("[").append(itemsInList[0]).append(",")
                                              .append(itemsInList[1]).append(",")
                                              .append(itemsInList[2]).append(",")
                                              .append(itemsInList[3]).append(",")
                                              .append(itemsInList[4]).append(",")
                                              .append(itemsInList[5]).append(",").append("]").toString();
                
    }

    /**
     * Returns a hashcode based on the hashcodes of the contained items.
     * @return a hashcode.
     */
    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 89 * hash + Arrays.deepHashCode(this.itemsInList);
        return hash;
    }

    /**
     * Determines if two ItemSets are equal.
     * Note that the itemsets should be in sorted order by this point, so a 
     * 1 to 1 comparision between elements should sufficiently prove uniqueness.
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) 
    {
        if (obj == null) 
        {
            return false;
        }
        if (getClass() != obj.getClass()) 
        {
            return false;
        }
        final ItemSet other = (ItemSet) obj;
        if (!Arrays.deepEquals(this.itemsInList, other.itemsInList)) 
        {
            return false;
        }
        return true;
    }
}
