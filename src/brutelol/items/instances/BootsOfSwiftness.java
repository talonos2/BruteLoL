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
public class BootsOfSwiftness extends Item 
{

    public BootsOfSwiftness() 
    {
        //Since patch 4.19;
        super();
        this.enhancedMovement = 60;
        this.cost = 1000;
        
        this.makeAvailableOnAllMaps();
        
        this.pOptimal = true;
    }
    
}
