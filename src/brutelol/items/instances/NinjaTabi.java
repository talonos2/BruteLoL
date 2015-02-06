/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.items.abstracts.CPassive;
import brutelol.items.abstracts.Item;

/**
 *
 * @author Talonos
 */
public class NinjaTabi extends Item {

    public NinjaTabi() 
    {
        //Since patch 4.20;
        super();
        this.enhancedMovement = 45;
        this.cost = 1000;
        this.armor = 25;
        
        this.makeAvailableOnAllMaps();
        
        this.setComplicatedPassive(CPassive.TABI_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
