import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LandingGear here.
 * 
 * @author softhish
 * @version aug 2014
 */
public class LandingGear extends Mover
{
    private boolean landingGearUp;
    public static int landingGearOffset;
    
    /**
     * Creates front and back landing gear of player's ship
     * 
     * @param up if the gear is deactivated or not
     */
    public LandingGear()
    {
        landingGearUp = true;
        landingGearOffset = 0;

        getImage().mirrorHorizontally();
        scaleImage(getImage(), 3);
    }
    
    @Override
    public void act() 
    {
        // Add your action code here.
    }
    
    /**
     * Follows the ship
     */
    public void followShip(int x, int y)
    {
        setLocation(x, y);
        setRotation(getRotation() + landingGearOffset);
    }
    
    /**
     * Inverts state of landing gear
     */
    public void lowerLandingGear()
    {
        if(landingGearUp)
        {
            landingGearOffset++;
        }
        if(!landingGearUp)
        {
            landingGearOffset--;
        }
    }
}
