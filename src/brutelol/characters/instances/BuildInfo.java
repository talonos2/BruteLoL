/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.instances;

import brutelol.Masteries;
import brutelol.buildobjs.ItemSet;
import brutelol.buildobjs.RunePage;
import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.items.abstracts.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class BuildInfo 
{
    private ItemSet items = null;
    private AbstractLolCharacter c = null;
    private RunePage runes = null;
    private Masteries masteries = null;
    private int level = 0;
    
    public BuildInfo(AbstractLolCharacter c, ItemSet items, RunePage runes, Masteries masteries)
    {
        this.items = items;
        this.c=c;
        this.runes=runes;
        this.masteries=masteries;
        level = c.getLevel();
        
        for (Item i : items.itemsInList)
        {   
            //cost
            cost += i.getCost();
            
            //attack
            attackDamage += i.getAttackDamage();
            critChance += i.getCritChance();
            attackSpeed+=i.getAttackSpeed();
            lifeSteal += i.getLifeSteal();
            
            //Magic
            abilityPower += i.getAbilityPower();
            spellvamp += i.getSpellvamp();
            cooldownReduction += i.getCooldownReduction();
            mana += i.getMana();
            
            //defense
            hp+=i.getHP();
            armor+=i.getArmor();
            magicResist+=i.getMagicResist();
            
            //Regen and Speed
            moveSpeed += i.getMoveSpeedFlat();
            moveSpeedPercent += i.getMoveSpeedPercent();
            healthRegen+=i.getHealthRegen();
            manaRegen += i.getManaRegen();
            tenacity += i.getTenacity();
            
            //penetration
            armorPenetrationFlat += i.getArmorPenetrationFlat();
            armorPenetrationPercent += i.getArmorPenetrationPercent();
            magicPenetrationFlat += i.getMagicPenetrationFlat();
            magicPenetrationPercent += i.getMagicPenetrationPercent();
        }
            
        //attack
        attackDamage += c.getAttackDamage();
        attackSpeed+=c.getAttackSpeed();
            
        //Magic
        mana += c.getMaxMana();
            
        //defense
        hp+=c.getMaxHP();
        armor+=c.getArmor();
        magicResist+=c.getMagicResist();
        
        //Regen and Speed
        moveSpeed += c.getMoveSpeed();
        healthRegen+=c.getHealthRegen();
        manaRegen += c.getManaRegen();
    }

    public StringBuilder showWork() 
    {   
        StringBuilder mathNotes = new StringBuilder();
        mathNotes.append("From items we get the following:\n");
        
        List<StringBuilder> attributes = new ArrayList<>();
        
        StringBuilder costString = new StringBuilder("  Cost: "); attributes.add(costString);
        costString.append("0");
        StringBuilder attackDamageString = new StringBuilder("  Attack Damage: "); attributes.add(attackDamageString);
        attackDamageString.append(c.getAttackDamage());
        StringBuilder critChanceString = new StringBuilder("  Crit Chance: "); attributes.add(critChanceString);
        critChanceString.append("0");
        StringBuilder attackSpeedString = new StringBuilder("  Attack Speed: "); attributes.add(attackSpeedString);
        attackSpeedString.append(c.getAttackSpeed());
        StringBuilder lifeStealString = new StringBuilder("  Lifesteal: "); attributes.add(lifeStealString);
        lifeStealString.append("0");
        StringBuilder abilityPowerString = new StringBuilder("  Ability Power: "); attributes.add(abilityPowerString);
        abilityPowerString.append("0");
        StringBuilder spellvampString = new StringBuilder("  Spellvamp: "); attributes.add(spellvampString);
        spellvampString.append("0");
        StringBuilder cooldownReductionString = new StringBuilder("  Cooldown Reduction: "); attributes.add(cooldownReductionString);
        cooldownReductionString.append("0");
        StringBuilder manaString = new StringBuilder("  Mana: 0"); attributes.add(manaString);
        manaString.append(c.getMaxMana());
        StringBuilder hpString = new StringBuilder("  HP: "); attributes.add(hpString); 
        hpString.append(c.getMaxHP());
        StringBuilder armorString = new StringBuilder("  Armor: "); attributes.add(armorString);
        armorString.append(c.getArmor());
        StringBuilder magicResistString = new StringBuilder("  Magic Resistance: "); attributes.add(magicResistString);
        magicResistString.append(c.getMagicResist());
        StringBuilder moveSpeedString = new StringBuilder("  Flat Move Speed: "); attributes.add(moveSpeedString);
        moveSpeedString.append(c.getMoveSpeed());
        StringBuilder moveSpeedPercentString = new StringBuilder("  Percent move speed: "); attributes.add(moveSpeedPercentString);
        moveSpeedPercentString.append("0");
        StringBuilder healthRegenString = new StringBuilder("  Health regeneration: "); attributes.add(healthRegenString);
        healthRegenString.append(c.getHealthRegen());
        StringBuilder manaRegenString = new StringBuilder("  Mana Regeneration: "); attributes.add(manaRegenString);
        manaRegenString.append(c.getManaRegen());
        StringBuilder tenacityString = new StringBuilder("  Tenacity: "); attributes.add(tenacityString);
        tenacityString.append("0");
        StringBuilder armorPenetrationFlatString = new StringBuilder("  Flat Armor Penetration: "); attributes.add(armorPenetrationFlatString);
        armorPenetrationFlatString.append("0");
        StringBuilder armorPenetrationPercentString = new StringBuilder("  Percent Armor Penetration: "); attributes.add(armorPenetrationPercentString);
        armorPenetrationPercentString.append("0");
        StringBuilder magicPenetrationFlatString = new StringBuilder("  Flat Magic Penetration: "); attributes.add(magicPenetrationFlatString);
        magicPenetrationFlatString.append("0");
        StringBuilder magicPenetrationPercentString = new StringBuilder("  Percent Magic Penetration: "); attributes.add(magicPenetrationPercentString);
        magicPenetrationPercentString.append("0");
        
        for (Item i : items.itemsInList)
        {   
            //cost
            if (i.getCost()!=0)
            {
                costString.append(" + "+i.getCost()+" ("+i+")");
            }
            //attack
            if (i.getAttackDamage()!=0)
            {
                attackDamageString.append(" + "+i.getAttackDamage()+" ("+i+")");
            }
            if (i.getCritChance()!=0)
            {
                critChanceString.append(" + "+i.getCritChance()+" ("+i+")");
            }
            if (i.getAttackSpeed()!=0)
            {
                attackSpeedString.append(" + "+i.getAttackSpeed()+" ("+i+")");
            }
            if (i.getLifeSteal()!=0)
            {
                lifeStealString.append(" + "+i.getLifeSteal()+" ("+i+")");
            }
            
            //Magic
            if (i.getAbilityPower()!=0)
            {
                abilityPowerString.append(" + "+i.getAbilityPower()+" ("+i+")");
            }
            if (i.getSpellvamp()!=0)
            {
                spellvampString.append(" + "+i.getSpellvamp()+" ("+i+")");
            }
            if (i.getCooldownReduction()!=0)
            {
                cooldownReductionString.append(" + "+i.getCooldownReduction()+" ("+i+")");
            }
            if (i.getMana()!=0)
            {
                manaString.append(" + "+i.getMana()+" ("+i+")");
            }
            
            //defense
            if (i.getHP()!=0)
            {
                hpString.append(" + "+i.getHP()+" ("+i+")");
            }
            if (i.getArmor()!=0)
            {
                armorString.append(" + "+i.getArmor()+" ("+i+")");
            }
            if (i.getMagicResist()!=0)
            {
                magicResistString.append(" + "+i.getMagicResist()+" ("+i+")");
            }
            
            //Regen and Speed
            if (i.getMoveSpeedFlat()!=0)
            {
                moveSpeedString.append(" + "+i.getMoveSpeedFlat()+" ("+i+")");
            }
            if (i.getMoveSpeedPercent()!=0)
            {
                moveSpeedPercentString.append(" + "+i.getMoveSpeedPercent()+" ("+i+")");
            }
            if (i.getHealthRegen()!=0)
            {
                healthRegenString.append(" + "+i.getHealthRegen()+" ("+i+")");
            }
            if (i.getManaRegen()!=0)
            {
                manaRegenString.append(" + "+i.getManaRegen()+" ("+i+")");
            }
            if (i.getTenacity()!=0)
            {
                tenacityString.append(" + "+i.getTenacity()+" ("+i+")");
            }
            
            //penetration
            if (i.getArmorPenetrationFlat()!=0)
            {
                armorPenetrationFlatString.append(" + "+i.getArmorPenetrationFlat()+" ("+i+")");
            }
            if (i.getArmorPenetrationPercent()!=0)
            {
                armorPenetrationPercentString.append(" + "+i.getArmorPenetrationPercent()+" ("+i+")");
            }
            if (i.getMagicPenetrationFlat()!=0)
            {
                magicPenetrationFlatString.append(" + "+i.getMagicPenetrationFlat()+" ("+i+")");
            }
            if (i.getMagicPenetrationPercent()!=0)
            {
                magicPenetrationPercentString.append(" + "+i.getMagicPenetrationPercent()+" ("+i+")");
            }
        }
        
        for (StringBuilder s : attributes)
        {
            if(s.toString().contains("+"))
            {
                s.append("\n");
                mathNotes.append(s);
            }
        }
        mathNotes.append("\n");
        
        return mathNotes;
    }
    
        //cost
        public double cost = 0;
    
        //Attack
        public double attackSpeed = 0;
        public double attackDamage = 0;
        public double critChance = 0;
        public double lifeSteal = 0;
        
        public double addedCritDamage = 0;
        
        //Magic
        public double abilityPower = 0;
        public double spellvamp = 0;
        public double cooldownReduction = 0;
        public double mana = 0;
        
        //Defense
        public double armor = 0;
        public double magicResist = 0;
        public double hp = 0;
        
        //Regen and move
        public double moveSpeed = 0;
        public double moveSpeedPercent = 0;
        public double healthRegen = 0;
        public double manaRegen = 0;
        public double tenacity = 0;
        
        //penetration
        public double armorPenetrationFlat = 0;
        public double armorPenetrationPercent = 0;
        public double magicPenetrationFlat = 0;
        public double magicPenetrationPercent = 0;
}
