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
public class InfinityEdge extends Item
{

    @Override
    public double getCritChance() 
    {
        return .25;
    }

    @Override
    public double getAttackDamage() 
    {
        return 80;
    }

    @Override
    public int getCost() 
    {
        return 3800;
    }

    @Override
    public int getSalePrice() 
    {
        return 2660;
    }

    @Override
    public boolean enhancedCrit() 
    {
        return true;
    }

    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new BFSword());
        toReturn.add(new Pickaxe());
        toReturn.add(new CloakOfAgility());
        return toReturn;
    }
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }
    
}
