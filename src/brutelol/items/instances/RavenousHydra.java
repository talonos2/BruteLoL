/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.charbuild.MapEnum;
import brutelol.items.abstracts.BPassive;
import brutelol.items.abstracts.CPassive;
import brutelol.items.abstracts.Item;

/**
 *
 * @author Talonos
 */
public class RavenousHydra extends Item
{
    public RavenousHydra()
    {
        //Since patch 4.19;
        super();
        this.attackDamage = 75;
        this.healthRegen = 15;
        this.lifesteal = .12;
        this.cost = 3300;
        
        this.isMeleeOnly = true;
        
        this.makeAvailableOnAllMaps();
        
        this.setComplicatedPassive(CPassive.HYDRA_PASSIVE);
        
        this.pOptimal = true;
    }
}