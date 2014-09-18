/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brutelol.items.instances;

/**
 *
 * @author Talonos
 */
public class Pickaxe extends Item
{

    public Pickaxe() {
    }

    @Override
    public double getAttackDamage() 
    {
        return 25;
    }

    @Override
    public int getCost() 
    {
        return 875;
    }

    @Override
    public int getSalePrice() 
    {
        return 613;
    }
    
}