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
public class HextechGunblade extends Item
{
    public HextechGunblade()
    {
        //Since patch 4.19;
        super();
        this.abilityPower = 65;
        this.attackDamage = 45;
        this.lifesteal = .12;
        this.cost = 3400;
        
        this.makeAvailableOnAllMaps();
        
        this.setBasicPassive(BPassive.HEXTECH_GUNBLADE_PASSIVE);
        this.setComplicatedPassive(CPassive.HEXTECH_GUNBLADE_ACTIVE);
        
        this.pOptimal = true;
    }
}
