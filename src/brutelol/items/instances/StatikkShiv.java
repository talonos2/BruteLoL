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
public class StatikkShiv extends Item {

    public StatikkShiv() 
    {
        //Since patch 4.20;
        super();
        this.attackSpeed = .4;
        this.critChance = .2;
        this.moveSpeedPercent = .06;
        this.cost = 2500;
        
        this.makeAvailableOnAllMaps();
        
        this.setComplicatedPassive(CPassive.BANSHEES_VEIL_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
