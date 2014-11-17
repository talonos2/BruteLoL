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
public class MercurialScimitar extends Item
{
    public MercurialScimitar()
    {
        //Since patch 4.19;
        super();
        this.magicResist = 45;
        this.attackDamage = 80;
        this.cost = 3800;
        
        this.makeAvailableOnMap(MapEnum.CRYSTAL_SCAR);
        this.makeAvailableOnMap(MapEnum.TWISTED_TREELINE);
        
        this.setComplicatedPassive(CPassive.MERCURIAL_SCIMITAR_ACTIVE);
        
        this.pOptimal = true;
    }
}
