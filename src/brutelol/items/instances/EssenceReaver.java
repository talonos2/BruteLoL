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
public class EssenceReaver extends Item
{
    @Override
    public int getCost() 
    {
        return 3200;
    }

    @Override
    public int getSalePrice() 
    {
        return 1855;
    }
    
    @Override
    public double getAttackDamage()
    {
        return 80;
    }
    
    @Override
    public double getLifeSteal()
    {
        return .1;
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
        toReturn.add(new BFSword());
        toReturn.add(new VampiricScepter());
        return toReturn;
    }
    
    @Override
    public boolean reaverEffect()
    {
        return true;
    }
}
