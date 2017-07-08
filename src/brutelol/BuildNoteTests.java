package brutelol;

import brutelol.characters.instances.Xayah;
import brutelol.characters.lib.HeuristicComponent;
import brutelol.charbuild.Build;
import brutelol.charbuild.ItemSet;
import brutelol.items.abstracts.Item;
import brutelol.items.instances.InfinityEdge;
import brutelol.items.instances.Items;
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
        items1.add(new InfinityEdge());
        items1.add(new InfinityEdge());
        ItemSet i = new ItemSet(items1);
        
        List<Item> eItems = new ArrayList<>();
        eItems.add(new InfinityEdge());
        ItemSet ei = new ItemSet(eItems);
        Build b = new Build(i, new Xayah(), 18, 2400);
        Build enemy = new Build(ei, new Xayah(), 18, 2400);
        
        System.out.println(b.getComponentMathNotes(HeuristicComponent.RAW_POKE_DAMAGE));
    }
}
