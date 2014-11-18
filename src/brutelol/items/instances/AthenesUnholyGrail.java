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
class AthenesUnholyGrail extends Item {

    public AthenesUnholyGrail() 
    {
        //Since patch 4.19;
        super();
        this.abilityPower = 60;
        this.magicResist = 25;
        this.manaRegen = 10;
        this.cooldownReduction = .20;
        this.cost = 2600;
        
        this.makeAvailableOnAllMaps();
        
        this.setBasicPassive(BPassive.MANA_FONT_PASSIVE);
        this.setComplicatedPassive(CPassive.ATHENES_UNHOLY_GRAIL_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
