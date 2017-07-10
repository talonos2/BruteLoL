/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.items.abstracts.BUnique;
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
        //Since patch 7.13;
        super();
        this.critChance = .20;
        this.attackDamage = 70;
        this.cost = 3600;
        
        this.makeAvailableOnAllMaps();
        
        this.setBasicUnique(BUnique.INFINITY_EDGE);
        
        this.pOptimal = true;
    }
}
