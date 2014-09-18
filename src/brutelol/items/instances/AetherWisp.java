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
public class AetherWisp extends Item
{
    @Override
    public int getCost() 
    {
        return 950;
    }

    @Override
    public int getSalePrice() 
    {
        return 665;
    }
    
    @Override
    public double getMoveSpeedPercent()
    {
        return .05;
    }
    
    @Override
    public double getAbilityPower()
    {
        return 30;
    }
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new AmplifyingTome());
        return toReturn;
    }
}
