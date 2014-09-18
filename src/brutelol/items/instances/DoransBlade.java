/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brutelol.items.instances;

/**
 *
 * @author Talonos
 */
public class DoransBlade extends Item
{

    public DoransBlade() 
    {

    }
    @Override
    
    public double getAttackDamage()
    {
        return 7;
    }
    
    @Override
    public int getCost()
    {
        return 440;
    }

    @Override
    public int getSalePrice() 
    {
        return 176;
    }
    
    @Override
    public double getLifeSteal()
    {
        return .03;
    }
    
    @Override
    public boolean availableOnCrystalScar()
    {
        return false;
    }
    
    @Override
    public double getHP()
    {
        return 70;
    }
}
