/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol;

/**
 *
 * @author Talonos
 */
public class Funcs 
{
    public static int getLevelFromXP(int xp) 
    {
        if (xp<280) return 1;
        if (xp<670) return 2;
        if (xp<1170) return 3;
        if (xp<1780) return 4;
        if (xp<2500) return 5;
        if (xp<3330) return 6;
        if (xp<4270) return 7;
        if (xp<5320) return 8;
        if (xp<6480) return 9;
        if (xp<7750) return 10;
        if (xp<9130) return 11;
        if (xp<10620) return 12;
        if (xp<12220) return 13;
        if (xp<13930) return 14;
        if (xp<15750) return 15;
        if (xp<17680) return 16;
        if (xp<19720) return 17;
        return 18;
    }
}
