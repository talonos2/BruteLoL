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
public class RecurveBow extends Item
{
    @Override
    public double getAttackSpeed() 
    {
        return .3;
    }

    @Override
    public int getCost() 
    {
        return 900;
    }

    @Override
    public int getSalePrice() 
    {
        return 630;
    }
}
