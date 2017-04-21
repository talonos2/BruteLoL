package brutelol.characters.lib;

import java.util.EnumMap;

/**
 * Represents a blank mastery page.
 * 
 * @author Talonos
 */
public class BlankMasteries extends Masteries
{

    @Override
    public void applyMasteries(BuildInfo bi, EnumMap<BuildInfo.Ability, StringBuilder> logs) 
    {

    }

    @Override
    public boolean hasMastery(Mastery m) 
    {
        return false;
    }
}
