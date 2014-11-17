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
public class IcebornGauntlet extends Item 
{

    public IcebornGauntlet() 
    {
        //Since patch 4.19;
        super();
        this.mana = 500;
        this.armor = 60;
        this.abilityPower = 30;
        this.cooldownReduction = .1;
        this.cost = 2900;
        
        this.makeAvailableOnAllMaps();
        
        this.spellBladeLevel = 2;
        
        this.pOptimal = true;
    }
    
}
