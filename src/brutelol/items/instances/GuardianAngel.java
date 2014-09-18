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
public class GuardianAngel extends Item
{

    @Override
    public double getArmor() {
        return super.getArmor(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getMagicResist() {
        return super.getMagicResist(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCost() 
    {
        return 2750;
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
    public boolean availableOnTwistedTreeline() 
    {
        return false;
    }

    @Override
    public boolean availableOnHowlingAbyss() 
    {
        return false;
    }
}
