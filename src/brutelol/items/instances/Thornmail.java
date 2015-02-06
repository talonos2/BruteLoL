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
public class Thornmail extends Item {

    public Thornmail() 
    {
        //Since patch 4.20;
        super();
        this.cost = 2100;
        this.armor = 100;
        
        this.makeAvailableOnAllMaps();
        
        this.setComplicatedPassive(CPassive.THORNMAIL_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
