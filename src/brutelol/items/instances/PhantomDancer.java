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
public class PhantomDancer extends Item
{
    public PhantomDancer()
    {
        //Since patch 6.14;
        super();
        this.critChance = .30;
        this.moveSpeedPercent = .05;
        this.attackSpeed = .45;
        
        this.cost = 2550;
        
        this.makeAvailableOnAllMaps();
        
        this.statusEffects.add(StatusEffect.ITEM_SPECTRAL_WALTZ);
        this.statusEffects.add(StatusEffect.ITEM_LAMENT);
        
        this.pOptimal = true;
    }
}
