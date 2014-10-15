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
public class Dagger extends Item
{
    @Override
    public double getAttackSpeed() 
    {
        return .15;
    }

    @Override
    public int getCost() 
    {
        return 450;
    }

    @Override
    public int getSalePrice() 
    {
        return 315;
    }
}
