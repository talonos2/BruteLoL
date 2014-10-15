/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.items.abstracts.Item;

/**
 *
 * @author Talonos
 */
public class AncientCoin extends Item
{
    @Override
    public int getCost() 
    {
        return 365;
    }

    @Override
    public int getSalePrice() 
    {
        return 146;
    }
    
    @Override
    public double getManaRegen()
    {
        return 3;
    }
    
    @Override
    public double getFavorEffect()
    {
        return 2;
    }
    
    @Override
    public boolean isGoldItem()
    {
        return true;
    }
}
