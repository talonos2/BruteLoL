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
public class SeraphsEmbrace extends Item
{
    @Override
    public int getCost() 
    {
        return 100000;
    }

    @Override
    public int getSalePrice() 
    {
        return 1897;
    }
    
    @Override
    public double getMana()
    {
        return 1000;
    }
    
    @Override
    public double getAbilityPower()
    {
        return 60;
    }
    
    @Override
    public double getManaRegen()
    {
        return 10;
    }
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new ArchangelsStaff());
        return toReturn;
    }
    
    @Override
    public boolean getInsightEffect()
    {
        return true;
    }

    @Override
    public boolean isPOptimal() 
    {
        return true;
    }
    
    
}
