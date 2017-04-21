package brutelol;

/**
 * A container for useful static functions.
 * @author Talonos
 */
public class Funcs 
{
    /**
     * Given an XP amount, what level is the champion?
     * @param xp the XP the champion has.
     * @return the level of the champion.
     */
    public static int getLevelFromXP(int xp) 
    {
        
        //TODO: This is map dependant as of a few patches ago. :(
        if (xp<280) return 1;
        if (xp<660) return 2;
        if (xp<1140) return 3;
        if (xp<1720) return 4;
        if (xp<2400) return 5;
        if (xp<3180) return 6;
        if (xp<4060) return 7;
        if (xp<5040) return 8;
        if (xp<6120) return 9;
        if (xp<7300) return 10;
        if (xp<8580) return 11;
        if (xp<9960) return 12;
        if (xp<11440) return 13;
        if (xp<13020) return 14;
        if (xp<14700) return 15;
        if (xp<16480) return 16;
        if (xp<18360) return 17;
        return 18;
    }
}
