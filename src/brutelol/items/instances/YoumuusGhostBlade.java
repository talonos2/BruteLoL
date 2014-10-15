/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
public class YoumuusGhostBlade extends Item
{
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new AvariceBlade());
        toReturn.add(new BrawlersGloves());
        return toReturn;
    }
    
    @Override
    public double getAttackDamage() 
    {
        return 30;
    }
    
    @Override
    public double getCritChance() 
    {
        return .15;
    }
    
    @Override
    public double getCooldownReduction() 
    {
        return .1;
    }

    @Override
    public int getCost() 
    {
        return 2700;
    }

    @Override
    public int getSalePrice() 
    {
        return 1890;
    } 
    
    @Override
    public boolean getGhostbladeEffect()
    {
        return true;
    }
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }
}
