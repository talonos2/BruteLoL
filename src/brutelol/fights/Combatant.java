/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.fights;

import brutelol.charbuild.Build;
import java.util.List;

/**
 * A combatant is a wrapper around a build, giving it a "State", etc.
 * @author Talonos
 */
public class Combatant 
{
    private Build wrappedBuild;
    
    public Combatant(Build b)
    {
        this(b,1,1);
    }
    
    Combatant(Build b, double prep) 
    {
        this(b,prep,1);
    }

    Combatant(Build b, double prep, double sustain) 
    {
        this.wrappedBuild = b;
    }
    
    public Build getBuild()
    {
        return this.wrappedBuild;
    }

    Iterable<AbilityUse> getAbilitiesAgainst(List<Combatant> enemies) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCurrentHP() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
