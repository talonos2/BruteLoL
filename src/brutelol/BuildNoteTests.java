/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol;

import brutelol.characters.instances.Minions;
import brutelol.characters.instances.Soraka;
import brutelol.characters.lib.HeuristicComponent;
import brutelol.charbuild.Build;
import brutelol.charbuild.ItemSet;
import brutelol.items.abstracts.Item;
import brutelol.items.instances.Items;
import brutelol.items.instances.NoItem;
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
        List<Item> items = new ArrayList<>();
        Items.getAllItems();
        items.add(new NoItem());
        items.add(new NoItem());
        items.add(new NoItem());
        items.add(new NoItem());
        items.add(new NoItem());
        items.add(new NoItem());
        ItemSet i = new ItemSet(items);
        Build b = new Build(i, new Soraka(), 100000, 100000, 100000);
        Build enemy = new Build(i, new Minions(), 100000, 100000, 100000);
        System.out.println(b.getComponentMathNotes(HeuristicComponent.HEALING_PER_SECOND, enemy));
    }
}
