/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.charbuild.MapEnum;
import brutelol.items.abstracts.CPassive;
import brutelol.items.abstracts.Item;

/**
 *
 * @author Talonos
 */
public class DervishBlade extends Item 
{

    public DervishBlade() 
    {
        //Since patch 4.19;
        super();
        this.attackSpeed = .5;
        this.magicResist = 45;
        this.cooldownReduction = .1;
        this.cost = 3000;
        
        this.makeAvailableOnMap(MapEnum.TWISTED_TREELINE);
        this.makeAvailableOnMap(MapEnum.CRYSTAL_SCAR);
        
        this.setComplicatedPassive(CPassive.QUICKSILVER_ACTIVE);
        
        this.pOptimal = true;
    }
    
}
