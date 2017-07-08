package brutelol.characters.instances.abilities;

import brutelol.characters.lib.BuildStats;
import brutelol.fights.Ability;
import brutelol.fights.Combatant;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Talonos
 */
public class AblAutoAttack extends Ability
{

    @Override
    public void resolve(Combatant user, List<Combatant> targets) 
    {
        //For now, just target whoever has the least health, I guess.  
        System.out.println(targets);
        Combatant target = Collections.min(targets, new HpComparator());
        
        double damage = getBasePhysicalDamagePerAttack(user);
        damage = this.applyArmor(damage, target);
        System.out.println(user+" deals "+damage+" damage to "+target);
    }
    
    double getCooldown(Combatant user) 
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
