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
public class LordDominiksRegards extends Item
{
    public LordDominiksRegards()
    {
        //Since patch 6.14;
        super();
        this.attackDamage = 50;
        
        this.cost = 2600;
        
        this.makeAvailableOnAllMaps();
        
        this.statusEffects.add(StatusEffect.ITEM_BIG_GIANT_SLAYER);
        this.setBasicUnique(BUnique.LAST_WHISPER);
        
        this.pOptimal = true;
    }
}
