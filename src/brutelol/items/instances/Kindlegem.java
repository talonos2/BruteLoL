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
public class Kindlegem extends Item 
{
    @Override
    public double getHP() 
    {
        return 200;
    }
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new RubyCrystal());
        return toReturn;
    }
    
    @Override
    public int getCost()
    {
        return 850;
    }

    @Override
    public int getSalePrice() 
    {
        return 700;
    }
    
    @Override
    public boolean kindleEffect() 
    {
        return true;
    }
    
}
