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
public class LastWhisper extends Item
{
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new Longsword());
        toReturn.add(new Pickaxe());
        return toReturn;
    }
    
        @Override
    public double getAttackDamage() 
    {
        return 40;
    }

    @Override
    public int getCost() 
    {
        return 2300;
    }

    @Override
    public int getSalePrice() 
    {
        return 1610;
    }

    @Override
    public double getArmorPenetrationPercent() 
    {
        //return .35;
        return 0;
    }    
    
    public boolean lastWhisperEffect()
    {
        return true;
    }
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }
}
