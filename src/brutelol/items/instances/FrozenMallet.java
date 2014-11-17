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
public class FrozenMallet extends Item {

    public FrozenMallet() 
    {
        //Since patch 4.19;
        super();
        this.attackDamage = 30;
        this.hp = 700;
        this.cost = 3300;
        
        this.makeAvailableOnAllMaps();
        
        this.setComplicatedPassive(CPassive.FROZEN_MALLET_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
