/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brutelol.items.instances;

/**
 *
 * @author Talonos
 */
public class Longsword extends Item
{

    public Longsword() {
    }

    @Override
    public double getAttackDamage() 
    {
        return 10;
    }

    @Override
    public int getCost() 
    {
        return 360;
    }

    @Override
    public int getSalePrice() 
    {
        return 252;
    }
    
}
