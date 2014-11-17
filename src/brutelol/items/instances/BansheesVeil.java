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
public class BansheesVeil extends Item 
{

    public BansheesVeil() 
    {
        //Since patch 4.19;
        super();
        this.hp = 450;
        this.magicResist = 55;
        this.cost = 2750;
        
        this.makeAvailableOnMap(MapEnum.SUMMONERS_RIFT);
        this.makeAvailableOnMap(MapEnum.TWISTED_TREELINE);
        this.makeAvailableOnMap(MapEnum.HOWLING_ABYSS);
        
        this.setComplicatedPassive(CPassive.BANSHEES_VEIL_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
