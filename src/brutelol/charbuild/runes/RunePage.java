/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.charbuild.runes;

import brutelol.charbuild.runes.AttackDamageRune;
import brutelol.charbuild.runes.AttackSpeedRune;
import brutelol.charbuild.runes.AbilityPowerRune;
import brutelol.characters.lib.BuildInfo;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Talonos
 */
public class RunePage 
{
    private Rune[] quints = new Rune[3];
    private Rune[] marks = new Rune[9];
    private Rune[] seals = new Rune[9];
    private Rune[] glyphs = new Rune[9];
    
    private static final List<Rune> possibleRunes;
    
    static 
    {
        possibleRunes = new ArrayList<>();
        //possibleRunes.add(new AbilityPowerRune());
        possibleRunes.add(new AbilityPowerScalingRune());
        //possibleRunes.add(new ArmorRune());
        //possibleRunes.add(new ArmorScalingRune());
        possibleRunes.add(new ArmorPenRune());
        //possibleRunes.add(new AttackDamageRune());
        possibleRunes.add(new AttackDamageScalingRune());
        possibleRunes.add(new AttackSpeedRune());
        //possibleRunes.add(new CooldownReductionRune());
        //possibleRunes.add(new CooldownReductionScalingRune());
        possibleRunes.add(new CritChanceRune());
        possibleRunes.add(new CritDamageRune());
        //possibleRunes.add(new ExperienceRune());
        //possibleRunes.add(new GoldRune());
        //possibleRunes.add(new HealthRune());
        possibleRunes.add(new HealthScalingRune());
        //possibleRunes.add(new PercentHealthRune());
        //possibleRunes.add(new HealthRegenRune());
        //possibleRunes.add(new HealthRegenScalingRune());
        possibleRunes.add(new HybridPenRune());
        //possibleRunes.add(new LifeStealRune());
        possibleRunes.add(new MagicPenRune());
        //possibleRunes.add(new MagicResistRune());
        //possibleRunes.add(new MagicResistScalingRune());
        //possibleRunes.add(new ManaRune());
        possibleRunes.add(new ManaScalingRune());
        //possibleRunes.add(new ManaRegenRune());
        //possibleRunes.add(new ManaRegenScalingRune());
        //possibleRunes.add(new MoveSpeed());
        //possibleRunes.add(new SpellVampRune());
    }
    
    public RunePage()
    {
        for (int x = 0; x < 9; x++)
        {
            marks[x] = new BlankRune();
            seals[x] = new BlankRune();
            glyphs[x] = new BlankRune();
        }
        for (int x = 0; x < 3; x++)
        {
            quints[x] = new BlankRune();
        }
    }

    public static RunePage getRandomPage(Random dice) 
    {
        RunePage toReturn = new RunePage();
        for (int x = 0; x < 9; x++)
        {
            toReturn.marks[x] = possibleRunes.get(dice.nextInt(possibleRunes.size()));
            toReturn.seals[x] = possibleRunes.get(dice.nextInt(possibleRunes.size()));
            toReturn.glyphs[x] = possibleRunes.get(dice.nextInt(possibleRunes.size()));
        }
        for (int x = 0; x < 3; x++)
        {
            toReturn.quints[x] = possibleRunes.get(dice.nextInt(possibleRunes.size()));
        }
        return toReturn;
    }

    public RunePage mergeWith(RunePage r2, Random dice) 
    {
        RunePage babyRunes = new RunePage();
        
        for (int x = 0; x < 9; x++)
        {
            babyRunes.marks[x] = (dice.nextBoolean()?marks[x]:r2.marks[x]);
            babyRunes.seals[x] = (dice.nextBoolean()?seals[x]:r2.seals[x]);
            babyRunes.glyphs[x] = (dice.nextBoolean()?glyphs[x]:r2.glyphs[x]);
        }
        for (int x = 0; x < 3; x++)
        {
            babyRunes.quints[x] = (dice.nextBoolean()?quints[x]:r2.quints[x]);
        }
        
        while (dice.nextBoolean())
        {
            changeARandomRune(dice, babyRunes);
        }
        return babyRunes;
        
    }

    private void changeARandomRune(Random dice, RunePage babyRunes) 
    {
        int slot = dice.nextInt(30);
        if (slot < 9)
        {
            babyRunes.marks[slot] = possibleRunes.get(dice.nextInt(possibleRunes.size()));
        }
        else
        {
            slot -= 9;
            if (slot < 9)
            {
                babyRunes.seals[slot] = possibleRunes.get(dice.nextInt(possibleRunes.size()));
            }
            else
            {
                slot -= 9;
                if (slot < 9)
                {
                    babyRunes.glyphs[slot] = possibleRunes.get(dice.nextInt(possibleRunes.size()));
                }
                else
                {
                    slot -= 9;
                    babyRunes.quints[slot] = possibleRunes.get(dice.nextInt(possibleRunes.size()));
                }
            }
        }
    }

    public double getSimilarity(RunePage toCompare) 
    {
        //Right now, this just does a pointwise comparision. This is not the best measure of similarity!
        
        int toReturn = 0;
        
        for (int x = 0; x < 9; x++)
        {
            toReturn += (marks[x]==toCompare.marks[x]?1:0);
            toReturn += (seals[x]==toCompare.seals[x]?1:0);
            toReturn += (glyphs[x]==toCompare.glyphs[x]?1:0);
        }
        for (int x = 0; x < 3; x++)
        {
            toReturn += (quints[x]==toCompare.quints[x]?1:0);
        }
        return toReturn;
    }

    public void applyRunesPass1(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) 
    {
        for (int x = 0; x < 9; x++)
        {
            marks[x].applyChangesAsMark(bi, logs);
            seals[x].applyChangesAsSeal(bi, logs);
            glyphs[x].applyChangesAsGlyph(bi, logs);
        }
        for (int x = 0; x < 3; x++)
        {
            quints[x].applyChangesAsQuint(bi, logs);
        }
    }
    
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for (int x = 0; x < 9; x++)
        {
            s.append("[");
            s.append(marks[x]);
            s.append("]");
        }
        s.append(",");
        for (int x = 0; x < 9; x++)
        {
            s.append("(");
            s.append(seals[x]);
            s.append(")");
        }
        s.append(",");
        for (int x = 0; x < 9; x++)
        {
            s.append("{");
            s.append(glyphs[x]);
            s.append("}");
        }
        s.append(",");
        for (int x = 0; x < 3; x++)
        {
            s.append("<");
            s.append(quints[x]);
            s.append(">");
        }
        return s.toString();
    }
    
}
