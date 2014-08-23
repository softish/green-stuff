import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Oack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Oak extends Tree
{
    /**
     * Defining Tree properties
     * 
     * @param mirror if true, flip else not
     * @param size is how much to scale down original image
     */
    public Oak(boolean mirror, int size)
    {
        scaleImage(getImage(), size);
        
        if(mirror)
        {
            getImage().mirrorHorizontally();
        }
        
    }
}
