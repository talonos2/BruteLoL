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
public class RanduinsOmen extends Item 
{

    public RanduinsOmen() 
    {
        //Since patch 4.19;
        super();
        this.armor = 70;
        this.hp = 500;
        this.cost = 3000;
        
        this.makeAvailableOnAllMaps();
        
        this.setComplicatedPassive(CPassive.RANDUINS_OMEN_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
