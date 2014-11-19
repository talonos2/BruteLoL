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
public class FeralFlare extends Item 
{

    public FeralFlare() 
    {
        //Since patch 4.19;
        super();
        this.attackSpeed = .3;
        this.attackDamage = 12;
        this.cost = 1800;
        
        this.sellsForLittle = true;
        this.goldItem = true;
        
        this.makeAvailableOnAllMaps();
        
        this.setComplicatedPassive(CPassive.FERAL_FLARE_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
