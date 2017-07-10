package brutelol.characters.instances.abilities;

import brutelol.characters.lib.BuildStats;
import brutelol.fights.Ability;
import brutelol.fights.AbilityUse;
import brutelol.fights.Combatant;
import brutelol.fights.TimedFightEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class BasicAttack extends Ability
{

    @Override
    public List<TimedFightEvent> resolve(Combatant user, List<Combatant> targets) 
    {
        if (targets.isEmpty())
        {
            System.out.println(user+" has nothing left to attack!");
            return new ArrayList<>();
        }
        
        //For now, just target whoever has the least health, I guess.  
        Combatant target = Collections.min(targets, new HpComparator());
        
        //calculate basic attack damage;
        double rawPhysicalDamage = getBasePhysicalDamagePerAttack(user);
        
        //Apply on-hit physical effects;
        for (StatusEffect s : user.getStatusEffects())
        {
            rawPhysicalDamage += s.onHitPhysicalAddition(user, target);
        }
        
        //Apply Magical on-hit effects
        double magicDamage = 0;
        for (StatusEffect s : user.getStatusEffects())
        {
            magicDamage += s.onHitMagicAddition(target, target);
        }
        
        //Apply resists and sum damage
        double reducedPhysicaldamage = this.applyArmor(rawPhysicalDamage, target);
        double reducedMagicaldamage = this.applyMagicResist(magicDamage, target);
        double damage = reducedPhysicaldamage + reducedMagicaldamage;
        
        target.dealDamage(damage);
        System.out.println(user+" deals "+(int)damage+" damage to "+target);
        //Handle Retributive On-Hits.
        for (StatusEffect s : target.getStatusEffects())
        {
            s.doHitRetaliation(user, target, rawPhysicalDamage, 0);
        }
        //Kill target if dead
        if (target.isDead())
        {
            targets.remove(target);
        }
        List<TimedFightEvent> toReturn = new ArrayList<>();
        toReturn.add(new AbilityUse(user, targets, this));
        return toReturn;
    }
    
    @Override
    public double getCooldown(Combatant user) 
    {
        return getAACooldown(user);
    }
    
    public double getBasePhysicalDamagePerAttack(Combatant user) 
    {   
        BuildStats stats = user.getChar().getStats();
        double critChance = stats.critChance;
        double cappedCritChance = Math.min(critChance,1.0);
        
        //Calculate basic damage.
        double damagePerAttack = 0;
        damagePerAttack+=stats.attackDamage;
        
        //Amortize crit modifiers.
        double damageIncludingCrits = damagePerAttack+(damagePerAttack*cappedCritChance*(1+stats.addedCritDamage));
        
        return damageIncludingCrits;
    }
    
    private double getAACooldown(Combatant user)
    {
        return 1/getAttacksPerSecond(user);
    }

    private double getAttacksPerSecond(Combatant user) 
    {
        double attacksPerSecond = user.getChar().ATTACK_SPEED_AT_1;
        double addedAttackSpeed = user.getChar().getStats().attackSpeed;
        
        attacksPerSecond *= (1+addedAttackSpeed);
        if (attacksPerSecond > 2.5)
        {
            attacksPerSecond = 2.5;
        }
        return attacksPerSecond;
    }
    
    private class HpComparator implements Comparator<Combatant> 
    {
    
        @Override
        public int compare(Combatant first, Combatant second) 
        {
            if (first.getCurrentHP() > second.getCurrentHP())
                return 1;
            else if (first.getCurrentHP() < second.getCurrentHP())
                return -1;
            return 0;
        }
    }
}
