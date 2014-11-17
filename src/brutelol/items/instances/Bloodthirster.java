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
public class Bloodthirster extends Item
{
    public Bloodthirster()
    {
        //Since patch 4.19;
        super();
        this.attackDamage = 80;
        this.cost = 3500;
        
        this.makeAvailableOnMap(MapEnum.SUMMONERS_RIFT);
        
        this.setBasicPassive(BPassive.BLOODTHIRSTER_PASSIVE);
        this.setComplicatedPassive(CPassive.BLOODTHIRSTER_PASSIVE);
        
        this.pOptimal = true;
    }
}
