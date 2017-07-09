package brutelol.fights;

import brutelol.characters.lib.AbstractLolCharacter;
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
                d.insertDeltaClock(aUse, ally.getRemainingCooldownOn(aUse.getAbility()));
            }
        }
        for (Combatant enemy : enemies)
        {
            for (AbilityUse aUse : enemy.getAbilitiesAgainst(allies))
            {
                d.insertDeltaClock(aUse, enemy.getRemainingCooldownOn(aUse.getAbility()));
            }
        }
        
        double timeLeft = time;
        while (d.hasAnotherEvent()&&timeLeft>0)
        {
            timeLeft -= d.getTimeUntilNextEvent();
            wait(d.getTimeUntilNextEvent());
            TimedFightEvent aUse = d.getNextEvent();
            //System.out.println("Time: "+timeLeft);
            if (aUse.getSource().isDead())
            {
                System.out.println(aUse.getSource()+" is dead!");
                continue;
            }
            for (TimedFightEvent tbe : aUse.resolve())
            {
                d.insertDeltaClock(tbe, tbe.getTime());
            }
        }
    }

    private void wait(double d) {
        try
        {
            Thread.sleep((int)(d*4000));
        }
        catch (Exception e)
        {}
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
    public void addAlly(AbstractLolCharacter c, double prep, double sustain)
    {
        if (prep > 1 || prep < 0 || sustain > 1 || sustain < 0)
        {
            throw new IllegalArgumentException ("Must be between 0 and 1");
        }
        allies.add(new Combatant(c, prep, sustain));
    }

    public void addEnemy(AbstractLolCharacter c, double prep, double sustain)
    {
        if (prep > 1 || prep < 0 || sustain > 1 || sustain < 0)
        {
            throw new IllegalArgumentException ("Must be between 0 and 1");
        }
        enemies.add(new Combatant(c, prep, sustain));
    }
}
