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
public class GuinsoosRageblade extends Item
{
    @Override
    public double getAttackDamage() 
    {
        return 30;
    }

    @Override
    public double getAbilityPower() 
    {
        return 40;
    }
    @Override
    public int getCost() 
    {
        return 2600;
    }

    @Override
    public int getSalePrice() 
    {
        return (int)(this.getCost()*.7);
    }
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }
    
    @Override
    public boolean ragebladeEffect() 
    {
        return true;
    }
}
