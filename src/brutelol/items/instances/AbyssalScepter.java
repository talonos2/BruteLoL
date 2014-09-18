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
public class AbyssalScepter extends Item
{
    public static final double AMOUNT = 20;
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }
    
    @Override
    public int getCost() 
    {
        return 2560;
    }

    @Override
    public int getSalePrice() 
    {
        return 1792;
    }
    
    @Override
    public double getAbilityPower()
    {
        return 70;
    }
    
    @Override
    public double getMagicResist()
    {
        return 45;
    }
    
    @Override
    public boolean getScepterEffect()
    {
        return true;
    }
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new BlastingWand());
        toReturn.add(new NegatronCloak());
        return toReturn;
    }
}
