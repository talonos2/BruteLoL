/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class Items 
{
    private static List<Item> pOptimalItems;

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
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new AbyssalScepter());
        toReturn.add(new AegisOfTheLegion());
        toReturn.add(new AetherWisp());
        toReturn.add(new AmplifyingTome());
        toReturn.add(new AncientCoin());
        toReturn.add(new ArchangelsStaff());
        toReturn.add(new ArdentCenser());
        toReturn.add(new AthenesUnholyGrail());
        toReturn.add(new AtmasImpaler());
        toReturn.add(new AvariceBlade());
        toReturn.add(new BFSword());
        toReturn.add(new BannerOfCommand());
        toReturn.add(new BansheesVeil());
        toReturn.add(new BerserkersGreaves());
        toReturn.add(new BilgewaterCutlass());
        toReturn.add(new BlackfireTorch());
        toReturn.add(new BlackCleaver());
        toReturn.add(new BladeOfTheRuinedKing());
        toReturn.add(new BlastingWand());
        toReturn.add(new BloodThirster());
        toReturn.add(new BootsOfSpeed());
        toReturn.add(new BootsOfSwiftness());
        toReturn.add(new BrawlersGloves());
        toReturn.add(new CatalystTheProtector());
        toReturn.add(new ChainVest());
        toReturn.add(new ChaliceOfHarmony());
        toReturn.add(new CloakOfAgility());
        toReturn.add(new ClothArmor());
        toReturn.add(new Dagger());
        toReturn.add(new DeathfireGrasp());
        toReturn.add(new DervishBlade());
        toReturn.add(new DoransBlade());
        toReturn.add(new DoransShield());
        toReturn.add(new DoransRing());
        toReturn.add(new Entropy());
        toReturn.add(new EssenceReaver());
        toReturn.add(new ExecutionersCalling());
        toReturn.add(new FaceOfTheMountain());
        toReturn.add(new FaerieCharm());
        toReturn.add(new FiendishCodex());
        toReturn.add(new ForbiddenIdol());
        toReturn.add(new FrostFang());
        toReturn.add(new FrostQueensClaim());
        toReturn.add(new FrozenHeart());
        toReturn.add(new FrozenMallet());
        toReturn.add(new GiantsBelt());
        toReturn.add(new GuardianAngel());
        toReturn.add(new GuardiansHorn());
        toReturn.add(new GuinsoosRageblade());
        toReturn.add(new HauntingGuise());
        toReturn.add(new Hexdrinker());
        toReturn.add(new HextechGunblade());
        toReturn.add(new HextechRevolver());
        toReturn.add(new HextechSweeper());
        toReturn.add(new HuntersMachette());
        toReturn.add(new IcebornGuantlet());
        toReturn.add(new InfinityEdge());
        toReturn.add(new IonianBootsOfLucidity());
        toReturn.add(new Kindlegem());
        toReturn.add(new KitaesBloodrazor());
        toReturn.add(new LastWhisper());
        toReturn.add(new LiandrysTorment());
        toReturn.add(new LichBane());
        toReturn.add(new LocketOfTheIronSolari());
        toReturn.add(new Longsword());
        toReturn.add(new LordVanDammsPillager());
        toReturn.add(new MadredsRazors());
        
        toReturn.add(new RabadonsDeathcap());
        toReturn.add(new SeraphsEmbrace());
        toReturn.add(new NashorsTooth());
        
        toReturn.add(new SorcerersShoes());
        toReturn.add(new RunaansHurricane());
        toReturn.add(new StattikShiv());
        toReturn.add(new Zephyr());
        toReturn.add(new PhantomDancer());
        toReturn.add(new TrinityForce());
        toReturn.add(new Muramana());
        toReturn.add(new YoumuusGhostBlade());
        
        toReturn.add(new NoItem());
        return toReturn;
    }
}
