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
class RunaansHurricane extends Item {

    public RunaansHurricane() {
        //Since patch 4.20;
        super();
        this.attackSpeed = .70;
        this.cost = 2400;
        
        this.makeAvailableOnAllMaps();
        
        this.setComplicatedPassive(CPassive.RUUNANS_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
