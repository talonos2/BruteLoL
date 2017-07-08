package brutelol.charbuild;

import brutelol.characters.lib.BuildInfo;
import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.characters.lib.HeuristicComponent;
import brutelol.characters.lib.TargetedHeuristicComponent;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A build is a collection of itemset, runes, character, and masteries, ready to evaluate.
 * @author Talonos
 */
public class Build 
{
    private double utility = 0;
    private ItemSet items;
    private AbstractLolCharacter character;
    private BuildInfo info;
    private Map<HeuristicComponent, Double> components = new EnumMap<>(HeuristicComponent.class);
    private final Map<TargetHeuristicWrapper, Double> tComponents = new HashMap<>();
    
    private int gold;
    private int time;
    private int xp;
    
    private StringBuilder notes;
    
    public Build(ItemSet items, AbstractLolCharacter character, int gold, int xp, int time)
    {
        this.items = items;
        this.character = character;
        this.time = time;
        this.gold=gold;
        this.xp=xp;
        this.info = character.getBuildInfo(this, null);
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
    
    /**
     * Have this build explain every heuristic stuff in excruciating detail, such 
     * that you can put it in a spoiler to satisfy the mathematicians/unbelievers
     * on mobafire.
     * @return an wordy math analysis, in string form.
     */
    public String getAllInfo()
    {
        return "";
    }
    
    /**
     * Has this build explain its "End result". This is a description of it plus
     * all the evaluations of its heuristics.
     */
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
    public String getComponentMathNotes(HeuristicComponent h)
    {
        //We might have already calculated the component, so clear our component
        //cache. This shouldn't be a problem, because we should never be printing
        //more than hundreds of math logs at a time.
        this.components.clear();
        this.turnOnNotes();
        this.addLineToNotes("===================================================");
        this.addLineToNotes("Analysis of build "+this.items);
        this.addLineToNotes("===================================================");
        character.getBuildInfo(this, this.notes);
        
        //Calculating the component also calculates the sub-components needed to
        //calculate the component to begin with. Because we turned the notes on,
        //all their math will also be added.
        this.getComponent(h);
        String toReturn = notes.toString();
        this.turnOffNotes();
        return toReturn;
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
            info = character.getBuildInfo(this, null);
        }
        return info;
    }

