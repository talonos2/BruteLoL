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
public class Entropy extends Item
{
    @Override
    public double getAttackDamage() 
    {
        return 55;
    }

    @Override
    public int getCost() 
    {
        return 2700;
    }

    @Override
    public int getSalePrice() 
    {
        return 1890;
    }
    
        @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new Phage());
        toReturn.add(new Pickaxe());
        return toReturn;
    }
    
    @Override
    public double getHP()
    {
        return 275;
    }
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }
    
    @Override
    public boolean availableOnSummonersRift()
    {
        return false;
    }
    
    @Override
    public boolean availableOnTwistedTreeline()
    {
        return false;
    }

}
