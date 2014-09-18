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
public class FrostFang extends Item
{
    @Override
    public double getAbilityPower() 
    {
        return 10;
    }
    
    @Override
    public double getManaRegen() 
    {
        return 5;
    }

    @Override
    public int getCost() 
    {
        return 865;
    }

    @Override
    public int getSalePrice() 
    {
        return 346;
    }  
    
    @Override
    public int getTributeLevel() 
    {
        return 2;
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
        toReturn.add(new SpellthiefsEdge());
        return toReturn;
    }
}
