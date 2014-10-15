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
public class BrawlersGloves extends Item
{
    @Override
    public double getCritChance() 
    {
        return .08;
    }

    @Override
    public int getCost() 
    {
        return 400;
    }

    @Override
    public int getSalePrice() 
    {
        return 280;
    }    
}
