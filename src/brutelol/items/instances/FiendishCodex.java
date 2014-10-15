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
public class FiendishCodex extends Item 
{
    @Override
    public double getAbilityPower() 
    {
        return 30;
    }
    
    @Override
    public double getCooldownReduction() 
    {
        return .1;
    }

    @Override
    public int getCost() 
    {
        return 820;
    }

    @Override
    public int getSalePrice() 
    {
        return 574;
    }  
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new AmplifyingTome());
        return toReturn;
    }
}
