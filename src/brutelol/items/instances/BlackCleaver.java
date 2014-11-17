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
public class BlackCleaver extends Item {

    public BlackCleaver() 
    {
        //Since patch 4.19;
        super();
        this.attackDamage = 50;
        this.cooldownReduction = .1;
        this.hp = 200;
        this.cost = 3000;
        
        this.makeAvailableOnAllMaps();
        
        this.setBasicPassive(BPassive.BLACK_CLEAVER_PASSIVE);
        this.setComplicatedPassive(CPassive.BLACK_CLEAVER_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
