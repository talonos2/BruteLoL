/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.items.abstracts.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Talonos
 */
public class Items 
{
    private static List<Item> pOptimalItems;
    private static List<Item> allItems;
    private static Map<Item, Integer> itemIDs = new HashMap();
    
    private static void initItems()
    {
        allItems = new ArrayList<>();
        
        allItems.add(new AncientCoin());
        allItems.add(new BootsOfSpeed());
        allItems.add(new ClothArmor());
        allItems.add(new FaerieCharm());
        allItems.add(new LongSword());
        allItems.add(new RejuvenationBead());
        
        allItems.add(new NoItem());
        
        int id = 0;
        for (Item i : allItems)
        {
            itemIDs.put(i, id++);
        }
    }

    public static List<Item> getAllPOptimalItems() 
    {
        if (pOptimalItems == null)
        {
            pOptimalItems = generatePOptimalItems();
        }
        return pOptimalItems;
    }

    private static List<Item> generatePOptimalItems() 
    {
        List<Item> toReturn = new ArrayList<>();
        List<Item> allItems = getAllItems();
        for (Item i : allItems)
        {
            if (i.isPOptimal()&&i.availableOnSummonersRift())
            {
                toReturn.add(i);
            }
        }
        return toReturn;
    }
    
    public static List<Item> getAllItems() 
    {
        if (allItems == null)
        {
            initItems();
        }
        return allItems;
    }

    public static Integer getItemID(Item i) 
    {
        return itemIDs.get(i);
    }
}
