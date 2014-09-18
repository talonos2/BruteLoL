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
public class BladeOfTheRuinedKing extends Item{
    
    public static final double PASSIVE_PERCENT = .08;
    public static final double ACTIVE_PERCENT = .1;
    
    @Override
    public int getCost() 
    {
        return 3200;
    }

    @Override
    public int getSalePrice() 
    {
        return 2240;
    }
    
    @Override
    public double getAttackDamage()
    {
        return 25;
    }
    
    @Override
    public double getLifeSteal()
    {
        return .1;
    }
    
    @Override
    public double getAttackSpeed()
    {
        return .4;
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
        toReturn.add(new BilgewaterCutlass());
        toReturn.add(new Dagger());
        toReturn.add(new Dagger());
        return toReturn;
    }
    
    @Override
    public boolean ruinedKingEffect() 
    {
        return true;
    }
}
