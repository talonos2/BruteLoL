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
public class Hexdrinker extends Item
{
    @Override
    public double getMagicResist() 
    {
        return 25;
    }

    @Override
    public double getAttackDamage() 
    {
        return 25;
    }
    @Override
    public int getCost() 
    {
        return 1350;
    }

    @Override
    public int getSalePrice() 
    {
        return (int)(this.getCost()*.7);
    }
}
