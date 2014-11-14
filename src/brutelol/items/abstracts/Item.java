/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.abstracts;

import brutelol.items.instances.Items;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public abstract class Item 
{
    public double getGoldPer10Boost()
    {
        return 0;
    }
    public double getGoldPerKillBoost()
    {
        return 0;
    }
    public double getAttackSpeed()
    {
        return 0;
    }
    public double getAttackDamage()
    {
        return 0;
    }
    public double getArmorPenetrationFlat()
    {
        return 0;
    }
    public double getArmorPenetrationPercent()
    {
        return 0;
    }
    public double getCritChance()
    {
        return 0;
    }
    public double getMoveSpeedPercent()
    {
        return 0;
    }
    public double getMoveSpeedFlat()
    {
        return 0;
    }
    public boolean enhancedCrit()
    {
        return false;
    }
    public boolean shivEffect()
    {
        return false;
    }

    public int getCost() 
    {
        return 0;
    }

    public List<Item> getPrerequisites() 
    {
        return new ArrayList<>();
    }

    public int getSalePrice() 
    {
        return (int)(this.getCost()*.7);
    }

    @Override
    public boolean equals(Object obj) 
    {
        return (this.getClass() == obj.getClass());
    }

    @Override
    public int hashCode() 
    {
        return this.getCost();
    }
    
    @Override
    public String toString()
    {
        return this.getClass().getSimpleName();
    }

    public boolean isBoots() 
    {
        return false;
    }
    
    public boolean lastWhisperEffect()
    {
        return false;
    }
    
    public double getLifeSteal()
    {
        return 0;
    }

    public boolean isPOptimal() 
    {
        return false;
    }
    
    public double getAbilityPower()
    {
        return 0;
    }
    
    public double getSpellvamp()
    {
        return 0;
    }
        
    public double getCooldownReduction()
    {
        return 0;
    }
            
    public double getMana()
    {
        return 0;
    }
                
    public double getHP()
    {
        return 0;
    }
                    
    public double getArmor()
    {
        return 0;
    }
                        
    public double getMagicResist()
    {
        return 0;
    }
    
    public double getTenacity()
    {
        return 0;
    }
    
    public double getHealthRegen()
    {
        return 0;
    }
    
    public double getManaRegen()
    {
        return 0;
    }
    
    public double getMagicPenetrationFlat()
    {
        return 0;
    }
    
    public double getMagicPenetrationPercent()
    {
        return 0;
    }
    
    public boolean getScepterEffect()
    {
        return false;
    }
    
    public boolean getLegionEffect()
    {
        return false;
    }
    
    public double getManaChargeEffect()
    {
        return 0;
    }
    
    public double getFavorEffect()
    {
        return 0;
    }
    
    public boolean isGoldItem()
    {
        return false;
    }
    
    public boolean getManaFontEffect()
    {
        return false;
    }
    
    public boolean getImpalerEffect()
    {
        return false;
    }
    
    public boolean availableOnSummonersRift()
    {
        return true;
    }
    
    public boolean availableOnTwistedTreeline() 
    {
        return true;
    }
    
    public boolean availableOnCrystalScar() 
    {
        return true;
    }
    
    public boolean availableOnHowlingAbyss() 
    {
        return true;
    }
    
    public boolean getInsightEffect()
    {
        return false;
    }
    
    public boolean getIdolEffect() 
    {
        return false;
    }  
    
    public int getTributeLevel() 
    {
        return 0;
    }  
    
    public boolean getDeathcapEffect()
    {
        return false;
    }
    
    public boolean getNashorsEffect()
    {
        return false;
    }

    public int getSpellbladeLevel() 
    {
        return 0;
    }
    
    public boolean getAweEffect()
    {
        return false;
    }
    
    public boolean getGhostbladeEffect()
    {
        return false;
    }

    public boolean getBlackCleaverEffect() 
    {
        return false;
    }

    public boolean hurricaneEffect() 
    {
        return false;
    }

    public boolean ruinedKingEffect() 
    {
        return false;
    }

    public boolean deathfireGraspEffect() 
    {
        return false;
    }
    
    public boolean bloodthirsterEffect()
    {
        return false;
    }
    
    public boolean reaverEffect()
    {
        return false;
    }
    
    public boolean bilgewaterEffect() 
    {
        return false;
    }

    public int compareTo(Item o2) 
    {
        return Items.getItemID(this).compareTo(Items.getItemID(o2));
    }
    
    public boolean ragebladeEffect()
    {
        return false;
    }
    
    public boolean guiseEffect()
    {
        return false;
    }
    
    public boolean gunbladeEffect()
    {
        return false;
    }
    
    public boolean revolverEffect()
    {
        return false;
    }
    
    public boolean sweeperEffect()
    {
        return false;
    }
    
    public int maimLevel()
    {
        return 0;
    }
    
    public boolean ionianEffect()
    {
        return false;
    }
    
    public boolean kindleEffect()
    {
        return false;
    }
    
    public boolean bloodrazorEffect()
    {
        return false;
    }
    
    public boolean machetteEffect() 
    {
        return false;
    }
    
    public boolean solariEffect() 
    {
        return false;
    }
        
    public boolean tormentEffect() 
    {
        return false;
    }
}
