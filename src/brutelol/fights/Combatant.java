/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.fights;

import brutelol.characters.lib.AbstractLolCharacter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A combatant is a wrapper around a build, giving it a "State", etc.
 * @author Talonos
 */
public class Combatant 
{
    private AbstractLolCharacter wrappedChar;
    
    private Map<Ability,Double> cooldownMap = new HashMap<>();
    
    private double damageTaken;
    private double manaUsed;
    
    public Combatant(AbstractLolCharacter c)
    {
        this(c,1,1);
    }
    
    Combatant(AbstractLolCharacter c, double prep) 
    {
        this(c,prep,1);
    }

    Combatant(AbstractLolCharacter c, double prep, double sustain) 
    {
        this.wrappedChar = c;
        manaUsed = c.getStats().mana*(1.0-sustain);
        for (Ability a : this.wrappedChar.getAbilities())
        {
            cooldownMap.put(a, a.getCooldown(this)*(1-(prep*.95)));
        }
        
    }
    
    public AbstractLolCharacter getChar()
    {
        return this.wrappedChar;
    }

    List<AbilityUse> getAbilitiesAgainst(List<Combatant> enemies) 
    {
        List<AbilityUse> toReturn = new ArrayList<>();
        for (Ability a : this.wrappedChar.getAbilities())
        {
            toReturn.add(new AbilityUse(this,enemies,a));
        }
        return toReturn;
    }

    public double getCurrentHP() 
    {
        return wrappedChar.getStats().hp-damageTaken;
    }

    public double getArmor() 
    {
        return wrappedChar.getStats().armor;
    }

    public double getMagicResist() 
    {
        return wrappedChar.getStats().magicResist;
    }

    double getRemainingCooldownOn(Ability ability) 
    {
        return cooldownMap.get(ability);
    }
    
    @Override
    public String toString()
    {
        return wrappedChar.getName()+" ("+(int)getCurrentHP()+"/"+(int)wrappedChar.getStats().hp+")";
    }

    /**
     * Deals "Raw" damage; assumed to already be reduced, etc.
     * @param damage damage dealt.
     */
    public void dealDamage(double damage) 
    {
        this.damageTaken += damage;
    }

    public boolean isDead() 
    {
        return getCurrentHP()<=0;
    }
    
}
