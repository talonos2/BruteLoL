/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol;

import brutelol.characters.instances.Ashe;
import brutelol.characters.instances.GenericChar;
import brutelol.characters.instances.Rammus;
import brutelol.characters.instances.Soraka;
import brutelol.characters.instances.Xayah;
import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.charbuild.Build;
import brutelol.charbuild.ItemSet;
import brutelol.fights.Fight;
import brutelol.items.abstracts.Item;
import brutelol.items.instances.InfinityEdge;
import brutelol.items.instances.Items;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class FightTest 
{
    public static void main(String[] args)
    {
        Items.getAllItems();
        
        List<Item> xayahItems = new ArrayList<>();
        Items.getAllItems();
        xayahItems.add(new InfinityEdge());
        xayahItems.add(new InfinityEdge());
        ItemSet xi = new ItemSet(xayahItems);
        
        List<Item> eItems = new ArrayList<>();
        eItems.add(new InfinityEdge());
        ItemSet ei = new ItemSet(eItems);
        
        ItemSet ni = new ItemSet(new ArrayList<Item>());
        
        Fight f = new Fight();
        AbstractLolCharacter rammus = new Rammus(new Build(ni));
        AbstractLolCharacter ashe = new Ashe(new Build(ni));
        AbstractLolCharacter soraka = new Soraka(new Build(ni));
        AbstractLolCharacter enemy = new GenericChar(new Build(ni));
        f.addAlly(rammus, 1, 1);
        f.addEnemy(ashe, 1, 1);
        f.addEnemy(soraka, 1, 1);
        f.addEnemy(enemy, 1, 1);
        
        System.out.println(rammus.getStats());
        System.out.println(ashe.getStats());
        System.out.println(soraka.getStats());
        System.out.println(enemy.getStats());
        
        f.setTime(20);
        f.runFight();
    }
}
