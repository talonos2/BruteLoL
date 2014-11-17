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
public class ZhonyasHourglass extends Item {

    public ZhonyasHourglass() 
    {
        //Since patch 4.19;
        super();
        this.armor = 50;
        this.abilityPower = 120;
        this.cost = 3260;
        
        this.makeAvailableOnMap(MapEnum.SUMMONERS_RIFT);
        this.makeAvailableOnMap(MapEnum.HOWLING_ABYSS);
        
        this.setComplicatedPassive(CPassive.STATIS_ACTIVE);
        
        this.pOptimal = true;
    }
    
}
