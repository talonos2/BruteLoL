package brutelol.characters.instances;

import brutelol.characters.lib.AbstractLolCharacter;
import brutelol.characters.lib.BuildStats;;
import brutelol.charbuild.Build;
import java.util.ArrayList;
import java.util.List;

/**
 * This Generic Character represents an "Average" Lol character with no abilities, etc.
 * @author Talonos
 */
public class GenericChar extends AbstractLolCharacter 
{
    public GenericChar(Build b)
    {
        super(b);
        //Required items; lacking these will invalidate a build.
        //this.requiredItems.add(BerserkersGreaves.class);
        
        //Variables representing the starting state
        this.HP_AT_0 = 550;
        this.HP_REGEN_AT_0 = 6.676;
        this.MANA_AT_0 = 310;
        this.MANA_REGEN_AT_0 = 7;
        this.ATTACK_DAMAGE_AT_0 = 56;
        this.ARMOR_AT_0 = 24;
        this.MAGIC_RES_AT_0 = 32;
    
        //Attack speed is calculated different.
        this.ATTACK_SPEED_AT_1 = .638;

        //Variables representing the growth per level.
        this.HP_PER_LEVEL = 85;
        this.HP_REGEN_PER_LEVEL = .6;
        this.MANA_PER_LEVEL = 40;
        this.MANA_REGEN_PER_LEVEL = .65;
        this.ATTACK_DAMAGE_PER_LEVEL = 3.1;
        this.ATTACK_SPEED_PER_LEVEL = .025;
        this.ARMOR_PER_LEVEL = 3.5;
        this.MAGIC_RES_PER_LEVEL = .87;
        
        this.MOVE_SPEED = 335;
        this.RANGE = 175;
        
        this.stats = new BuildStats(this, b, null);

    }
    
    public String getName() 
    {
        return "Generic";
    }
}
