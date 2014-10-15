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
public class ChaliceOfHarmony extends Item 
{
    @Override
    public int getCost() 
    {
        return 2600;
    }

    @Override
    public int getSalePrice() 
    {
        return 1820;
    }
    
    @Override
    public double getManaRegen()
    {
        return 7;
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
        toReturn.add(new FaerieCharm());
        toReturn.add(new FaerieCharm());
        toReturn.add(new NullMagicMantle());
        return toReturn;
    }
    
    @Override
    public boolean getManaFontEffect()
    {
        return true;
    }
    
    @Override
    public double getMagicResist()
    {
        return 20;
    }
    
}
