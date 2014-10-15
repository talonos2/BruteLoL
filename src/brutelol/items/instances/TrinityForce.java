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
public class TrinityForce extends Item
{
    @Override
    public double getAbilityPower() 
    {
        return 30;
    }
    
    @Override
    public double getAttackDamage() 
    {
        return 30;
    }
    
    @Override
    public double getAttackSpeed() 
    {
        return .3;
    }
    
    @Override
    public double getCritChance() 
    {
        return .1;
    }

    @Override
    public double getHP() 
    {
        return 250;
    }
    
    @Override
    public double getMana() 
    {
        return 200;
    }
    
    @Override
    public double getMoveSpeedPercent() 
    {
        return .08;
    }

    @Override
    public int getCost() 
    {
        return 3703;
    }

    @Override
    public int getSalePrice() 
    {
        return 2592;
    }
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new Zeal());
        toReturn.add(new Sheen());
        toReturn.add(new Phage());
        return toReturn;
    }
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }

    @Override
    public int getSpellbladeLevel() 
    {
        return 3;
    }
}
