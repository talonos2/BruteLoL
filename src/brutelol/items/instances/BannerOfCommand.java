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
public class BannerOfCommand extends Item
{
    @Override
    public int getCost() 
    {
        return 2400;
    }

    @Override
    public int getSalePrice() 
    {
        return 1680;
    }
    
    @Override
    public double getAbilityPower()
    {
        return 80;
    }
    
    @Override
    public double getCooldownReduction()
    {
        return .2;
    }
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new FiendishCodex());
        toReturn.add(new BlastingWand());
        return toReturn;
    }
}
