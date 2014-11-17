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
public class BladeOfTheRuinedKing extends Item {

    public BladeOfTheRuinedKing() 
    {
        //Since patch 4.19;
        super();
        this.attackSpeed = .4;
        this.attackDamage = 25;
        this.lifesteal = .1;
        this.cost = 3200;
        
        this.makeAvailableOnAllMaps();
        
        this.setComplicatedPassive(CPassive.RUINED_KING_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
