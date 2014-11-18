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
class MoonflairSpellblade extends Item {

    public MoonflairSpellblade() 
    {
        //Since patch 4.19;
        super();
        this.abilityPower = 50;
        this.armor = 50;
        this.magicResist = 50;
        this.cost = 2600;
        
        this.makeAvailableOnMap(MapEnum.TWISTED_TREELINE);
        this.makeAvailableOnMap(MapEnum.CRYSTAL_SCAR);
        
        this.setComplicatedPassive(CPassive.TENACITY_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
