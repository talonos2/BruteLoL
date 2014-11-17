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
public class DeathfireGrasp extends Item {

    public DeathfireGrasp() 
    {
        //Since patch 4.19;
        super();
        this.abilityPower = 120;
        this.cooldownReduction = .1;
        this.cost = 3100;
        
        this.makeAvailableOnMap(MapEnum.SUMMONERS_RIFT);
        this.makeAvailableOnMap(MapEnum.HOWLING_ABYSS);
        
        this.setComplicatedPassive(CPassive.DEATHFIRE_ACTIVE);
        
        this.pOptimal = true;
    }
    
}
