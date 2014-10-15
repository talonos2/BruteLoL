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
public class FrostQueensClaim extends Item
{
    @Override
    public double getAbilityPower() 
    {
        return 50;
    }
    
    @Override
    public double getCooldownReduction() 
    {
        return .1;
    }
    
    @Override
    public double getManaRegen() 
    {
        return 10;
    }

    @Override
    public int getCost() 
    {
        return 2200;
    }

    @Override
    public int getSalePrice() 
    {
        return 880;
    }  
    
    @Override
    public int getTributeLevel() 
    {
        return 3;
    }  
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }
    
    @Override
    public boolean isGoldItem() 
    {
        return true;
    }    
    
    @Override
    public double getGoldPer10Boost() 
    {
        return 2;
    }
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new FrostFang());
        return toReturn;
    }
    
}
