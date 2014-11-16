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
public class BootsOfSpeed extends Item
{
    public BootsOfSpeed()
    {
        //Since patch 4.19;
        super();
        this.enhancedMovement = 25;
        this.cost = 325;
        
        this.makeAvailableOnAllMaps();
    }
}
