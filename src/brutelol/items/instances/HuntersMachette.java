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
public class HuntersMachette extends Item
{
    @Override
    public int getCost() 
    {
        return 325;
    }

    @Override
    public int getSalePrice() 
    {
        return (int)(this.getCost()*.7);
    }
    
    @Override
    public boolean machetteEffect() 
    {
        return true;
    }
}
