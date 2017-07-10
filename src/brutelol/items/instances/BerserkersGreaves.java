/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.instances;

import brutelol.items.abstracts.BUnique;
import brutelol.items.abstracts.CUnique;
import brutelol.items.abstracts.Item;

/**
 *
 * @author Talonos
 */
public class BerserkersGreaves extends Item
{
    public BerserkersGreaves()
    {
        //Since patch 7.13;
        super();
        
        this.cost = 1100;
        this.attackSpeed = .35;
        
        this.makeAvailableOnAllMaps();
        this.pOptimal = true;
    }
}
