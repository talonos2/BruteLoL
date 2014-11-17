/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.items.abstracts.BPassive;
import brutelol.charbuild.MapEnum;
import brutelol.items.abstracts.Item;

/**
 *
 * @author Talonos
 */
public class InfinityEdge extends Item
{
    public InfinityEdge()
    {
        //Since patch 4.19;
        super();
        this.critChance = .25;
        this.attackDamage = 80;
        this.cost = 3800;
        
        this.makeAvailableOnMap(MapEnum.SUMMONERS_RIFT);
        this.makeAvailableOnMap(MapEnum.HOWLING_ABYSS);
        
        this.setBasicPassive(BPassive.INFINITY_EDGE_PASSIVE);
        
        this.pOptimal = true;
    }
}