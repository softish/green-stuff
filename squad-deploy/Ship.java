import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author softhish
 * @version aug 2014
 */
public class Ship extends Mover
{
    private boolean landed;
    private static final int minAngle = 45;
    private static final int maxAngle = 315;
    private double acceleration;
    private int speed;
    private String tilt;
    private boolean bottomTilt; // to replace the tilt String
    private boolean topTilt;
    
    public Ship()
    {
        landed = false;
        tilt = "no";
        speed = 3;
        getImage().mirrorHorizontally();
        scaleImage(getImage(), 3);
    }

    @Override
    public void act() 
    {
        keyInput();
    }
    
    /**
     * Scale image by a factor
     * 
     * @param image the image to scale
     * @param factor the amount to scale != 0
     */
    private GreenfootImage scaleImage(GreenfootImage image, int factor)
    {
        int width = getImage().getWidth();
        int height = getImage().getHeight();
        image.scale(width / factor, height / factor);
        return image;
    }
    
    private boolean withinRange()
    {
        if(getRotation() > maxAngle || getRotation() < minAngle)
        {
            return true;
        }
        return false;
    }
    
    // NOGOOD: flies in some predefined directions...
    /**
     * 
     * prevents oversteering can't turn more than 45 deg up / down respectively
     */
    private void keyInput()
    {
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            move(speed);
        }
        if(Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s"))
        {
            if(withinRange() || tilt.equals("up"))
            {
                turn(1);
                if(getRotation() == 45)
                {
                    tilt = "down";
                }
            }
        }
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            move(-1);
        }
        if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w"))
        {
            if(withinRange() || tilt.equals("down"))
            {
                turn(-1);
                if(getRotation() == 315)
                {
                    tilt = "up";
                }
            }
        }
        
        if(Greenfoot.isKeyDown("shift"))
        {
            // land / liftoff
        }
    }
}
