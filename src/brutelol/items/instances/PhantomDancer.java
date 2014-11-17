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
public class PhantomDancer extends Item 
{

    public PhantomDancer() 
    {
        //Since patch 4.19;
        super();
        this.attackSpeed = .5;
        this.critChance = .3;
        this.moveSpeedPercent = .05;
        this.cost = 2800;
        
        this.makeAvailableOnAllMaps();
        
        this.setComplicatedPassive(CPassive.PHANTOM_DANCER_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
