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
public class CatalystTheProtector extends Item
{
    @Override
    public double getHP() 
    {
        return 200;
    }
    
    @Override
    public double getMana() 
    {
        return 300;
    }

    @Override
    public int getCost() 
    {
        return 1200;
    }

    @Override
    public int getSalePrice() 
    {
        return 840;
    }  
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new RubyCrystal());
        toReturn.add(new SapphireCrystal());
        return toReturn;
    }
}
