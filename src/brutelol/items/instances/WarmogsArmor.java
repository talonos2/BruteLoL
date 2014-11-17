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
public class WarmogsArmor extends Item 
{

    public WarmogsArmor() 
    {
        //Since patch 4.19;
        super();
        this.hp = 1000;
        this.cost = 2830;
        
        this.makeAvailableOnMap(MapEnum.SUMMONERS_RIFT);
        
        this.setBasicPassive(BPassive.WARMOGS_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
