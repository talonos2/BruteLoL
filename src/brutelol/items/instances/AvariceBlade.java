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
public class AvariceBlade extends Item
{

    public AvariceBlade() 
    {
    }
    
    @Override
    public double getGoldPer10Boost()
    {
        return 3;
    }
    
    @Override
    public double getGoldPerKillBoost()
    {
        return 2;
    }
    
    @Override
    public double getCritChance()
    {
        return .1;
    }

    @Override
    public int getCost() 
    {
        return 800;
    }

    @Override
    public int getSalePrice() 
    {
        return 320;
    }
    
        @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new BrawlersGloves());
        return toReturn;
    }
    
}
