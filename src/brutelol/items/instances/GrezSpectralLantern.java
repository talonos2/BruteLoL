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
public class GrezSpectralLantern extends Item
{
    //TODO: Minion and monster stuff.

    @Override
    public double getAttackDamage() 
    {
        return 15;
    }
    
    @Override
    public double getAttackSpeed() 
    {
        return .3;
    }

    @Override
    public int getCost() 
    {
        return 1765;
    }

    @Override
    public int getSalePrice() 
    {
        return 706;
    }

    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new MadredsRazors());
        toReturn.add(new Longsword());
        toReturn.add(new Dagger());
        return toReturn;
    }
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }

    @Override
    public boolean availableOnCrystalScar() 
    {
        return false;
    }

    @Override
    public boolean availableOnHowlingAbyss() 
    {
        return false;
    }

    @Override
    public boolean availableOnSummonersRift() 
    {
        return false;
    }

}
