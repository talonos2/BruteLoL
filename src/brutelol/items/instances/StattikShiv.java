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
public class StattikShiv extends Item
{
    @Override
    public double getAttackSpeed() 
    {
        return .4;
    }

    @Override
    public double getCritChance() 
    {
        return .2;
    }

    @Override
    public int getCost() 
    {
        return 2500;
    }

    @Override
    public int getSalePrice() 
    {
        return 1750;
    }

    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new Zeal());
        toReturn.add(new AvariceBlade());
        return toReturn;
    }

    @Override
    public boolean shivEffect() 
    {
        return true;
    }
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }
    
}
