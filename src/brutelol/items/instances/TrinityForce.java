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
public class TrinityForce extends Item
{
    public TrinityForce()
    {
        //Since patch 4.19;
        super();
        this.attackDamage = 30;
        this.abilityPower = 30;
        this.attackSpeed = .3;
        this.critChance = .1;
        this.moveSpeedPercent = .08;
        this.hp = 250;
        this.mana = 200;
        this.cost = 3703;
        
        this.makeAvailableOnAllMaps();
        
        this.setComplicatedPassive(CPassive.RAGE_PASSIVE);
        this.spellBladeLevel = 3;
        
        this.pOptimal = true;
    }
}
