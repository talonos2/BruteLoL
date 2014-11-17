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
public class WoogletsWitchcap extends Item {

    public WoogletsWitchcap() 
    {
        super();
        this.abilityPower = 100;
        this.armor = 45;
        this.cost = 3500;
        
        this.setBasicPassive(BPassive.WOOGLETS_PASSIVE);
        this.setComplicatedPassive(CPassive.STATIS_ACTIVE);
        
        this.makeAvailableOnMap(MapEnum.TWISTED_TREELINE);
        this.makeAvailableOnMap(MapEnum.CRYSTAL_SCAR);
        
        this.pOptimal = true;
    }
    
}
