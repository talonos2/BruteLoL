/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.instances;

import brutelol.Masteries;
import brutelol.buildobjs.Build;
import brutelol.buildobjs.ItemSet;
import brutelol.buildobjs.RunePage;
import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.characters.lib.LolCharacter;
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
    
    public BuildInfo(AbstractLolCharacter c, Build b)
    {
        this.items = b.getItems();
        this.c=b.getCharacter();
        this.runes=b.getRunes();
        this.masteries=b.getMasteries();
        
        for (Item i : items.itemsInList)
        {   
            //cost
            cost += i.getCost();
            
            //attack
            attackDamage += i.getAttackDamage();
            critChance += i.getCritChance();
            attackSpeed+=i.getAttackSpeed();
            lifeSteal += i.getLifesteal();
            
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
        }
            
        //attack
        attackDamage += c.getAttackDamage(b);
        attackSpeed+=c.getAttackSpeed(b);
            
        //Magic
        mana += c.getMaxMana(b);
            
        //defense
        hp+=c.getMaxHP(b);
        armor+=c.getArmor(b);
        magicResist+=c.getMagicResist(b);
        
        //Regen and Speed
        moveSpeed += c.getMoveSpeed(b);
        healthRegen+=c.getHealthRegen(b);
        manaRegen += c.getManaRegen(b);
    }

    public StringBuilder showWork(Build b) 
    {   
        StringBuilder mathNotes = new StringBuilder();
        mathNotes.append("From items we get the following:\n");
        
        List<StringBuilder> attributes = new ArrayList<>();
        
        StringBuilder costString = new StringBuilder("  Cost: "); attributes.add(costString);
        costString.append("0");
        StringBuilder attackDamageString = new StringBuilder("  Attack Damage: "); attributes.add(attackDamageString);
        attackDamageString.append(c.getAttackDamage(b));
        StringBuilder critChanceString = new StringBuilder("  Crit Chance: "); attributes.add(critChanceString);
        critChanceString.append("0");
        StringBuilder attackSpeedString = new StringBuilder("  Attack Speed: "); attributes.add(attackSpeedString);
        attackSpeedString.append(c.getAttackSpeed(b));
        StringBuilder lifeStealString = new StringBuilder("  Lifesteal: "); attributes.add(lifeStealString);
        lifeStealString.append("0");
        StringBuilder abilityPowerString = new StringBuilder("  Ability Power: "); attributes.add(abilityPowerString);
        abilityPowerString.append("0");
        StringBuilder spellvampString = new StringBuilder("  Spellvamp: "); attributes.add(spellvampString);
        spellvampString.append("0");
        StringBuilder cooldownReductionString = new StringBuilder("  Cooldown Reduction: "); attributes.add(cooldownReductionString);
        cooldownReductionString.append("0");
        StringBuilder manaString = new StringBuilder("  Mana: 0"); attributes.add(manaString);
        manaString.append(c.getMaxMana(b));
        StringBuilder hpString = new StringBuilder("  HP: "); attributes.add(hpString); 
        hpString.append(c.getMaxHP(b));
        StringBuilder armorString = new StringBuilder("  Armor: "); attributes.add(armorString);
        armorString.append(c.getArmor(b));
        StringBuilder magicResistString = new StringBuilder("  Magic Resistance: "); attributes.add(magicResistString);
        magicResistString.append(c.getMagicResist(b));
        StringBuilder moveSpeedString = new StringBuilder("  Flat Move Speed: "); attributes.add(moveSpeedString);
        moveSpeedString.append(c.getMoveSpeed(b));
        StringBuilder moveSpeedPercentString = new StringBuilder("  Percent move speed: "); attributes.add(moveSpeedPercentString);
        moveSpeedPercentString.append("0");
        StringBuilder healthRegenString = new StringBuilder("  Health regeneration: "); attributes.add(healthRegenString);
        healthRegenString.append(c.getHealthRegen(b));
        StringBuilder manaRegenString = new StringBuilder("  Mana Regeneration: "); attributes.add(manaRegenString);
        manaRegenString.append(c.getManaRegen(b));
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
            if (i.getLifesteal()!=0)
            {
                lifeStealString.append(" + "+i.getLifesteal()+" ("+i+")");
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
