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
public class SorcerersShoes extends Item
{
    @Override
    public double getMagicPenetrationFlat() 
    {
        return 15;
    }
    
        @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new BootsOfSpeed());
        return toReturn;
    }
    
        @Override
    public int getCost()
    {
        return 1100;
    }

    @Override
    public int getSalePrice() 
    {
        return 770;
    }
    
    @Override
    public boolean isBoots()
    {
        return true;
    }
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }
    
    @Override
    public double getMoveSpeedFlat()
    {
        return 45;
    }
}
