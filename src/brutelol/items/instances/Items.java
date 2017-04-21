/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.charbuild.MapEnum;
import brutelol.items.abstracts.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Talonos
 */
public class Items 
{
    private static Map<MapEnum, List<Item>> pOptimalItems = new EnumMap<>(MapEnum.class);
    private static List<Item> allItems;
    private static Map<Item, Integer> itemIDs = new HashMap();
    
    private static void initItems()
    {
        allItems = new ArrayList<>();
        
        allItems.add(new NoItem());
        allItems.add(new InfinityEdge());
        
        int id = 0;
        for (Item i : allItems)
        {
            itemIDs.put(i, id++);
        }
    }

    /**
     * Gets all items that are pareto-optimal for a given map.
     * @param map the map to get items for.
     * @return a list of the pareto-optimal items for that map.
     */
    public static List<Item> generateOptimalItemsForMap(MapEnum map) 
    {
        if (allItems == null)
        {
            getAllItems();
        }
        if (!pOptimalItems.containsKey(map))
        {
            List<Item> pOptimalMapItems = new ArrayList<>();
            for (Item i : allItems)
            {
                if (i.isPOptimal()&&i.availableOnMap(map))
                {
                    pOptimalMapItems.add(i);
                }
            }
            pOptimalItems.put(map,pOptimalMapItems);
        }
        return pOptimalItems.get(map);
    }
    
    /**
     * Gets all items registered in the system. If the item system hasn't been
     * initialized, do so now.
     * @return a list of all registered items.
     */
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
