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
public class GuardiansHorn extends Item
{

    @Override
    public double getHealthRegen() 
    {
        return 12;
    }

    @Override
    public double getHP() 
    {
        return 180;
    }
    @Override
    public int getCost() 
    {
        return 2750;
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
}
