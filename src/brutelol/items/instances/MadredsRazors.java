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
public class MadredsRazors extends Item
{
    @Override
    public double getAttackSpeed() 
    {
        return .15;
    }

    @Override
    public int getCost() 
    {
        return 775;
    }

    @Override
    public int getSalePrice() 
    {
        return (int)(getCost()*.7);
    }

    @Override
    public int maimLevel()
    {
        return 1;
    }

}
