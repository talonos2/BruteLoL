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
public class HauntingGuise extends Item
{
    @Override
    public double getHP() 
    {
        return 200;
    }

    @Override
    public double getAbilityPower() 
    {
        return 25;
    }
    @Override
    public int getCost() 
    {
        return 1485;
    }

    @Override
    public int getSalePrice() 
    {
        return (int)(this.getCost()*.7);
    }
    
    @Override
    public boolean guiseEffect() 
    {
        return true;
    }
}