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
public class ClothArmor extends Item
{
    @Override
    public double getArmor() 
    {
        return 15;
    }

    @Override
    public int getCost() 
    {
        return 300;
    }

    @Override
    public int getSalePrice() 
    {
        return 210;
    }
}
