import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author softhish
 * @version aug 2014
 */
public class Rock extends Environment
{
    /**
     * Defining properties for Rock
     */
    public Rock()
    {
        scaleImage(getImage(), Greenfoot.getRandomNumber(15)+7);
    }
}
