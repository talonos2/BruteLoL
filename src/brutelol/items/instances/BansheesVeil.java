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
public class BansheesVeil extends Item
{
    @Override
    public int getCost() 
    {
        return 2750;
    }

    @Override
    public int getSalePrice() 
    {
        return 1925;
    }
    
    @Override
    public double getMagicResist()
    {
        return 55;
    }
    
    @Override
    public double getHP()
    {
        return 450;
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
        toReturn.add(new RubyCrystal());
        toReturn.add(new SpectresCowl());
        return toReturn;
    }
    
    @Override
    public boolean availableOnCrystalScar() 
    {
        return false;
    }
}
