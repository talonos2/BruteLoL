/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.items.abstracts.BPassive;
import brutelol.items.abstracts.CPassive;
import brutelol.items.abstracts.Item;

/**
 *
 * @author Talonos
 */
public class LocketOfTheIronSolari extends Item 
{

    public LocketOfTheIronSolari() 
    {
        //Since patch 4.19;
        super();
        this.hp = 400;
        this.magicResist = 20;
        this.cooldownReduction = .10;
        this.cost = 2800;
        
        this.makeAvailableOnAllMaps();
        
        this.setBasicPassive(BPassive.LOCKET_PASSIVE);
        this.setComplicatedPassive(CPassive.LOCKET_ACTIVE);
        
        this.pOptimal = true;
    }
    
}
