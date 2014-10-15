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
public class DeathfireGrasp extends Item
{
    public static final double DAMAGE_PERCENT = .15;
    public static final double AMPLIFY_PERCENT = .2;
    @Override
    public int getCost() 
    {
        return 3100;
    }

    @Override
    public int getSalePrice() 
    {
        return 2170;
    }
    
    @Override
    public double getAbilityPower()
    {
        return 120;
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
        toReturn.add(new NeedlesslyLargeRod());
        toReturn.add(new FiendishCodex());
        return toReturn;
    }
    
    @Override
    public boolean availableOnTwistedTreeline()
    {
        return false;
    }
    
    @Override
    public boolean availableOnCrystalScar()
    {
        return false;
    }
    
    @Override
    public boolean deathfireGraspEffect() 
    {
        return true;
    }
}
