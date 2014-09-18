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
public class RunaansHurricane extends Item
{
    @Override
    public double getAttackSpeed() 
    {
        return .7;
    }

    @Override
    public int getCost() 
    {
        return 2400;
    }

    @Override
    public int getSalePrice() 
    {
        return 1680;
    }
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new Dagger());
        toReturn.add(new Dagger());
        toReturn.add(new RecurveBow());
        return toReturn;
    }
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }

    @Override
    public boolean hurricaneEffect() 
    {
        return true;
    }
}
