/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.charbuild.MapEnum;
import brutelol.items.abstracts.CPassive;
import brutelol.items.abstracts.Item;

/**
 *
 * @author Talonos
 */
public class MawOfMalmortius extends Item {

    public MawOfMalmortius() 
    {
        //Since patch 4.19;
        super();
        this.magicResist = 40;
        this.attackDamage = 60;
        this.cost = 3200;
        
        this.makeAvailableOnAllMaps();
        
        this.setComplicatedPassive(CPassive.MALMORTIUS_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
