/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.items.abstracts.Item;

/**
 *
 * @author Talonos
 */
public class AncientCoin extends Item
{
    public AncientCoin()
    {
        //Since patch 4.19;
        super();
        this.manaRegen = 3;
        this.cost = 365;
        
        this.goldItem = true;
        this.sellsForLittle = true;
                
        this.favorLevel = 1;
        
        this.makeAvailableOnAllMaps();
    }
}
