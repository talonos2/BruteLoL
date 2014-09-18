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
public class LiandrysTorment extends Item
{
    @Override
    public double getAbilityPower() 
    {
        return 30;
    }

    @Override
    public double getHP() 
    {
        return 300;
    }

    @Override
    public int getCost() 
    {
        return 2900;
    }

    @Override
    public int getSalePrice() 
    {
        return (int)(getCost()*.7);
    }

    @Override
    public boolean guiseEffect()
    {
        return true;
    }
    
    @Override
    public boolean tormentEffect()
    {
        return true;
    }

    @Override
    public boolean isPOptimal()
    {
        return true;
    }
}