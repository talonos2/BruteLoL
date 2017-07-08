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
 * A build is a collection of items and character, ready to evaluate. We'll later
 * create a "BuildPath" that represents how to get to a build.
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
    
    private int time;
    private int level;
    
    private StringBuilder notes;
    
    public Build(ItemSet items, AbstractLolCharacter character, int level, int time)
    {
        this.items = items;
        this.character = character;
        this.time = time;
        this.level = level;
        this.info = character.getBuildInfo(this, null);
    }
    
    public ItemSet getItems()
    {
        return items;
    }
    
    public int getTime()
    {
        return time;
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

    public int getLevel() 
    {
        return level;
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