    public AbstractLolCharacter getCharacter() 
    {
        return character;
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
    
    private static final String BB_1 = "[table]\n" +
            "[tr]\n" +
            "[td padding=5 bgcolor=003366 colspan = 7]\n" +
            "[center][color=#33aaff][size = 5][b]Build ";
    private static final String BB_2 = "[/b][/size][/color][/center][/td]\n" +
            "[/tr]\n" +
            "[tr]\n" +
            "[td padding=5 bgcolor=";
    private static final String BB_3 = " colspan = 2]\n" +
            "[center][icon=";
    private static final String BB_BETWEEN_ITEMS_1 =  " size = 70][icon=";
    private static final String BB_BETWEEN_ITEMS_2 =  " size = 70]\n"
            + "[icon=";
    private static final String BB_4 = " size = 70][/center]\n" +
            "[/td]\n" +
            "[td padding=5 bgcolor=";
    private static final String BB_5 = " colspan = 5][b][color=#33aaff][size = 4]Vital Stats:[/size][/color][/b]\n" +
            "[list]\n";
    private static final String BB_OVERVIEW_ITEM_START = "[*][color=#ccffff]";
    private static final String BB_OVERVIEW_ITEM_END = "[/color]\n";
    private static final String BB_BOLD = "[b]";
    private static final String BB_UNBOLD = "[/b]";
    
    public void getBBCode(List<Build> foes, int buildNumber, String buildName) 
    {
        List<HeuristicComponent> overviewHeuristics = new ArrayList<>();
        
        
        StringBuilder total = new StringBuilder();
        
        total.append(BB_1);
        total.append(buildNumber);
        total.append(": ");
        total.append(buildName);
        total.append(BB_2);
        total.append(this.character.getColorString());
        total.append(BB_3);
        total.append(items.itemsInList[0].getName());
        total.append(BB_BETWEEN_ITEMS_1);
        total.append(items.itemsInList[1].getName());
        total.append(BB_BETWEEN_ITEMS_2);
        total.append(items.itemsInList[2].getName());
        total.append(BB_BETWEEN_ITEMS_1);
        total.append(items.itemsInList[3].getName());
        total.append(BB_BETWEEN_ITEMS_2);
        total.append(items.itemsInList[4].getName());
        total.append(BB_BETWEEN_ITEMS_1);
        total.append(items.itemsInList[5].getName());
        total.append(BB_4);
        total.append(this.character.getColorString());
        total.append(BB_5);
        for (HeuristicComponent h : overviewHeuristics)
        {
            total.append(BB_OVERVIEW_ITEM_START);
            total.append(h.getName());
            total.append(": ");
            total.append(BB_BOLD);
            this.getComponent(h); //We put null here because if anything requires multiple
            total.append(h.getBoldPostfix());
            total.append(BB_UNBOLD);
            total.append(h.getNotBoldPostfix());
            total.append(BB_OVERVIEW_ITEM_END);
        }
        
        List<HeuristicComponent> toList = new ArrayList<>();
        
        
        /* The following is the BBCode the generates the spiffy build template I
           use on MobaFire to make a good looking guide. It is here so that I can
           copy and past chunks of it into the code above, so I can proceedurally
           generate fancy looking build evaluations from the template.
        
        
        [table]
[tr]
[td padding=5 bgcolor=003366 colspan = 7]
[center][color=#33aaff][size = 5][b]Build 11: Damage Level = Phreak[/b][/size][/color][/center][/td]
[/tr]
[tr]
[td padding=5 bgcolor=003366 colspan = 2]
[center][icon=the bloodthirster size = 70][icon=Last Whisper size = 70]
[icon=Infinity edge size = 70][icon=phantom dancer size = 70]
[icon=phantom dancer size = 70][icon=youmuu's ghostblade size = 70][/center]
[/td]
[td padding=5 bgcolor=003366 colspan = 5][b][color=#33aaff][size = 4]Vital Stats:[/size][/color][/b]
[list]
[*][color=#ccffff]Total attack speed: [b]100%[/b]/second[/color]
[*][color=#ccffff]Total attack damage: [b]150[/b][/color]
[*][color=#ccffff]Crit chance: [b]50%[/b][/color]
[*][color=#ccffff]Damage on Crit: [b]250%[/b][/color]
[*][color=#ccffff]Move speed in combat: [b]450[/b][/color]
[/list]
[/td]
[/tr]

[tr]
[th padding=5 bgcolor=333 colspan=1][/th]
[th padding=5 bgcolor=333 colspan=1]Damage Per Second[/th]
[th padding=5 bgcolor=333 colspan=1]Life Stolen per second[/th]
[th padding=5 bgcolor=333 colspan=1]Single Attack Damage[/th]
[th padding=5 bgcolor=333 colspan=1]Volley Damage[/th]
[th padding=5 bgcolor=333 colspan=1]Burst Damage[/th]
[th padding=5 bgcolor=333 colspan=1]Kiting Damage[/th]
[/tr]
[tr]
[td padding=5 bgcolor=5c563f][center][icon=classic rammus size=50][/center][/td]
[td padding=5 bgcolor=5c563f][center]100[br][img=http://i750.photobucket.com/albums/xx144/Talonos2/GrdA.png][/center][/td]
[td padding=5 bgcolor=5c563f][center]100[br][img=http://i750.photobucket.com/albums/xx144/Talonos2/GrdB.png][/center][/td]
[td padding=5 bgcolor=5c563f][center]100[br][img=http://i750.photobucket.com/albums/xx144/Talonos2/GrdC.png][/center][/td]
[td padding=5 bgcolor=5c563f][center]100[br][img=http://i750.photobucket.com/albums/xx144/Talonos2/GrdD.png][/center][/td]
[td padding=5 bgcolor=5c563f][center]100[br][img=http://i750.photobucket.com/albums/xx144/Talonos2/GrdF.png][/center][/td]
[td padding=5 bgcolor=5c563f][center]100[br][img=http://i750.photobucket.com/albums/xx144/Talonos2/GrdBM.png][/center][/td]
[/tr]
[tr]
[td padding=5 bgcolor=341f12][center][icon=classic udyr size=50][/center][/td]
[td padding=5 bgcolor=341f12][center]100[br][img=http://i750.photobucket.com/albums/xx144/Talonos2/GrdA.png][/center][/td]
[td padding=5 bgcolor=341f12][center]100[br][img=http://i750.photobucket.com/albums/xx144/Talonos2/GrdB.png][/center][/td]
[td padding=5 bgcolor=341f12][center]100[br][img=http://i750.photobucket.com/albums/xx144/Talonos2/GrdC.png][/center][/td]
[td padding=5 bgcolor=341f12][center]100[br][img=http://i750.photobucket.com/albums/xx144/Talonos2/GrdD.png][/center][/td]
[td padding=5 bgcolor=341f12][center]100[br][img=http://i750.photobucket.com/albums/xx144/Talonos2/GrdF.png][/center][/td]
[td padding=5 bgcolor=341f12][center]100[br][img=http://i750.photobucket.com/albums/xx144/Talonos2/GrdBM.png][/center][/td]
[/tr]
[tr]
[td padding=5 bgcolor=744533][center][icon=classic sivir size=50][/center][/td]
[td padding=5 bgcolor=744533][center]100[br][img=http://i750.photobucket.com/albums/xx144/Talonos2/GrdA.png][/center][/td]
[td padding=5 bgcolor=744533][center]100[br][img=http://i750.photobucket.com/albums/xx144/Talonos2/GrdB.png][/center][/td]
[td padding=5 bgcolor=744533][center]100[br][img=http://i750.photobucket.com/albums/xx144/Talonos2/GrdC.png][/center][/td]
[td padding=5 bgcolor=744533][center]100[br][img=http://i750.photobucket.com/albums/xx144/Talonos2/GrdD.png][/center][/td]
[td padding=5 bgcolor=744533][center]100[br][img=http://i750.photobucket.com/albums/xx144/Talonos2/GrdF.png][/center][/td]
[td padding=5 bgcolor=744533][center]100[br][img=http://i750.photobucket.com/albums/xx144/Talonos2/GrdBM.png][/center][/td]
[/tr]
[/table]
        
        */
        
    }

    /**
     * Gets the value of a Heuristic, by either calculating it or using a cached
     * value. We do so by passing off the heavy lifting to the character we contain.
     * However, because the character needs to do things with the build (such as updating
     * its math notes and getting the build's buildinfo) we pass in ourselves as well.
     * 
     * @param h the heuristic to get.
     * @return the value of the heuristic component.
     */
    
    public double getComponent(HeuristicComponent h) 
    {
        if (!components.containsKey(h))
        {
            components.put(h, character.getComponentUtility(this, h));
        }
        return components.get(h);
    }
    
    /**
     * Gets the value of a targeted Heuristic, by either calculating it or using 
     * a cached value. A "Targeted" Heuristic is one that requires a target. (Such
     * as an ally you are healing or an enemy you are attacking.
     * 
     * @param h the heuristic to get.
     * @param target the target you are calculating against.
     * @return the value of the heuristic component.
     */
    public double getTargetedComponent(TargetedHeuristicComponent h, Build target) 
    {
        TargetHeuristicWrapper thw = new TargetHeuristicWrapper(target, h);
        if (!tComponents.containsKey(thw))
        {
            tComponents.put(thw, character.getTargetedComponentUtility(this, target, h));
        }
        return tComponents.get(thw);
    }
    
    private class TargetHeuristicWrapper
    {
        private Build target;
        private TargetedHeuristicComponent thc;
        TargetHeuristicWrapper(Build target, TargetedHeuristicComponent thc)
        {
            this.target = target;
            this.thc = thc;
        }

        @Override
        public int hashCode() 
        {
            int hash = 7;
            hash = 61 * hash + Objects.hashCode(this.target);
            hash = 61 * hash + Objects.hashCode(this.thc);
            return hash;
        }

        @Override
        public boolean equals(Object obj) 
        {
            if (obj == null) 
            {
                return false;
            }
            if (getClass() != obj.getClass()) 
            {
                return false;
            }
            final TargetHeuristicWrapper other = (TargetHeuristicWrapper) obj;
            if (!Objects.equals(this.target, other.target)) 
            {
                return false;
            }
            if (this.thc != other.thc) 
            {
                return false;
            }
            return true;
        }
        
        
    }
    
}
