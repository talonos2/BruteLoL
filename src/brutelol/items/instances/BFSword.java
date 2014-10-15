/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brutelol.items.instances;

import brutelol.items.abstracts.Item;

/**
 *
 * @author Talonos
 */
public class BFSword extends Item
{

    @Override
    public double getAttackDamage() 
    {
        return 50;
    }

    @Override
    public int getSalePrice() 
    {
        return 1085;
    }

    @Override
    public int getCost() 
    {
        return 1550;
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
