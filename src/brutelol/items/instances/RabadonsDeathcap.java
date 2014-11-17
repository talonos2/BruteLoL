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
public class RabadonsDeathcap extends Item
{
    public RabadonsDeathcap()
    {
        //Since patch 4.19;
        super();
        this.abilityPower = 120;
        this.cost = 3300;
        
        this.makeAvailableOnMap(MapEnum.SUMMONERS_RIFT);
        this.makeAvailableOnMap(MapEnum.HOWLING_ABYSS);
        
        this.setBasicPassive(BPassive.DEATHCAP_PASSIVE);
        
        this.pOptimal = true;
    }
}
