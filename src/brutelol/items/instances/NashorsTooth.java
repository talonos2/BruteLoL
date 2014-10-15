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
public class NashorsTooth extends Item
{
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new Stinger());
        toReturn.add(new FiendishCodex());
        return toReturn;
    }
    
    @Override
    public double getAbilityPower() 
    {
        return 60;
    }
    
    @Override
    public double getAttackSpeed() 
    {
        return .5;
    }

    @Override
    public int getCost() 
    {
        return 2920;
    }

    @Override
    public int getSalePrice() 
    {
        return 2044;
    } 
    
    @Override
    public boolean getNashorsEffect()
    {
        return true;
    }
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }
}
