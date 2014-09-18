/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

/**
 *
 * @author Talonos
 */
public class HextechGunblade extends Item
{
    @Override
    public double getAbilityPower() 
    {
        return 65;
    }

    @Override
    public double getAttackDamage() 
    {
        return 45;
    }

    @Override
    public double getLifeSteal() 
    {
        return .1;
    }
    
    @Override
    public int getCost() 
    {
        return 3400;
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
    public boolean gunbladeEffect() 
    {
        return true;
    }
    
}
