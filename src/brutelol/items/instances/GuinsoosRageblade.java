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
class GuinsoosRageblade extends Item {

    public GuinsoosRageblade()
    {
        //Since patch 4.19;
        super();
        this.abilityPower = 40;
        this.attackDamage = 30;
        this.cost = 2600;
        
        this.makeAvailableOnAllMaps();
        
        this.setComplicatedPassive(CPassive.GUINSOOS_RAGEBLADE_PASSIVE);
        this.setComplicatedPassive(CPassive.GUINSOOS_RAGEBLADE_UNIQUE_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
