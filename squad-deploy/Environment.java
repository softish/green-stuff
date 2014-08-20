import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Environment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Environment extends Actor
{
    /**
     * Scale image by a factor
     * 
     * @param image the image to scale
     * @param factor the amount to scale != 0
     */
    public GreenfootImage scaleImage(GreenfootImage image, int factor)
    {
        int width = getImage().getWidth();
        int height = getImage().getHeight();
        image.scale(width / factor, height / factor);
        return image;
    }
}
