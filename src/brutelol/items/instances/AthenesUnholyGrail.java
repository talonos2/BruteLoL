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
public class AthenesUnholyGrail extends Item
{
    @Override
    public int getCost() 
    {
        return 2600;
    }

    @Override
    public int getSalePrice() 
    {
        return 1820;
    }
    
    @Override
    public double getManaRegen()
    {
        return 10;
    }
    
    @Override
    public double getAbilityPower()
    {
        return 60;
    }
    
    @Override
    public double getCooldownReduction()
    {
        return .2;
    }
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new FiendishCodex());
        toReturn.add(new ChaliceOfHarmony());
        return toReturn;
    }
    
    @Override
    public boolean getManaFontEffect()
    {
        return true;
    }
    
    @Override
    public double getMagicResist()
    {
        return 25;
    }
}
