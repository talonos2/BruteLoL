package brutelol.characters.lib;

/**
 * A targeted heuristic component is like a heuristic component, but represents
 * something we do to a target.
 * 
 * @author Emily
 */
public enum TargetedHeuristicComponent 
{
    DAMAGE_PER_AA_TO_TARGET,
    LIFE_STOLEN_FROM_TARGET_PER_ATTACK,
    LIFE_STOLEN_FROM_TARGET_PER_SECOND,
    DAMAGE_PER_SECOND_TO_TARGET,
    TARGET_ARMOR_DAMAGE_MULTIPLIER,
    TARGET_MAGIC_RESIST_DAMAGE_MULTIPLIER,
    BURST_DAMAGE_TO_TARGET, 
    KITING_DAMAGE_PER_SECOND_AGAINST_TARGET, 
    TIME_SURVIVING_AGAINST_TARGET, 
    MAGIC_BURST_HP_VS_TARGET, 
    PHYSICAL_BURST_HP_VS_TARGET, 
    POKE_DAMAGE_VS_TARGET;

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
