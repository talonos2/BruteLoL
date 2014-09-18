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
public class LordVanDammsPillager extends Item
{
    @Override
    public double getCritChance() 
    {
        return .25;
    }

    @Override
    public double getAttackDamage() 
    {
        return 80;
    }

    @Override
    public int getCost() 
    {
        return 3800;
    }

    @Override
    public int getSalePrice() 
    {
        return (int)(getCost()*.7);
    }

    @Override
    public boolean enhancedCrit()
    {
        return true;
    }

    @Override
    public boolean availableOnSummonersRift()
    {
        return false;
    }

    @Override
    public boolean availableOnHowlingAbyss()
    {
        return false;
    }

    @Override
    public boolean isPOptimal()
    {
        return true;
    }
}
