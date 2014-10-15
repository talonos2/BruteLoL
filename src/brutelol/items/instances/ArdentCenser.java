/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.items.abstracts.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class ArdentCenser extends Item
{
    @Override
    public int getCost() 
    {
        return 2200;
    }

    @Override
    public int getSalePrice() 
    {
        return 1540;
    }
    
    @Override
    public double getManaRegen()
    {
        return 10;
    }
    
    @Override
    public double getAbilityPower()
    {
        return 40;
    }
    
    @Override
    public double getCooldownReduction()
    {
        return .1;
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
        toReturn.add(new AetherWisp());
        toReturn.add(new ForbiddenIdol());
        return toReturn;
    }
    
    @Override
    public double getMoveSpeedPercent()
    {
        return .08;
    }
}
