/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.charbuild.MapEnum;
import brutelol.items.abstracts.BPassive;
import brutelol.items.abstracts.Item;

/**
 *
 * @author Talonos
 */
public class LichBane extends Item {

    public LichBane() 
    {
        //Since patch 4.19;
        super();
        this.mana = 250;
        this.abilityPower = 80;
        this.moveSpeedPercent = .05;
        this.cost = 3000;
        
        this.makeAvailableOnAllMaps();
        
        this.spellBladeLevel = 4;
        
        this.pOptimal = true;
    }
    
}
