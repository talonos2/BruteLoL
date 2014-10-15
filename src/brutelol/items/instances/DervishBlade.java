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
public class DervishBlade extends Item
{
    @Override
    public double getAttackSpeed() 
    {
        return .5;
    }
    
    @Override
    public double getCooldownReduction() 
    {
        return .1;
    }

    @Override
    public double getMagicResist() 
    {
        return 45;
    }
    
    @Override
    public int getCost() 
    {
        return 3000;
    }

    @Override
    public int getSalePrice() 
    {
        return 2100;
    }
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new Stinger());
        toReturn.add(new QuicksilverSash());
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
    
    @Override
    public boolean isPOptimal()
    {
        return true;
    }
    
}
