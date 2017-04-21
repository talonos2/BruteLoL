package brutelol;

import brutelol.characters.instances.Xayah;
import brutelol.characters.lib.BlankMasteries;
import brutelol.characters.lib.HeuristicComponent;
import brutelol.charbuild.Build;
import brutelol.charbuild.ItemSet;
import brutelol.charbuild.runes.RunePage;
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
        Build b = new Build(i, new Xayah(), 100000, 100000, 100000, new RunePage(), new BlankMasteries());
        Build enemy = new Build(ei, new Xayah(), 100000, 100000, 100000, new RunePage(), new BlankMasteries());
        
        b = BuildOptimizer.optimizeRunePage(b, enemy, HeuristicComponent.POKE_DAMAGE);
        
        System.out.println(b.getComponentMathNotes(HeuristicComponent.POKE_DAMAGE, enemy));
    }
}
