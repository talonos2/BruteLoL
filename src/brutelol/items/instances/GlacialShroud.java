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
public class GlacialShroud extends Item 
{
    @Override
    public int getCost() 
    {
        return 950;
    }

    @Override
    public int getSalePrice() 
    {
        return 665;
    }
    
    @Override
    public double getArmor()
    {
        return 20;
    }
    
    @Override
    public double getMana()
    {
        return 250;
    }
    
    //TODO: Uniquify this!
    @Override
    public double getCooldownReduction()
    {
        return .1;
    }
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new SapphireCrystal());
        toReturn.add(new ClothArmor());
        return toReturn;
    }
}
