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
public class DoransRing extends Item
{
    public static final double MP_PER_KILL = 4;
    
    public boolean ringEffect()
    {
        return true;
    }

    @Override
    public double getAbilityPower()
    {
        return 15;
    }
    
    @Override
    public double getHP()
    {
        return 60;
    }
    
    @Override
    public double getManaRegen()
    {
        return 3;
    }
    
    @Override
    public int getCost()
    {
        return 400;
    }

    @Override
    public int getSalePrice() 
    {
        return 160;
    }

    @Override
    public boolean availableOnCrystalScar()
    {
        return false;
    }
}
