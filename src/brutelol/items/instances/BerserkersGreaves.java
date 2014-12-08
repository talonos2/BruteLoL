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
public class BerserkersGreaves extends BootsOfSwiftness 
{

    public BerserkersGreaves() 
    {
        //Since patch 4.20;
        super();
        this.enhancedMovement = 45;
        this.attackSpeed = .25;
        this.cost = 1000;
        
        this.makeAvailableOnAllMaps();
        
        this.pOptimal = true;
    }
    
}
