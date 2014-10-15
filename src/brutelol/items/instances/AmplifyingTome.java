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
public class AmplifyingTome extends Item 
{

    public AmplifyingTome() 
    {
    }
    
    @Override
    public int getCost() 
    {
        return 435;
    }

    @Override
    public int getSalePrice() 
    {
        return 305;
    }
    
    @Override
    public double getAbilityPower()
    {
        return 20;
    }
}
