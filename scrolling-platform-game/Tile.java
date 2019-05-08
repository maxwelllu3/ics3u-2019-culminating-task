import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Tile extends Actor
{
    /**
     * Instance variables
     * 
     * Can be used by any method below.
     */
    // Get object reference to world
    SideScrollingWorld world;

    /**
     * Constructor
     * 
     * This runs once.
     */
    Tile()
    {
    }

    /**
     * Act - do whatever the Tile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }

    /**
     * Move to left (to make hero look like they are moving right)
     */
    public void moveLeft(int speed)
    {
        setLocation(getX() - speed, getY());
    }

    /**
     * Move to right (to make hero look like they are moving left)
     */
    public void moveRight(int speed)
    {
        setLocation(getX() + speed, getY());
    }

}
