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
        
        addObject(new Ship(), new Ship().getImage().getWidth() / 2, getHeight() / 2);
        // NOGOOD: is there a better way than using "new" again
        drawGround();
    }
    
    public void drawGround()
    {
        int blockWidth = new Ground().getImage().getWidth();
        for(int i = 0; i < getWidth(); i += blockWidth)
        {
            addObject(new Ground(), i, getHeight());
        }
    }
}
