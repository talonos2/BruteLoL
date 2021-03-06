/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.items.abstracts;

import brutelol.characters.instances.abilities.StatusEffect;
import brutelol.charbuild.MapEnum;
import brutelol.items.instances.Items;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Talonos
 */
public abstract class Item 
{
    protected String name;
    
    //Item base stats
    protected double attackSpeed = 0;
    protected double attackDamage = 0;
    protected double critChance = 0;
    
    protected double moveSpeedPercent = 0;
    protected double moveSpeedFlat = 0;
    
    protected double abilityPower = 0;
    protected double cooldownReduction = 0;
    
    protected double armor = 0;
    protected double magicResist = 0;
    
    protected double hp = 0;
    protected double healthRegen = 0;
    protected double mana = 0;
    protected double manaRegen = 0;
    
    protected double spellVamp = 0;
    protected double lifesteal = 0;
    
    //Flags to help item related logic
    protected boolean goldItem = false;
    protected boolean pOptimal = false;
    protected boolean isMeleeOnly = false;
    protected boolean isRangedOnly = false;
    protected boolean cannotBuy = false;
    
    //Flags to help shop related logic
    protected int cost = 0;
    protected boolean sellsForLittle = false;
    
    //What are this items prerequisites?
    private final List<Item> prerequisites = new ArrayList<>();
    
    //Where is this available?
    Set<MapEnum> maps;
    
    //What passive flags are on?
    Set<BUnique> basicUniques;
    
    //Some unique effects are too complicated to be simple boolean flags. Those
    //are listed here.
    
    protected double enhancedMovement = 0;
    protected int favorLevel = 0;
    protected int spellBladeLevel = 0;
    public List<StatusEffect> statusEffects = new ArrayList<>();

    public Item() 
    {
        this.maps = EnumSet.noneOf(MapEnum.class);
        this.basicUniques = EnumSet.noneOf(BUnique.class);
    }
    
    public double getAttackSpeed()
    {
        return this.attackSpeed;
    }
    public double getAttackDamage()
    {
        return this.attackDamage;
    }
    
    //APen flat and percent removed, because there are only ever
    //unique sources of it, and those are handled now with flags.
    
    public double getCritChance()
    {
        return this.critChance;
    }
    public double getMoveSpeedPercent()
    {
        return this.moveSpeedPercent;
    }
    public double getMoveSpeedFlat()
    {
        return this.moveSpeedFlat;
    }
    public int getCost() 
    {
        return this.cost;
    }

    public List<Item> getPrerequisites() 
    {
        return this.prerequisites;
    }
    public final int getSalePrice() 
    {
        if (this.sellsForLittle)
        {
            return (int)(this.getCost()*.4);
        }
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

    public boolean isPOptimal() 
    {
        return this.pOptimal;
    }
    
    public double getAbilityPower()
    {
        return this.abilityPower;
    }
    
    public double getSpellvamp()
    {
        return this.spellVamp;
    }
        
    public double getCooldownReduction()
    {
        return this.cooldownReduction;
    }
            
    public double getMana()
    {
        return this.mana;
    }
                
    public double getHP()
    {
        return this.hp;
    }
                    
    public double getArmor()
    {
        return this.armor;
    }
                        
    public double getMagicResist()
    {
        return this.magicResist;
    }
    
    public double getHealthRegen()
    {
        return this.healthRegen;
    }
    
    public double getManaRegen()
    {
        return this.manaRegen;
    }
    
    public double getLifesteal()
    {
        return this.lifesteal;
    }
    
    public double getEnhancedMovement()
    {
        return this.enhancedMovement;
    }
    
    //MPen flat and percent removed for the same reason as armor,
    //above.
    
    public boolean isGoldItem()
    {
        return this.goldItem;
    }
        
    public boolean availableOnMap(MapEnum map)
    {
        return this.maps.contains(map);
    }
    
    public int compareTo(Item o2) 
    {
        return Items.getItemID(this).compareTo(Items.getItemID(o2));
    }
    
    public int getFavorLevel()
    {
        return this.favorLevel;
    }
    
    public boolean isMeleeOnly()
    {
        return this.isMeleeOnly;
    }
    
        public boolean isRangedOnly()
    {
        return this.isRangedOnly;
    }
    
    protected void makeAvailableOnAllMaps()
    {
        this.maps.add(MapEnum.SUMMONERS_RIFT);
        this.maps.add(MapEnum.TWISTED_TREELINE);
        this.maps.add(MapEnum.HOWLING_ABYSS);
    }
    
    protected void makeAvailableOnMap(MapEnum mapEnum) 
    {
        this.maps.add(mapEnum);
    }
    
    protected void setBasicUnique(BUnique unique) 
    {
        this.basicUniques.add(unique);
    }
    
    public Collection<BUnique> getAllBasicUniques()
    {
        return Collections.unmodifiableSet(basicUniques);
    }

    public Object getName() 
    {
        if (this.name == null)
        {
            String fullName = this.getClass().getName();
            name = fullName.substring(fullName.lastIndexOf(".")+1);
        }
        return name;
    }

    public List<StatusEffect> getAllStatusEffects() 
    {
        return statusEffects;
    }
}
