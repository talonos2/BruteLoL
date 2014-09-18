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
public class BlackCleaver extends Item
{
    @Override
    public int getCost() 
    {
        return 3000;
    }

    @Override
    public int getSalePrice() 
    {
        return 2100;
    }
    
    @Override
    public double getArmorPenetrationFlat()
    {
        return 10;
    }
    
    @Override
    public double getAttackDamage()
    {
        return 50;
    }
    
    @Override
    public double getCooldownReduction()
    {
        return .1;
    }
    
    @Override
    public double getHP()
    {
        return 200;
    }
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }
    
    @Override
    public boolean getBlackCleaverEffect() 
    {
        return true;
    }
    
    @Override
    public List<Item> getPrerequisites() 
    {
        List<Item> toReturn = new ArrayList<>();
        toReturn.add(new Brutalizer());
        toReturn.add(new RubyCrystal());
        return toReturn;
    }
    
    @Override
    public double getMoveSpeedPercent()
    {
        return .08;
    }
}
