package brutelol.fights;

import brutelol.charbuild.Build;
import java.util.ArrayList;
import java.util.List;

/**
 * A Fight represents a timed engagement between characters. It is run, and
 * then different results can be queried.
 * @author Talonos
 */
public class Fight 
{
    private int time;
    private List<Combatant> allies = new ArrayList<>();
    private List<Combatant> enemies = new ArrayList<>();
    
    /**
     * Starts the simulation!
     */
    public void runFight()
    {
        DeltaClock d = new DeltaClock();
        for (Combatant ally : allies)
        {
            for (AbilityUse aUse : ally.getAbilitiesAgainst(enemies))
            {
                d.insertDeltaClock(aUse, time);
            }
        }
        for (Combatant enemy : enemies)
        {
            for (AbilityUse aUse : enemy.getAbilitiesAgainst(allies))
            {
                d.insertDeltaClock(aUse, time);
            }
        }
        
        while (d.hasAnotherEvent())
        {
            d.getNextEvent().resolve();
        }
    }
    
    public void setTime(int time)
    {
        this.time = time;
    }
    
    /**
     * Adds a build to the list of allies.
     * @param b the build to add. 
     * @param prep How prepared for the engagement was this combatant? (All cooldowns are
     * this % available.)
     * @param sustain How much of a resource bar does this combatant have?
     */
    public void addAlly(Build b, double prep, double sustain)
    {
        if (prep > 1 || prep < 0 || sustain > 1 || sustain < 0)
        {
            throw new IllegalArgumentException ("Must be between 0 and 1");
        }
        allies.add(new Combatant(b, prep, sustain));
    }
}
