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
public class FaerieCharm extends Item 
{
    @Override
    public double getManaRegen() 
    {
        return 3;
    }

    @Override
    public int getCost() 
    {
        return 180;
    }

    @Override
    public int getSalePrice() 
    {
        return 126;
    }  
}
