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
public class YoumuusGhostblade extends Item 
{
    public static final double PERCENT_TIME_ON = .3333;

    public YoumuusGhostblade() 
    {
        //Since patch 4.19;
        super();
        this.attackDamage = 30;
        this.critChance = .15;
        this.cooldownReduction = .10;
        this.cost = 2700;
        
        this.makeAvailableOnAllMaps();
        
        this.setBasicPassive(BPassive.YOUMUUS_GHOSTBLADE_PASSIVE);
        this.setComplicatedPassive(CPassive.YOUMUUS_GHOSTBLADE_ACTIVE);
        
        this.pOptimal = true;
    }
    
}
