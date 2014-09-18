/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class BlackfireTorch extends Item
{
    @Override
    public int getCost() 
    {
        return 2650;
    }

    @Override
    public int getSalePrice() 
    {
        return 1855;
    }
    
    @Override
    public double getAbilityPower()
    {
        return 80;
    }
    
    @Override
    public double getCooldownReduction()
    {
        return .1;
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
        toReturn.add(new BlastingWand());
        toReturn.add(new FiendishCodex());
        return toReturn;
    }
    
    @Override
    public boolean availableOnSummonersRift()
    {
        return false;
    }
    
    @Override
    public boolean availableOnHowlingAbyss()
    {
        return false;
    }
}
