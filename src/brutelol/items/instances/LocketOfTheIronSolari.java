/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.items.abstracts.Item;

/**
 *
 * @author Talonos
 */
public class LocketOfTheIronSolari extends Item
{
    @Override
    public double getCooldownReduction() 
    {
        return .1;
    }

    @Override
    public double getHP() 
    {
        return 400;
    }

    @Override
    public double getMagicResist() 
    {
        return 40;
    }

    @Override
    public double getHealthRegen() 
    {
        return 10;
    }

    @Override
    public int getCost() 
    {
        return 2800;
    }

    @Override
    public int getSalePrice() 
    {
        return (int)(getCost()*.7);
    }

    @Override
    public boolean solariEffect()
    {
        return true;
    }

    @Override
    public boolean isPOptimal()
    {
        return true;
    }
}