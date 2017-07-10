/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.items.abstracts.BUnique;
import brutelol.items.abstracts.CUnique;
import brutelol.items.abstracts.Item;

/**
 *
 * @author Talonos
 */
public class BloodThirster extends Item
{
    public BloodThirster()
    {
        //Since patch 7.13;
        super();
        this.attackDamage = 80;
        
        this.cost = 3700;
        
        this.makeAvailableOnAllMaps();
        
        this.setBasicUnique(BUnique.BLOODTHIRSTER);
        
        this.pOptimal = true;
    }
}
