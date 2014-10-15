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
public class FrozenHeart extends Item
{
    public static final double ATTACK_SPEED_REDUCTION = .15;

    public boolean frozenHeartEffect()
    {
        return true;
    }
    
    @Override
    public int getCost() 
    {
        return 2600;
    }

    @Override
    public int getSalePrice() 
    {
        return 1820;
    }
    
    @Override
    public double getArmor()
    {
        return 100;
    }
    
    @Override
    public double getMana()
    {
        return 400;
    }
    
    @Override
    public double getCooldownReduction()
    {
        return .2;
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
        toReturn.add(new WardensMail());
        toReturn.add(new GlacialShroud());
        return toReturn;
    }
}
