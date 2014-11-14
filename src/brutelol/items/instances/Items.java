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
        allItems.add(new AbyssalScepter());
        allItems.add(new AegisOfTheLegion());
        allItems.add(new AetherWisp());
        allItems.add(new AmplifyingTome());
        allItems.add(new AncientCoin());
        allItems.add(new ArchangelsStaff());
        allItems.add(new ArdentCenser());
        allItems.add(new AthenesUnholyGrail());
        allItems.add(new AtmasImpaler());
        allItems.add(new AvariceBlade());
        allItems.add(new BFSword());
        allItems.add(new BannerOfCommand());
        allItems.add(new BansheesVeil());
        allItems.add(new BerserkersGreaves());
        allItems.add(new BilgewaterCutlass());
        allItems.add(new BlackfireTorch());
        allItems.add(new BlackCleaver());
        allItems.add(new BladeOfTheRuinedKing());
        allItems.add(new BlastingWand());
        allItems.add(new BloodThirster());
        allItems.add(new BootsOfSpeed());
        allItems.add(new BootsOfSwiftness());
        allItems.add(new BrawlersGloves());
        allItems.add(new CatalystTheProtector());
        allItems.add(new ChainVest());
        allItems.add(new ChaliceOfHarmony());
        allItems.add(new CloakOfAgility());
        allItems.add(new ClothArmor());
        allItems.add(new Dagger());
        allItems.add(new DeathfireGrasp());
        allItems.add(new DervishBlade());
        allItems.add(new DoransBlade());
        allItems.add(new DoransShield());
        allItems.add(new DoransRing());
        allItems.add(new Entropy());
        allItems.add(new EssenceReaver());
        allItems.add(new ExecutionersCalling());
        allItems.add(new FaceOfTheMountain());
        allItems.add(new FaerieCharm());
        allItems.add(new FiendishCodex());
        allItems.add(new ForbiddenIdol());
        allItems.add(new FrostFang());
        allItems.add(new FrostQueensClaim());
        allItems.add(new FrozenHeart());
        allItems.add(new FrozenMallet());
        allItems.add(new GiantsBelt());
        allItems.add(new GuardianAngel());
        allItems.add(new GuardiansHorn());
        allItems.add(new GuinsoosRageblade());
        allItems.add(new HauntingGuise());
        allItems.add(new Hexdrinker());
        allItems.add(new HextechGunblade());
        allItems.add(new HextechRevolver());
        allItems.add(new HextechSweeper());
        allItems.add(new HuntersMachette());
        allItems.add(new IcebornGuantlet());
        allItems.add(new InfinityEdge());
        allItems.add(new IonianBootsOfLucidity());
        allItems.add(new Kindlegem());
        allItems.add(new KitaesBloodrazor());
        allItems.add(new LastWhisper());
        allItems.add(new LiandrysTorment());
        allItems.add(new LichBane());
        allItems.add(new LocketOfTheIronSolari());
        allItems.add(new Longsword());
        allItems.add(new LordVanDammsPillager());
        allItems.add(new MadredsRazors());
        
        allItems.add(new RabadonsDeathcap());
        allItems.add(new SeraphsEmbrace());
        allItems.add(new NashorsTooth());
        
        allItems.add(new SorcerersShoes());
        allItems.add(new RunaansHurricane());
        allItems.add(new StattikShiv());
        allItems.add(new Zephyr());
        allItems.add(new PhantomDancer());
        allItems.add(new TrinityForce());
        allItems.add(new Muramana());
        allItems.add(new YoumuusGhostBlade());
        
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
