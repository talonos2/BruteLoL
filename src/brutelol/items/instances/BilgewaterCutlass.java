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
public class BilgewaterCutlass extends Item
{
    @Override
    public int getCost() 
    {
        return 1400;
    }

    @Override
    public int getSalePrice() 
    {
        return 980;
    }
    
    @Override
    public double getAttackDamage()
    {
        return 25;
    }
    
    @Override
    public double getLifeSteal()
    {
        return .08;
    }
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new Longsword());
        toReturn.add(new VampiricScepter());
        return toReturn;
    }
    
    @Override
    public boolean bilgewaterEffect() 
    {
        return true;
    }
}
