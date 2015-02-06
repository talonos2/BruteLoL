/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol;

import brutelol.characters.instances.Ashe;
import brutelol.items.instances.StatikkShiv;
import brutelol.items.instances.Thornmail;
import brutelol.items.instances.NinjaTabi;
import brutelol.characters.instances.Udyr;
import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.characters.lib.AshesToAshesMasteries;
import brutelol.characters.lib.Masteries;
import brutelol.charbuild.Build;
import brutelol.charbuild.ItemSet;
import brutelol.charbuild.runes.RunePage;
import brutelol.items.abstracts.Item;
import brutelol.items.instances.BansheesVeil;
import brutelol.items.instances.BerserkersGreaves;
import brutelol.items.instances.Bloodthirster;
import brutelol.items.instances.InfinityEdge;
import brutelol.items.instances.Items;
import brutelol.items.instances.LastWhisper;
import brutelol.items.instances.RanduinsOmen;
import brutelol.items.instances.WarmogsArmor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class BuildEvaluater 
{
    public static void main(String[] args)
    {
        Items.getAllItems();

        Build enemyTank = getEnemyTank();
        
        List<Item> myItemList = new ArrayList<>();
        {
            myItemList.add(new InfinityEdge());
            myItemList.add(new StatikkShiv());
            myItemList.add(new BerserkersGreaves());
            myItemList.add(new Bloodthirster());
            myItemList.add(new LastWhisper());
            myItemList.add(new BansheesVeil());
        }
        AbstractLolCharacter me = new Ashe();
        
        Build toTest = new Build(new ItemSet(myItemList), me, 10000, 10000, 10000, new RunePage(), new AshesToAshesMasteries());
        
        List<Build> foes = new ArrayList<>();
        
        toTest.getBBCode(foes, 1, "JhoiJhoi's Ashes to Ashes");
}

    private static Build getEnemyTank() 
    {
        List<Item> tankItemList = new ArrayList<>();
        {
            tankItemList.add(new RanduinsOmen());
            tankItemList.add(new WarmogsArmor());
            tankItemList.add(new Thornmail());
            tankItemList.add(new NinjaTabi());
        }
        AbstractLolCharacter tank = new Udyr();
        return new Build(new ItemSet(tankItemList), tank, 10000, 10000, 10000, new RunePage(), new AshesToAshesMasteries());
    }
}
    
