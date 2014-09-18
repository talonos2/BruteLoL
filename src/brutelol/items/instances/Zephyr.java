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
public class Zephyr extends Item
{
    @Override
    public double getAttackSpeed() 
    {
        return .5;
    }
    
    @Override
    public double getAttackDamage() 
    {
        return 25;
    }

    @Override
    public int getCost() 
    {
        return 2850;
    }

    @Override
    public int getSalePrice() 
    {
        return 1995;
    }
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new Stinger());
        toReturn.add(new Pickaxe());
        return toReturn;
    }
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }
}
