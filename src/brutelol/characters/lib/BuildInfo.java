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
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Talonos
 */
public class BuildInfo 
{

    public enum Ability
    {
        COST("Cost"), 
        ATTACK_SPEED("Attack Speed"), 
        ATTACK_DAMAGE("Attack Damage"), 
        CRIT_CHANCE("Crit Chance"), 
        LIFE_STEAL("Life Steal"),
        ADDED_CRIT_DAMAGE("Added Crit Damage"),
        ABILITY_POWER("Ability Power"), 
        SPELLVAMP("Spell Vamp"), 
        COOLDOWN_REDUCTION("Cooldown Reduction"), 
        MANA("Mana"),
        ARMOR("Armor"), 
        MAGIC_RESIST("Magic Resist"), 
        HP("HP"),
        MOVE_SPEED("Move Speed"), 
        MOVE_SPEED_PERCENT("Move Speed Percent"), 
        HEALTH_REGEN("Health Regen"), 
        MANA_REGEN("Mana Regen"), 
        TENACITY("Tenacity"),
        ARMOR_PEN_FLAT("Armor Pen Flat"), 
        ARMOR_PEN_PERCENT("Armor Pen Percent"), 
        MAGIC_PEN_FLAT("Magic Pen Flat"), 
        MAGIC_PEN_PERCENT("Magic Pen Percent");
        
        private String name;
        
        Ability(String name)
        {
            this.name = name;
        }
        
        String getName()
        {
            return name;
        }
    }
    
    private EnumMap<Ability, StringBuilder> logs;
    
    private ItemSet items = null;
    private AbstractLolCharacter c = null;
    private RunePage runes = null;
    private Masteries masteries = null;
    
    private Set<BPassive> basicPassives = EnumSet.noneOf(BPassive.class);
    private Set<CPassive> passives = EnumSet.noneOf(CPassive.class);
    
    //TODO: This will probably need to change as we work on build paths. For now, it's hardcoded.
    public double level = 18;
    
    public BuildInfo(AbstractLolCharacter c, Build b, StringBuilder mathNotes)
    {
        if (mathNotes != null)
        {
            logs = new EnumMap<>(Ability.class);
            for (Ability a : Ability.values())
            {
                logs.put(a, new StringBuilder());
                logs.get(a).append("Calculation of "+a.getName()+":\n"
                                 + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"
                                 + "From Items:\n");
            }
        }
        
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
            
            //Group all notes under one if statement to improve performance.
            if (mathNotes != null) 
            {
                addToNotes(i.getCost(), Ability.COST, i);
                addToNotes(i.getAttackDamage(), Ability.ATTACK_DAMAGE, i);
                addToNotes(i.getCritChance(), Ability.CRIT_CHANCE, i);
                addToNotes(i.getAttackSpeed(), Ability.ATTACK_SPEED, i);
                addToNotes(i.getLifesteal(), Ability.LIFE_STEAL, i);
                addToNotes(i.getAbilityPower(), Ability.ABILITY_POWER, i);
                addToNotes(i.getSpellvamp(), Ability.SPELLVAMP, i);
                addToNotes(i.getCooldownReduction(), Ability.COOLDOWN_REDUCTION, i);
                addToNotes(i.getHP(), Ability.HP, i);
                addToNotes(i.getArmor(), Ability.ARMOR, i);
                addToNotes(i.getMagicResist(), Ability.MAGIC_RESIST, i);
                addToNotes(i.getMoveSpeedFlat(), Ability.MOVE_SPEED, i);
                addToNotes(i.getMoveSpeedPercent(), Ability.MOVE_SPEED_PERCENT, i);
                addToNotes(i.getHealthRegen(), Ability.HEALTH_REGEN, i);
                addToNotes(i.getManaRegen(), Ability.MANA_REGEN, i);
            }
        }
        
        //Because of the warlord mastery, we must do masteries after all other sources
        //of attack damage, but before adding character stuff. Luckily, there seems to
        //be no passives that affect AD, so we can still apply item passives last...
        
        runes.applyRunesPass1(this, logs);
        masteries.applyMasteries(this, logs);
        
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
        
        if (mathNotes != null)
        {
            for (Ability a : Ability.values())
            {
                mathNotes.append(logs.get(a));
            }
        }
              
    }

    private void addToNotes(double amount, Ability ability, Item i) 
    {
        //Stringbuilder concatenation is so ugly!
        //If we want to use the "+" operator to concatenate strings in an
        //inner loop, shouldn't java be smart enough to switch it to a stringbuilder?
        logs.get(ability).append(" - +").append(amount).append(" from ").append(i.getName()).append("\n");
    }

    public boolean hasPassive(CPassive cPassive) 
    {
        return passives.contains(cPassive);
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
