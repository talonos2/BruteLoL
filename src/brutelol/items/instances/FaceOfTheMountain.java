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
public class FaceOfTheMountain extends Item
{
    @Override
    public int getCost() 
    {
        return 2200;
    }

    @Override
    public int getSalePrice() 
    {
        return 880;
    }
    
    @Override
    public double getHP()
    {
        return 500;
    }
    
    @Override
    public double getHealthRegen()
    {
        return 20;
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
        toReturn.add(new TargonsBrace());
        toReturn.add(new Kindlegem());
        return toReturn;
    }
    
    public boolean mountainFaceEffect()
    {
        return true;
    }
}
