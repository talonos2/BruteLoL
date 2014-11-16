package brutelol.buildobjs;

import brutelol.Masteries;
import brutelol.characters.instances.BuildInfo;
import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.characters.lib.LolCharacter;
import brutelol.characters.lib.HeuristicComponent;

/**
 *
 * @author Talonos
 */
public class Build 
{
    private double utility = 0;
    private ItemSet items;
    private RunePage runes = new RunePage();
    private AbstractLolCharacter character;
    private BuildInfo info;
    private Masteries masteries;
    
    private int gold;
    private int time;
    private int xp;
    
    public Build(ItemSet items, AbstractLolCharacter character, int gold, int xp, int time)
    {
        this.items = items;
        this.character = character;
        this.info = character.getBuildInfo(this);
        this.time = time;
        this.gold=gold;
        this.xp=xp;
    }

    public double getComponent(HeuristicComponent h) 
    {
        return character.getComponentUtility(this, h);
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
    
    //Has this build explain its stuff in excruciating detail, such that you can
    //put it in a spoiler to satisfy the mathematicians/unbelivers on mobafire.
    public String getDetailedInfo()
    {
        return "";
    }
    
    //Has this build explain its "End result". This is a description of it plus
    //all the evaluations of its heuristics.
    public String getInfo()
    {
        return "";
    }

    public RunePage getRunes() 
    {
        return runes;
    }

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
    
}
