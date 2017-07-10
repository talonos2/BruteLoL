/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.characters.instances.abilities.StatusEffect;
import brutelol.items.abstracts.CUnique;
import brutelol.items.abstracts.Item;

/**
 *
 * @author Talonos
 */
public class MercurialScimitar extends Item
{
    public MercurialScimitar()
    {
        //Since patch 6.14;
        super();
        this.attackDamage = 65;
        this.magicResist = 35;
        this.lifesteal = .1;
        
        this.cost = 3600;
        
        this.makeAvailableOnAllMaps();
        
        this.statusEffects.add(StatusEffect.ITEM_QUICKSILVER);
        
        this.pOptimal = true;
    }
}
