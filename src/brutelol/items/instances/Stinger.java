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
public class Stinger extends Item
{
    @Override
    public double getAttackSpeed() 
    {
        return .4;
    }
    
    @Override
    public int getCost() 
    {
        return 1250;
    }

    @Override
    public int getSalePrice() 
    {
        return 875;
    }
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new Dagger());
        toReturn.add(new Dagger());
        return toReturn;
    }
}
