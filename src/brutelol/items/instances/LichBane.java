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
public class LichBane extends Item
{
    @Override
    public double getAbilityPower() 
    {
        return 80;
    }

    @Override
    public double getMana() 
    {
        return 250;
    }

    @Override
    public double getMoveSpeedPercent() 
    {
        return .05;
    }

    @Override
    public int getCost() 
    {
        return 3000;
    }

    @Override
    public int getSalePrice() 
    {
        return (int)(getCost()*.7);
    }

    @Override
    public int getSpellbladeLevel()
    {
        return 3;
    }

    @Override
    public boolean isPOptimal()
    {
        return true;
    }
}