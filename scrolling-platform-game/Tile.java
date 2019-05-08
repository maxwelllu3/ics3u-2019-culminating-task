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

    // Get hero object reference
    Hero theHero;
    
    /**
     * Constructor
     * 
     * This runs once.
     */
    Tile()
    {
        world = (SideScrollingWorld) getWorld();
        theHero = world.getHero();
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
    private void moveLeft()
    {
        // Move left if hero needs to move right
        if (theHero.needsScrollToMove() && theHero.needsToMoveRight())
        {
            setLocation(getX() - theHero.getSpeed(), getY());
        }
    }

    /**
     * Move to right (to make hero look like they are moving left)
     */
    private void moveRight()
    {
        // Move right if hero needs to move left
        if (theHero.needsScrollToMove() && theHero.needsToMoveLeft())
        {
            setLocation(getX() + theHero.getSpeed(), getY());
        }
    }

}
