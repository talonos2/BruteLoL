package brutelol.buildobjs;

/**
 *
 * @author Talonos
 */
public class Build 
{
    private double utility = 0;
    
    private ItemSet items;
    
    public Build(double utility, ItemSet items)
    {
        this.items = items;
        this.utility = utility;
    }

    public double getUtility() 
    {
        return utility;
    }
    
    public ItemSet getItems()
    {
        return items;
    }
    
}
