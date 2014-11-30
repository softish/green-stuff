import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tree here.
 * 
 * @author softhish
 * @version aug 2014
 */
public class Palm extends Tree
{
    /**
     * Defining Tree properties
     * 
     * @param mirror if true, flip else not
     * @param size is how much to scale down original image
     */
    public Palm(boolean mirror, int size)
    {
        scaleImage(getImage(), size);
        
        if(mirror)
        {
            getImage().mirrorHorizontally();
        }
        
    }
}
