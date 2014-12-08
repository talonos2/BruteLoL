package brutelol.charbuild;

import brutelol.charbuild.runes.RunePage;
import brutelol.Masteries;
import brutelol.characters.instances.BuildInfo;
import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.characters.lib.LolCharacter;
import brutelol.characters.lib.HeuristicComponent;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Talonos
 */
public class Build 
{
    private double utility = 0;
    private ItemSet items;
    private RunePage runes;
    private AbstractLolCharacter character;
    private BuildInfo info;
    private Masteries masteries;
    private Map<HeuristicComponent, Double> components = new EnumMap<>(HeuristicComponent.class);
    
    private int gold;
    private int time;
    private int xp;
    
    private StringBuilder notes;
    
    public Build(ItemSet items, AbstractLolCharacter character, int gold, int xp, int time, RunePage runes)
    {
        this.items = items;
        this.character = character;
        this.time = time;
        this.gold=gold;
        this.xp=xp;
        this.runes = runes;
        this.info = character.getBuildInfo(this);
    }

    public double getComponent(HeuristicComponent h, Build enemy) 
    {
        if (!components.containsKey(h))
        {
            components.put(h, character.getComponentUtility(this, enemy, h));
        }
        return components.get(h);
    }
    
    public ItemSet getItems()
    {
        return items;
    }
    
    public int getGold()
    {
        return gold;
    }
    
    public int getTime()
    {
        return time;
    }
    
    public int getXP()
    {
        return xp;
    }
    
    //Has this build explain every heuristic stuff in excruciating detail, such 
    //that you can put it in a spoiler to satisfy the mathematicians/unbelivers 
    //on mobafire.
    public String getAllInfo()
    {
        return "";
    }
    
    //Has this build explain its "End result". This is a description of it plus
    //all the evaluations of its heuristics.
    public String getInfo()
    {
        return "";
    }
    
    /**
     * Calculates the heuristic, printing attendant math notes to the console.
     * @param h
     * @param enemy
     * @return 
     */
    public String getComponentMathNotes(HeuristicComponent h, Build enemy)
    {
        //We might have already calculated the component, so clear our component
        //cache. This shouldn't be a problem, because we should never be printing
        //more than hundreds of math logs at a time.
        this.components.clear();
        this.turnOnNotes();
        this.addLineToNotes("===================================================");
        this.addLineToNotes("Analysis of build "+this.items);
        this.addLineToNotes("===================================================");
        this.addLineToNotes("Runes: "+this.runes);
        this.addLineToNotes("===================================================");
        this.addLineToNotes("===================================================");
        
        this.getComponent(h, enemy);
        String toReturn = notes.toString();
        this.turnOffNotes();
        return toReturn;
    }

    public RunePage getRunes() 
    {
        return runes;
    }

    /**
     * Gets the raw stats of this build, such as armor, attack damage, etc.
     * Basically, anything that comes from items and base stats.
     * @return a wrapper class around those stats.
     */
    public BuildInfo getBuildInfo() 
    {
        if (info == null)
        {
            info = character.getBuildInfo(this);
        }
        return info;
    }

    public AbstractLolCharacter getCharacter() 
    {
        return character;
    }

    public Masteries getMasteries() 
    {
        return masteries;
    }
    
    public void addLineToNotes(String s)
    {
        if (notes != null)
        {
            notes.append(s);
            notes.append("\n");
        }
    }
    
    private void turnOnNotes()
    {
        notes = new StringBuilder();
    }

    private void turnOffNotes() 
    {
        notes = null;
    }
    
}
