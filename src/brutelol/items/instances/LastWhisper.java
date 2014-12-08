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
public class LastWhisper extends Item 
{

    public LastWhisper() 
    {
        //Since patch 4.20;
        super();
        this.attackDamage = 40;
        this.cost = 2300;
        
        this.makeAvailableOnAllMaps();
        
        this.setBasicPassive(BPassive.LAST_WHISPER_PASIVE);
        
        this.pOptimal = true;
    }
    
}
