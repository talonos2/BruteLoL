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
public class RodOfAges extends Item 
{

    public RodOfAges() 
    {
        //Since patch 4.19;
        super();
        this.abilityPower = 80;
        this.hp = 650;
        this.mana = 650;
        this.cost = 2800;
        
        this.makeAvailableOnAllMaps();
        
        this.setComplicatedPassive(CPassive.VALORS_REWARD_PASSIVE);
        this.setComplicatedPassive(CPassive.ROD_OF_AGES_GROWTH);
        
        this.pOptimal = true;
    }
    
}
