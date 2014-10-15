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
public class FrozenMallet extends Item
{
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
    public double getHP()
    {
        return 700;
    }
    
    @Override
    public double getAttackDamage()
    {
        return 30;
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
        toReturn.add(new Pickaxe());
        toReturn.add(new GiantsBelt());
        return toReturn;
    }
}
