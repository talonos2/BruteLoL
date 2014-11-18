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
class BlackfireTorch extends Item {

    public BlackfireTorch() 
    {
        //Since patch 4.19;
        super();
        this.abilityPower = 80;
        this.cooldownReduction = .10;
        this.cost = 2650;
        
        this.makeAvailableOnMap(MapEnum.TWISTED_TREELINE);
        this.makeAvailableOnMap(MapEnum.CRYSTAL_SCAR);
        
        this.setComplicatedPassive(CPassive.BLACKFIRE_TORCH_ACTIVE);
        
        this.pOptimal = true;
    }
    
}
