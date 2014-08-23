import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level here.
 * 
 * @author softhish
 * @version aug 2014
 */
public class Level extends World
{

    /**
     * Constructor for objects of class Level.
     * 
     */
    public Level()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        
        setPaintOrder(Oak.class, LandingGear.class, Ship.class);
        
        //Dem duplication :S
        addObject(new Ship(), new Ship().getImage().getWidth() / 2, getHeight() / 2);
        addObject(new LandingGear(), new LandingGear().getImage().getWidth() / 2, getHeight() / 2);
        // NOGOOD: is there a better way than using "new" again
        
        drawEnvironment();
    }
    
    /**
     * Self explanatory
     */
    public void drawGround()
    {
        int blockWidth = new Ground().getImage().getWidth();
        for(int i = 0; i < getWidth(); i += blockWidth)
        {
            addObject(new Ground(), i, getHeight());
        }
    }
    
    /**
     * Makes up the level
     */
    public void drawEnvironment()
    {
        drawGround();
        
        addObject(new Oak(false, 9), 239, 491);
        addObject(new Birch(false, 10), 500, 514);
        addObject(new Birch(false, 10), 570, 514);
        addObject(new Rock(), 552, 562);
        addObject(new Rock(), 700, 562);
        addObject(new Small(false, 2), 552, 510);
        
    }
    
    // move to Environment class!
    /**
     * Lots of trees
     */
    public void makeForest(int width)
    {
        for(int i = 0; i < width; i++)
        {
            
        }
    }
}
