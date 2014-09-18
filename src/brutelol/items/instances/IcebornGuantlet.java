/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

/**
 *
 * @author Talonos
 */
public class IcebornGuantlet extends Item
{
    @Override
    public double getArmor() 
    {
        return 60;
    }

    @Override
    public double getAbilityPower() 
    {
        return 30;
    }

    @Override
    public double getMana() 
    {
        return 500;
    }

    @Override
    public double getCooldownReduction() 
    {
        return .1;
    }
    
    @Override
    public int getCost() 
    {
        return 2900;
    }

    @Override
    public int getSalePrice() 
    {
        return (int)(this.getCost()*.7);
    }
    
    @Override
    public boolean isPOptimal() 
    {
        return true;
    }

    @Override
    public int getSpellbladeLevel() 
    {
        return 2; //TODO: Check!
    }
}
