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
public class EssenceReaver extends Item {

    public EssenceReaver() 
    {
        //Since patch 4.19;
        super();
        this.cooldownReduction = .1;
        this.lifesteal = .1;
        this.cost = 3200;
        
        this.makeAvailableOnAllMaps();
        
        this.setComplicatedPassive(CPassive.ESSENCE_REAVER_PASSIVE);
        
        this.pOptimal = true;
    }
}
