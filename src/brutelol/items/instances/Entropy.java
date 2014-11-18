/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.charbuild.MapEnum;
import brutelol.items.abstracts.BPassive;
import brutelol.items.abstracts.CPassive;
import brutelol.items.abstracts.Item;

/**
 *
 * @author Talonos
 */
class Entropy extends Item {

    public Entropy() 
    {
        //Since patch 4.19;
        super();
        this.hp = 275;
        this.attackDamage = 55;
        this.cost = 2700;
        
        this.availableOnMap(MapEnum.HOWLING_ABYSS);
        this.availableOnMap(MapEnum.CRYSTAL_SCAR);
        
        this.setComplicatedPassive(CPassive.RAGE_PASSIVE);
        this.setComplicatedPassive(CPassive.ENTROPY_ACTIVE);
        
        this.pOptimal = true;
    }
    
}
