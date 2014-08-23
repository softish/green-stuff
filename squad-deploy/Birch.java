import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Birch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Birch extends Tree
{
     /**
     * Defining Tree properties
     * 
     * @param mirror if true, flip else not
     * @param size is how much to scale down original image
     */
    public Birch(boolean mirror, int size)
    {
        scaleImage(getImage(), size);
        
        if(mirror)
        {
            getImage().mirrorHorizontally();
        }
        
    }
}
