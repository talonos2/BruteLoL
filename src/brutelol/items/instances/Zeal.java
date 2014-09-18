/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brutelol.items.instances;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class Zeal extends Item
{
    @Override
    public double getAttackSpeed() 
    {
        return .20;
    }

    @Override
    public double getCritChance() 
    {
        return .1;
    }

    @Override
    public int getCost() 
    {
        return 1100;
    }

    @Override
    public int getSalePrice() 
    {
        return 770;
    }

    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new Dagger());
        toReturn.add(new BrawlersGloves());
        return toReturn;
    }
    
    
}
