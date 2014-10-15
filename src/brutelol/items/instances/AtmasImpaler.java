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
public class AtmasImpaler extends Item
{
    public static final double AMOUNT = .015;
    
    @Override
    public int getCost() 
    {
        return 2300;
    }

    @Override
    public int getSalePrice() 
    {
        return 1610;
    }
    
    @Override
    public double getArmor()
    {
        return 45;
    }
    
    @Override
    public double getCritChance()
    {
        return .15;
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
        toReturn.add(new ChainVest());
        toReturn.add(new AvariceBlade());
        return toReturn;
    }
    
    @Override
    public boolean getImpalerEffect()
    {
        return true;
    }
}
