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
public class ExecutionersCalling extends Item
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
    public double getAttackDamage()
    {
        return 25;
    }
    
    @Override
    public double getCritChance()
    {
        return .20;
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
        toReturn.add(new AvariceBlade());
        toReturn.add(new Longsword());
        return toReturn;
    }
}
