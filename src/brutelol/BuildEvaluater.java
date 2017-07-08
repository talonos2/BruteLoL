package brutelol;

import brutelol.characters.instances.Xayah;
import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.characters.lib.HeuristicComponent;
import brutelol.charbuild.Build;
import brutelol.charbuild.ItemSet;
import brutelol.items.abstracts.Item;
import brutelol.items.instances.InfinityEdge;
import brutelol.items.instances.Items;
import java.util.ArrayList;
import java.util.List;

/**
 * This main function is for testing. It evaluates a single hard-coded build.
 * @author Talonos
 */
public class BuildEvaluater 
{
    public static void main(String[] args)
    {
        Items.getAllItems();

        Build enemyTank = getEnemy();
        
        List<Item> myItemList = new ArrayList<>();
        {
            myItemList.add(new InfinityEdge());
        }
        AbstractLolCharacter me = new Xayah();
        
        Build toTest = new Build(new ItemSet(myItemList), me, 18, 2400);
        
        List<Build> foes = new ArrayList<>();
}

    private static Build getEnemy() 
    {
        List<Item> itemList = new ArrayList<>();
        {
            itemList.add(new InfinityEdge());
        }
        AbstractLolCharacter tank = new Xayah();
        return new Build(new ItemSet(itemList), tank, 18, 2400);
    }
}
    
