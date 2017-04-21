package brutelol.characters.lib;

import java.util.EnumMap;

/**
 * A data structure describing the masteries a champion has equipped.
 * @author Talonos
 */
public abstract class Masteries 
{
    public abstract void applyMasteries(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs);
    
    public abstract boolean hasMastery(Mastery m);
}
