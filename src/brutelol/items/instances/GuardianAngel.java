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
public class GuardianAngel extends Item 
{

    public GuardianAngel() 
    {
        //Since patch 4.19;
        super();
        this.armor = 50;
        this.magicResist = 40;
        this.cost = 2750;
        
        this.makeAvailableOnMap(MapEnum.SUMMONERS_RIFT);
        this.makeAvailableOnMap(MapEnum.CRYSTAL_SCAR);
        
        this.setComplicatedPassive(CPassive.GUARDIAN_ANGEL_PASSIVE);
        
        this.pOptimal = true;
    }
    
}
