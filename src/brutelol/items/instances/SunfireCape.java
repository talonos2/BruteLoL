/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.items.abstracts.BPassive;
import brutelol.items.abstracts.CPassive;
import brutelol.items.abstracts.Item;

/**
 *
 * @author Talonos
 */
class SunfireCape extends Item {

    public SunfireCape()
    {
        //Since patch 4.19;
        super();
        this.hp = 450;
        this.armor = 45;
        this.cost = 2650;
        
        this.makeAvailableOnAllMaps();
        
        this.setComplicatedPassive(CPassive.SUNFIRE_CAPE_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
