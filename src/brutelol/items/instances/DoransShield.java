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
public class DoransShield extends Item
{
    
    public static final double DAMAGE_BLOCKED = 8;
    
    public boolean shieldEffect()
    {
        return true;
    }
    
    @Override
    public double getHP()
    {
        return 80;
    }
    
    @Override
    public double getHealthRegen()
    {
        return 6;
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
    public boolean availableOnCrystalScar()
    {
        return false;
    }
}
