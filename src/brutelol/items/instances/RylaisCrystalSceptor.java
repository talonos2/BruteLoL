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
public class RylaisCrystalSceptor extends Item 
{

    public RylaisCrystalSceptor() 
    {
        //Since patch 4.19;
        super();
        this.abilityPower = 100;
        this.hp = 400;
        this.cost = 2900;
        
        this.makeAvailableOnAllMaps();
        
        this.setComplicatedPassive(CPassive.RYLAIS_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
