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
class FrozenHeart extends Item {

    public FrozenHeart() 
    {
        //Since patch 4.19;
        super();
        this.armor = 100;
        this.mana = 400;
        this.cooldownReduction = .20;
        this.cost = 2600;
        
        this.makeAvailableOnAllMaps();
        
        this.setComplicatedPassive(CPassive.FROZEN_HEART_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
