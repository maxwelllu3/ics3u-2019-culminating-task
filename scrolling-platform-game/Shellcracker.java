import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shellcracker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shellcracker extends Decoration
{
    /**
     * Constructor
     * 
     * Called once when object is created.
     */
    Shellcracker(int scrollableWorldX, int scrollableWorldY)
    {
        super(scrollableWorldX, scrollableWorldY);
    }    
    
    /**
     * Act - do whatever the Shellcracker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (isTouching(Sonic.class))
        {
            removeTouching(Sonic.class);
            SonicWorld world = (SonicWorld) getWorld(); 
            world.showText("GAME OVER", world.getWidth() / 2, world.getHeight() / 2);
        }
    }    
}
