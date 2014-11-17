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
public class ArchangelsStaff extends Item 
{

    public ArchangelsStaff() 
    {
        //Since patch 4.19;
        super();
        this.abilityPower = 60;
        this.manaRegen = 10;
        this.mana = 1000;
        this.cost = 2700;
        
        this.makeAvailableOnAllMaps();
        
        this.setBasicPassive(BPassive.INSIGHT_PASSIVE);
        this.setComplicatedPassive(CPassive.MANA_CHARGE_STAFF_GROWTH);
    }
    
}
