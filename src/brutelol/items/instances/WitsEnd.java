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
public class WitsEnd extends Item 
{

    public WitsEnd() 
    {
        //Since patch 4.19;
        super();
        this.attackSpeed = .50;
        this.magicResist = 25;
        this.lifesteal = .12;
        this.cost = 2500;
        
        this.makeAvailableOnAllMaps();
        
        this.setComplicatedPassive(CPassive.WITS_END_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
