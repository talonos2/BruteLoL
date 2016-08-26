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
        
        allItems.add(new RejuvenationBead());
        allItems.add(new FaerieCharm());
        allItems.add(new ClothArmor());
        allItems.add(new BootsOfSpeed());
        allItems.add(new AncientCoin());
        
        allItems.add(new BootsOfSwiftness());
        allItems.add(new BerserkersGreaves());
        
        
        allItems.add(new LastWhisper());
        
        allItems.add(new RunaansHurricane());
        
        allItems.add(new WitsEnd());
        
        allItems.add(new NinjaTabi());
        allItems.add(new Thornmail());
        allItems.add(new GuinsoosRageblade());
        allItems.add(new AthenesUnholyGrail());
        allItems.add(new FrozenHeart());
        allItems.add(new MoonflairSpellblade());
        allItems.add(new SunfireCape());
        allItems.add(new BlackfireTorch());
        allItems.add(new Entropy());
        allItems.add(new YoumuusGhostblade());
        allItems.add(new ArchangelsStaff());
        allItems.add(new SeraphsEmbrace());
        allItems.add(new GuardianAngel());
        allItems.add(new BansheesVeil());
        allItems.add(new SpiritVisage());
        allItems.add(new LocketOfTheIronSolari());
        allItems.add(new RodOfAges());
        allItems.add(new PhantomDancer());
        allItems.add(new WarmogsArmor());
        allItems.add(new Zephyr());
        allItems.add(new LiandrysTorment());
        allItems.add(new IcebornGauntlet());
        allItems.add(new RylaisCrystalSceptor());
        allItems.add(new NashorsTooth());
        allItems.add(new LichBane());
        allItems.add(new RanduinsOmen());
        allItems.add(new BlackCleaver());
        allItems.add(new DervishBlade());
        allItems.add(new DeathfireGrasp());
        allItems.add(new EssenceReaver());
        allItems.add(new BladeOfTheRuinedKing());
        allItems.add(new MawOfMalmortius());
        allItems.add(new ZhonyasHourglass());
        allItems.add(new FrozenMallet());
        allItems.add(new RabadonsDeathcap());
        allItems.add(new RavenousHydra());
        allItems.add(new HextechGunblade());
        allItems.add(new WoogletsWitchcap());
        allItems.add(new Bloodthirster());
        allItems.add(new TrinityForce());
        allItems.add(new InfinityEdge());
        allItems.add(new MercurialScimitar());
        allItems.add(new LordVanDammsPillager());
        allItems.add(new StatikkShiv());
        
        allItems.add(new NoItem());
        
        int id = 0;
        for (Item i : allItems)
        {
            itemIDs.put(i, id++);
        }
    }

    public static List<Item> getAllPOptimalItems(MapEnum map) 
    {
        if (pOptimalItems == null)
        {
            pOptimalItems = generateOptimalItemsForMap(map);
        }
        return pOptimalItems;
    }

    private static List<Item> generateOptimalItemsForMap(MapEnum map) 
    {
        List<Item> toReturn = new ArrayList<>();
        List<Item> allItems = getAllItems();
        for (Item i : allItems)
        {
            if (i.isPOptimal()&&i.availableOnMap(map))
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
