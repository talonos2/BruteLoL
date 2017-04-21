package brutelol.characters.lib;

/**
 * A heuristic component is an enum representing something that we might want to
 * calculate regarding a character. Not all characters support all components, and
 * some (Stance cooldown, for instance) are pretty much unique.
 * 
 * @author Emily
 */
public enum HeuristicComponent 
{
    BONUS_ATTACK_DAMAGE_STAT,              //Bonus (not base) AD. Used on some ability calculations
    BASE_PHYSICAL_DAMAGE_PER_ATTACK,       //Raw physical damage per AA
    BONUS_PHYSICAL_DAMAGE_PER_ATTACK,      //Extra raw physical damage from effects.
    MAGIC_DAMAGE_PER_ATTACK,               //Extra raw magic damage from effects
    RAW_TOTAL_DAMAGE_PER_ATTACK,           //Total damage dealt to unarmored target/AA
    ATTACKS_PER_SECOND,                    //Attacks per second.
    RAW_DAMAGE_PER_SECOND,                 //Raw damage per second
    RAW_KITING_DAMAGE_PER_SECOND,          //I'm chasing you down... without stutter stepping
    LIFE_STOLEN_PER_ATTACK,                //Raw Life Stolen Per Second
    HEALING_PER_SECOND,                    //Heal/sec, definition of "heal" varies.
    RAW_PHYSICAL_BURST_DAMAGE,             //Physical damage dealt in a "long" combo
    RAW_MAGICAL_BURST_DAMAGE,              //Magical damage dealt in a "long" combo
    RAW_BURST_DAMAGE,                      //Total raw damage dealt in a "long" combo
    RAW_PHYSICAL_POKE_DAMAGE,              //Physical damage dealt in a "short" combo
    RAW_MAGICAL_POKE_DAMAGE,               //Magical damage dealt in a "short" combo
    RAW_POKE_DAMAGE,                       //Total raw damage dealt in a "short" combo
    COST,                                  //Cost of the Build
    
    ARMOR_DAMAGE_MULTIPLIER,
    RESIST_DAMAGE_MULTIPLIER;

    public String getName() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getBoldPostfix() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getNotBoldPostfix() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
