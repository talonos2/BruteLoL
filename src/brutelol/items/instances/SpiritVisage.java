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
public class SpiritVisage extends Item 
{

    public SpiritVisage() 
    {
        //Since patch 4.19;
        super();
        this.hp = 400;
        this.magicResist = 55;
        this.healthRegen = 20;
        this.cooldownReduction = .1;
        this.cost = 2750;
        
        this.makeAvailableOnAllMaps();
        
        this.setBasicPassive(BPassive.SPIRIT_VISAGE_PASSIVE);
        this.setComplicatedPassive(CPassive.SPIRIT_VISAGE_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
