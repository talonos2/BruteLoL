/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brutelol.items.instances;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class BloodThirster extends Item
{
    @Override
    public double getAttackDamage() 
    {
        return 80;
    }

    @Override
    public int getCost() 
    {
        return 3500;
    }

    @Override
    public int getSalePrice() 
    {
        return 2450;
    }
    
        @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new BFSword());
        toReturn.add(new VampiricScepter());
        return toReturn;
    }
    
    @Override
    public boolean bloodthirsterEffect()
    {
        return true;
    }
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }
    
    @Override
    public boolean availableOnHowlingAbyss()
    {
        return false;
    }
    
    @Override
    public boolean availableOnTwistedTreeline()
    {
        return false;
    }
    
    @Override
    public boolean availableOnCrystalScar()
    {
        return false;
    }
    
}
