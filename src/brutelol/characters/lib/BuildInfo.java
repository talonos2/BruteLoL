/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.characters.lib;

import brutelol.charbuild.Build;
import brutelol.charbuild.ItemSet;
import brutelol.charbuild.runes.RunePage;
import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.characters.lib.LolCharacter;
import brutelol.items.abstracts.BPassive;
import brutelol.items.abstracts.CPassive;
import brutelol.items.abstracts.Item;
import brutelol.items.instances.YoumuusGhostblade;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

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
    
    private Set<BPassive> basicPassives = EnumSet.noneOf(BPassive.class);
    private Set<CPassive> passives = EnumSet.noneOf(CPassive.class);
    
    //TODO: This will probably need to change as we work on build paths. For now, it's hardcoded.
    public double level = 18;
    
    public BuildInfo(AbstractLolCharacter c, Build b)
    {
        this.items = b.getItems();
        this.c=b.getCharacter();
        this.runes=b.getRunes();
        this.masteries=b.getMasteries();
        
        for (Item i : items.itemsInList)
        {   
            if (i == null)
            {
                continue;
            }
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
            
            basicPassives.addAll(i.getAllBasicPassives());
            passives.addAll(i.getAllComplicatedPassives());
        }
        
        //Because of the warlord mastery, we must do masteries after all other sources
        //of attack damage, but before adding character stuff. Luckily, there seems to
        //be no passives that affect AD, so we can still apply item passives last...
        
        runes.applyRunesPass1(this);
        masteries.applyMasteries(this);
        
        //Note: Warlord won't account for character-based steroids! We'll have to factor
        //them in later. Ugly... :(
            
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
        
        
        if (passives.contains(CPassive.WITS_END_PASSIVE))          {this.magicResist += 12.5;} //Assume 2.5 hits.
        if (passives.contains(CPassive.YOUMUUS_GHOSTBLADE_ACTIVE)) {this.attackSpeed += .4*YoumuusGhostblade.PERCENT_TIME_ON;}
        if (passives.contains(CPassive.YOUMUUS_GHOSTBLADE_ACTIVE)) {this.moveSpeedPercent += .2*YoumuusGhostblade.PERCENT_TIME_ON;}
        
        //Add benefits from basic passives:
        if (basicPassives.contains(BPassive.INFINITY_EDGE_PASSIVE))     {this.addedCritDamage += .5;}
        if (basicPassives.contains(BPassive.BLOODTHIRSTER_PASSIVE))     {this.lifeSteal += .2;}
        if (basicPassives.contains(BPassive.HEXTECH_GUNBLADE_PASSIVE))  {this.spellvamp += .2;}
        if (basicPassives.contains(BPassive.BLACK_CLEAVER_PASSIVE))     {this.armorPenetrationFlat += 10;}
        if (basicPassives.contains(BPassive.NASHOR_PASSIVE))            {this.cooldownReduction += .2;}
        if (basicPassives.contains(BPassive.EYES_OF_PAIN_PASSIVE))      {this.magicPenetrationFlat += 15;}
        if (basicPassives.contains(BPassive.LOCKET_PASSIVE))            {this.healthRegen += 10;this.magicResist += 20;}
        if (basicPassives.contains(BPassive.INSIGHT_PASSIVE))           {this.abilityPower += this.mana*.03;}
        if (basicPassives.contains(BPassive.WOOGLETS_PASSIVE))          {this.abilityPower *= 1.25;}
        if (basicPassives.contains(BPassive.DEATHCAP_PASSIVE))          {this.abilityPower *= 1.3;}
        if (basicPassives.contains(BPassive.WARMOGS_PASSIVE))           {this.healthRegen += this.hp*.01;}
        if (basicPassives.contains(BPassive.SPIRIT_VISAGE_PASSIVE))     {this.healthRegen *= 1.2; this.lifeSteal *= 1.2; this.spellvamp *= 1.2;}
        if (basicPassives.contains(BPassive.YOUMUUS_GHOSTBLADE_PASSIVE)){this.armorPenetrationFlat += 20;}
        if (basicPassives.contains(BPassive.MANA_FONT_PASSIVE))         {this.manaRegen *= 1.5;}
        if (basicPassives.contains(BPassive.WARMOGS_PASSIVE))           {this.healthRegen += this.hp*.01;}
        if (basicPassives.contains(BPassive.LAST_WHISPER_PASIVE))       {this.armorPenetrationPercent += .35;}
        
        
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

    public boolean hasPassive(CPassive cPassive) 
    {
        return passives.contains(cPassive);
    }
}