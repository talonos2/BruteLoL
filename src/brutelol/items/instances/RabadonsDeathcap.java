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
public class RabadonsDeathcap extends Item
{
    @Override
    public double getAbilityPower()
    {
        return 120;
    }
    
    @Override
    public boolean getDeathcapEffect()
    {
        return true;
    }
    
    @Override
    public int getCost() 
    {
        return 3300;
    }

    @Override
    public int getSalePrice() 
    {
        return 2310;
    }
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new Zeal());
        toReturn.add(new Dagger());
        toReturn.add(new CloakOfAgility());
        return toReturn;
    }
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }
}
