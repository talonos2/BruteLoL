/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brutelol.items.instances;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class VampiricScepter extends Item
{
    @Override
    public double getAttackDamage() 
    {
        return 10;
    }

    @Override
    public int getCost() 
    {
        return 800;
    }

    @Override
    public int getSalePrice() 
    {
        return 560;
    }
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new Longsword());
        return toReturn;
    }
    
    @Override
    public double getLifeSteal()
    {
        return .08;
    }
}
