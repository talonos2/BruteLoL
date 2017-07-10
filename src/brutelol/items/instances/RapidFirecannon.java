/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.characters.instances.abilities.StatusEffect;
import brutelol.items.abstracts.BUnique;
import brutelol.items.abstracts.CUnique;
import brutelol.items.abstracts.Item;

/**
 *
 * @author Talonos
 */
public class RapidFirecannon extends Item
{
    public RapidFirecannon()
    {
        //Since patch 7.13;
        super();
        this.attackSpeed = .30;
        this.critChance = .30;
        this.moveSpeedPercent = .05;
        
        this.cost = 2600;
        
        this.makeAvailableOnAllMaps();
        
        this.statusEffects.add(StatusEffect.ITEM_FIRECANNON);
        
        this.pOptimal = true;
    }
}
