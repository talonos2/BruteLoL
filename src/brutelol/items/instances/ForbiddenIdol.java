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
class ForbiddenIdol extends Item 
{
    @Override
    public double getManaRegen() 
    {
        return 8;
    }

    @Override
    public int getCost() 
    {
        return 700;
    }

    @Override
    public int getSalePrice() 
    {
        return 490;
    }  
    
    @Override
    public boolean getIdolEffect() 
    {
        return true;
    }  
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new FaerieCharm());
        toReturn.add(new FaerieCharm());
        return toReturn;
    }
}
