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
public class LiandrysTorment extends Item 
{

    public LiandrysTorment() 
    {
        //Since patch 4.19;
        super();
        this.abilityPower = 50;
        this.hp = 300;
        this.cost = 2900;
        
        this.makeAvailableOnAllMaps();
        
        this.setBasicPassive(BPassive.EYES_OF_PAIN_PASSIVE);
        this.setComplicatedPassive(CPassive.LIANDRYS_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
