/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.items.abstracts.BPassive;
import brutelol.buildobjs.MapEnum;
import brutelol.items.abstracts.Item;

/**
 *
 * @author Talonos
 */
public class LordVanDammsPillager extends Item
{
    public LordVanDammsPillager()
    {
        //Since patch 4.19;
        super();
        this.critChance = .25;
        this.attackDamage = 80;
        
        this.makeAvailableOnMap(MapEnum.CRYSTAL_SCAR);
        this.makeAvailableOnMap(MapEnum.TWISTED_TREELINE);
        
        this.setBasicPassive(BPassive.INFINITY_EDGE_PASSIVE);
    }
}
