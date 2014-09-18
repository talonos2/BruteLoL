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
public class AegisOfTheLegion extends Item
{   
    @Override
    public int getCost() 
    {
        return 1900;
    }

    @Override
    public int getSalePrice() 
    {
        return 1330;
    }
    
    @Override
    public double getHP()
    {
        return 200;
    }
    
    @Override
    public double getMagicResist()
    {
        return 20;
    }
    
    @Override
    public boolean getLegionEffect()
    {
        return true;
    }
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new RejuvenationBead());
        toReturn.add(new RubyCrystal());
        toReturn.add(new NegatronCloak());
        return toReturn;
    }
}
