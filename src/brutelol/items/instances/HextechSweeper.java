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
public class HextechSweeper extends Item
{
    @Override
    public double getArmor() 
    {
        return 25;
    }

    @Override
    public double getHP() 
    {
        return 225;
    }

    @Override
    public double getMana() 
    {
        return 250;
    }
    
    @Override
    public int getCost() 
    {
        return 2310;
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
    public boolean sweeperEffect() 
    {
        return true;
    }

    @Override
    public boolean availableOnSummonersRift() 
    {
        return false;
    }
}
