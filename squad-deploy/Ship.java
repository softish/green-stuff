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
    public boolean carrying;
    private int carryOffsetX;
    private int carryOffsetY;
    
    public Ship()
    {
        landed = false;
        tilt = "no";
        carrying = false;
        carryOffsetX = 29;
        carryOffsetY = 12;
        speed = 3;
        getImage().mirrorHorizontally();
        scaleImage(getImage(), 3);
    }

    @Override
    public void act() 
    {
        keyInput();
//         if(!carrying)
//         {
//             spawnCarry();
//         }
        if(carrying)
        {
            carry();
        }
        
    }
    
    private boolean withinRange()
    {
        if(getRotation() > maxAngle || getRotation() < minAngle)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Check if ship is touching ground
     */
    private boolean touchGround()
    {
        if(isTouching(Ground.class))
        {
            return true;
        }
        return false;
    }
    
    // must have that vector, one direction of ship one of movement
    // decellerate, return angle to 0 deg and so on
    
    /**
     * Makes automated landing sequence
     */
    private boolean landing()
    {
//         int i = 0;
//         if(!touchGround())
//         {
//             while(i < (getWorld().getHeight() - 100))
//             {
//                 setLocation(getX(), getY()+i);
//                 i++;
//             }
//         }
        return false;
    }
    
    private void land()
    {
        if(!touchGround())
        {
            setLocation(getX(), getY()+1);
        }
        else
        {
            landed = true;
        }
    }
    
    private void liftoff()
    {
        //if(touchGround())
        if(getY() > (getWorld().getHeight() / 4)*3)
        {
            setLocation(getX(), getY()-1);
            
        }
        else
        {
            landed = false;
        }
    }
    
    /**
     * 
     * @Param what to carry
     */
    private void spawnCarry() // Rename
    {
        getWorld().addObject(new Rover(), getX(), getY());
        carrying = true;
    }
    
    // makes goods follow
    // TODO: follow ship tail aswell as the ship use an interect method and make pixels track??
    // TODO: make carrying visible before "play is pressed", that is make level check the carrying var here
    private void carry()
    {
        Rover rover = (Rover) getOneIntersectingObject(Rover.class);
        rover.setLocation(getX() - carryOffsetX, getY() + carryOffsetY);
        rover.setRotation(getRotation());
    }
    
    private void detachGoods()
    {
        carrying = false;
    }
    
    private void attachGoods()
    {
        if(isTouching(Rover.class))
        {
            carry();
            carrying = true;
        }
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
        
        if(Greenfoot.isKeyDown("space"))
        {
            detachGoods();
        }
        
        // have to press button again to change state...
        if(Greenfoot.isKeyDown("shift"))
        {
            landing();
        }
        
        if(Greenfoot.isKeyDown("e"))
        {
            //if(landed)
            {
                liftoff();
            }
        }
        if(Greenfoot.isKeyDown("q"))
        {
            //if(!landed)
            {
                land();
            }
        }
        
        // DEV purpose
        if(Greenfoot.isKeyDown("1"))
        {
            if(!carrying)
            {
                spawnCarry();
            }
        }
        if(Greenfoot.isKeyDown("2"))
        {
            if(!carrying)
            {
                attachGoods();
            }
        }
    }
}
