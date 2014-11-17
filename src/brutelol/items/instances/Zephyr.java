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
public class Zephyr extends Item 
{

    public Zephyr() 
    {
        //Since patch 4.19;
        super();
        this.attackSpeed = .5;
        this.attackDamage = 25;
        this.moveSpeedFlat = .1;
        this.cooldownReduction = .1;
        this.cost = 2850;
        
        this.makeAvailableOnAllMaps();
        
        this.setComplicatedPassive(CPassive.TENACITY_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
