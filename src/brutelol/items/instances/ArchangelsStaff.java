/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class ArchangelsStaff extends Item
{
    int extraMana;
    
    @Override
    public int getCost() 
    {
        return 2700;
    }

    @Override
    public int getSalePrice() 
    {
        return 1890;
    }
    
    @Override
    public double getMana()
    {
        return 250+extraMana;
    }
    
    @Override
    public double getAbilityPower()
    {
        return 60;
    }
    
    @Override
    public double getManaRegen()
    {
        return 10;
    }
    
    @Override
    public double getManaChargeEffect()
    {
        return 2;
    }
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new TearOfTheGoddess());
        toReturn.add(new BlastingWand());
        return toReturn;
    }
    
    @Override
    public boolean getInsightEffect()
    {
        return true;
    }
   
}
