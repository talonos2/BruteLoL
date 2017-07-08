package brutelol.charbuild;

/**
 * A build is a collection of items put into a character to be ready to evaluate. We'll later
 * create a "BuildPath" that represents how to get to a build.
 * @author Talonos
 */
public class Build 
{
    private double utility = 0;
    private ItemSet items;
    private int time;
    private int level;
    
    private StringBuilder notes;
    
    public Build(ItemSet items)
    {
        this.items = items;
    }
    
    public ItemSet getItems()
    {
        return items;
    }
    
    public int getTime()
    {
        return time;
    }
    
    public int getLevel()
    {
        return level;
    }
}
