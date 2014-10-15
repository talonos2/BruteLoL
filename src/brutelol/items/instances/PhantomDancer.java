/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brutelol.items.instances;

import brutelol.items.abstracts.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class PhantomDancer extends Item
{
    @Override
    public double getAttackSpeed()
    {
        return .5;
    }

    @Override
    public double getCritChance() 
    {
        return .3;
    }
    
    @Override
    public int getCost() 
    {
        return 2800;
    }

    @Override
    public int getSalePrice() 
    {
        return 1960;
    }
    
        @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new Zeal());
        toReturn.add(new Dagger());
        toReturn.add(new CloakOfAgility());
        return toReturn;
    }
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }
}
