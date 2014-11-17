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
public class NashorsTooth extends Item 
{

    public NashorsTooth() 
    {
        //Since patch 4.19;
        super();
        this.abilityPower = 60;
        this.attackSpeed = .5;
        this.cost = 2920;
        
        this.makeAvailableOnAllMaps();
        
        this.setBasicPassive(BPassive.NASHOR_PASSIVE);
        this.setComplicatedPassive(CPassive.NASHOR_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
