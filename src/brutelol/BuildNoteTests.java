/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol;

import brutelol.characters.instances.Minions;
import brutelol.characters.instances.Soraka;
import brutelol.characters.instances.Udyr;
import brutelol.characters.lib.HeuristicComponent;
import brutelol.charbuild.Build;
import brutelol.charbuild.ItemSet;
import brutelol.charbuild.runes.RunePage;
import brutelol.items.abstracts.Item;
import brutelol.items.instances.BladeOfTheRuinedKing;
import brutelol.items.instances.BootsOfSwiftness;
import brutelol.items.instances.GuardianAngel;
import brutelol.items.instances.InfinityEdge;
import brutelol.items.instances.Items;
import brutelol.items.instances.NashorsTooth;
import brutelol.items.instances.NoItem;
import brutelol.items.instances.RabadonsDeathcap;
import brutelol.items.instances.TrinityForce;
import brutelol.items.instances.WitsEnd;
import brutelol.items.instances.YoumuusGhostblade;
import brutelol.items.instances.ZhonyasHourglass;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class BuildNoteTests 
{
    public static void main(String args[])
    {
        List<Item> items1 = new ArrayList<>();
        Items.getAllItems();
        items1.add(new TrinityForce());
        items1.add(new BootsOfSwiftness());
        items1.add(new NashorsTooth());
        items1.add(new TrinityForce());
        items1.add(new WitsEnd());
        items1.add(new RabadonsDeathcap());
        ItemSet i = new ItemSet(items1);
        
        List<Item> eItems = new ArrayList<>();
        eItems.add(new ZhonyasHourglass());
        eItems.add(new GuardianAngel());
        ItemSet ei = new ItemSet(eItems);
        Build b = new Build(i, new Udyr(), 100000, 100000, 100000, new RunePage());
        Build enemy = new Build(ei, new Soraka(), 100000, 100000, 100000, new RunePage());
        
        b = BuildOptimizer.optimizeRunePage(b, enemy, HeuristicComponent.DAMAGE_PER_SECOND);
        
        System.out.println(b.getComponentMathNotes(HeuristicComponent.DAMAGE_PER_SECOND, enemy));
        
        
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        
        List<Item> items2= new ArrayList<>();
        items2.add(new TrinityForce());
        items2.add(new BootsOfSwiftness());
        items2.add(new NashorsTooth());
        items2.add(new InfinityEdge());
        items2.add(new InfinityEdge());
        items2.add(new InfinityEdge());
        i = new ItemSet(items2);
        
        b = new Build(i, new Udyr(), 100000, 100000, 100000, new RunePage());
        
        System.out.println(b.getComponentMathNotes(HeuristicComponent.DAMAGE_PER_SECOND, enemy));
        
        
    }
}
