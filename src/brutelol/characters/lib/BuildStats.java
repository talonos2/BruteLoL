package brutelol.characters.lib;

import brutelol.characters.instances.abilities.StatusEffect;
import brutelol.charbuild.Build;
import brutelol.charbuild.ItemSet;
import brutelol.items.abstracts.BUnique;
import brutelol.items.abstracts.CUnique;
import brutelol.items.abstracts.Item;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/**
 * A "Build info" is a data structure that holds data regarding an item, rune, and
 * mastery build.
 * 
 * @author Talonos
 */
public class BuildStats 
{
    
    private List<StatusEffect> statusEffects = new ArrayList<>();

    List<StatusEffect> getItemStatusEffects() 
    {
        return Collections.unmodifiableList(statusEffects);
    }

    public enum ChampStat
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
        
        ChampStat(String name)
        {
            this.name = name;
        }
        
        String getName()
        {
            return name;
        }
    }
    
    private EnumMap<ChampStat, StringBuilder> logs;
    
    private ItemSet items = null;

    private Set<BUnique> basicUniques = EnumSet.noneOf(BUnique.class);
    
    //TODO: This will probably need to change as we work on build paths. For now, it's hardcoded.
    public double level = 18;
    
    public BuildStats(AbstractLolCharacter c, Build b, StringBuilder mathNotes)
    {
        if (mathNotes != null)
        {
            logs = new EnumMap<>(ChampStat.class);
            for (ChampStat a : ChampStat.values())
            {
                logs.put(a, new StringBuilder());
                logs.get(a).append("Calculation of "+a.getName()+":\n"
                                 + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n"
                                 + "From Items:\n");
            }
        }
        
        this.items = b.getItems();
        
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
            
            basicUniques.addAll(i.getAllBasicUniques());
            
            //Group all notes under one if statement to improve performance.
            if (mathNotes != null) 
            {
                addToNotes(i.getCost(), ChampStat.COST, i);
                addToNotes(i.getAttackDamage(), ChampStat.ATTACK_DAMAGE, i);
                addToNotes(i.getCritChance(), ChampStat.CRIT_CHANCE, i);
                addToNotes(i.getAttackSpeed(), ChampStat.ATTACK_SPEED, i);
                addToNotes(i.getLifesteal(), ChampStat.LIFE_STEAL, i);
                addToNotes(i.getAbilityPower(), ChampStat.ABILITY_POWER, i);
                addToNotes(i.getSpellvamp(), ChampStat.SPELLVAMP, i);
                addToNotes(i.getCooldownReduction(), ChampStat.COOLDOWN_REDUCTION, i);
                addToNotes(i.getHP(), ChampStat.HP, i);
                addToNotes(i.getArmor(), ChampStat.ARMOR, i);
                addToNotes(i.getMagicResist(), ChampStat.MAGIC_RESIST, i);
                addToNotes(i.getMoveSpeedFlat(), ChampStat.MOVE_SPEED, i);
                addToNotes(i.getMoveSpeedPercent(), ChampStat.MOVE_SPEED_PERCENT, i);
                addToNotes(i.getHealthRegen(), ChampStat.HEALTH_REGEN, i);
                addToNotes(i.getManaRegen(), ChampStat.MANA_REGEN, i);
            }
            
            statusEffects.addAll(i.getAllStatusEffects());
        }
        
        //Add character attributes:
        
        //attack
        attackDamage += c.getBaseAttackDamage();
        attackSpeed+=c.getBaseAttackSpeedBonus();
            
        //Magic
        mana += c.getBaseMaxMana();
            
        //defense
        hp+=c.getBaseMaxHP();
        armor+=c.getBaseArmor();
        magicResist+=c.getBaseMagicResist();
        
        //Regen and Speed
        moveSpeed += c.getBaseMoveSpeed();
        healthRegen+=c.getBaseHealthRegen();
        manaRegen += c.getBaseManaRegen();
        
        //Here, we add unique effects from items. Any effects that 
        //are target-independant and affects basic statistics can go here.
        
        if (basicUniques.contains(CUnique.BLOODTHIRSTER))     {this.lifeSteal += .2;}
        if (basicUniques.contains(BUnique.INFINITY_EDGE))     {this.addedCritDamage += .5;}
        
        if (mathNotes != null)
        {
            for (ChampStat a : ChampStat.values())
            {
                //Todo: Avoid copy/paste with final strings and replacements
                if (!logs.get(a).toString().equals("Calculation of "+a.getName()+":\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\nFrom Items:\n"))
                {
                    //System.err.println(logs.get(a));
                    mathNotes.append(logs.get(a));
                }
            }
        }
        
        //Cap CDR
        if (cooldownReduction > .4)
        {
            cooldownReduction = .4;
        }
              
    }

    private void addToNotes(double amount, ChampStat ability, Item i) 
    {
        //Stringbuilder concatenation is so ugly!
        //If we want to use the "+" operator to concatenate strings in an
        //inner loop, shouldn't java compilation be smart enough to switch it to a stringbuilder?
        if (amount != 0)
        {
            logs.get(ability).append(" - +").append(amount).append(" from ").append(i.getName()).append("\n");
        }
    }

    //And all that above was the constructor, basically. When we are done,
    //we get this list of attributes, then used to calculate heuristic components
    //in an abstract LoL character.

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
        
        public String toString()
        {
            return "HP: "+hp+", (+"+healthRegen+"/sec)\n"+
                   "MP: "+mana+", (+"+manaRegen+"/sec)\n"+
                   "AD: "+attackDamage+", AP:"+abilityPower+"";
        }
}
