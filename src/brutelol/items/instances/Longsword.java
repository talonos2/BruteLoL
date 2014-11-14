/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.items.abstracts.Item;

/**
 *
 * @author Talonos
 */
public class LongSword extends Item
{
    public LongSword()
    {
        //Since patch 4.19;
        super();
        this.attackDamage = 10;
        this.cost = 360;
        
        this.summonersRift = true;
        this.twistedTreeline = true;
        this.howlingAbyss = true;
        this.crystalScar = true;
    }
}
