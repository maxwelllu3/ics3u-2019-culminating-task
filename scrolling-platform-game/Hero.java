import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the class for the "main character" in the action.
 * 
 * @author R. Gordon
 * @version May 8, 2019
 */
public class Hero extends Actor
{
    /**
     * Instance variables
     * 
     * These are available for use in any method below.
     */    
    // Horizontal speed
    private int speed = 7;

    // Vertical speed
    private int vSpeed = 5;

    // Accelaration for falls
    private int acceleration = 2;

    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeys();
        checkFall();
        checkGameOver();
    }

    /**
     * Respond to keyboard action from the user.
     */
    private void checkKeys()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            setImage("hero-left.png");
            moveLeft();
        }
        if (Greenfoot.isKeyDown("right"))
        {
            setImage("hero-right.png");
            moveRight();
        }
    }

    /**
     * Should the hero be falling right now?
     */
    public void checkFall()
    {
        if (onGround())
        {
            vSpeed = 0;

            // Get an reference to a ground object below the hero, if one exists
            Actor under = getOneObjectAtOffset(0, getImage().getHeight() / 2, Ground.class);

            // Bump the hero back up so that they are not "submerged" in ground
            if (under != null)
            {
                int correctedYPosition = under.getY() - under.getImage().getHeight() / 2 - this.getImage().getHeight() / 2;
                setLocation(getX(), correctedYPosition);
            }
        }
        else
        {
            fall();
        }
    }

    /**
     * Is the hero currently touching the ground?
     */
    public boolean onGround()
    {
        // Get an reference to a ground object below the hero, if one exists
        Actor under = getOneObjectAtOffset(0, getImage().getHeight() / 2, Ground.class);

        // If there is no object of type Ground below the hero, 'under' is null
        if (under == null)
        {
            return false;   // Not on the ground
        }
        else
        {
            return true;
        }
    }

    /**
     * Make the hero fall.
     */
    public void fall()
    {
        // Fall
        setLocation(getX(), getY() + vSpeed);

        // Accelerate (fall faster next time)
        vSpeed = vSpeed + acceleration;
    }

    /**
     * Move the hero to the right.
     */
    public void moveRight()
    {
        setLocation(getX() + speed, getY());
    }

    /**
     * Move the hero to the left.
     */
    public void moveLeft()
    {
        setLocation(getX() - speed, getY());
    }

    /**
     * When the hero falls off the bottom of the screen,
     * game is over. We must remove them.
     */
    public void checkGameOver()
    {
        // Get object reference to world
        SideScrollingWorld world = (SideScrollingWorld) getWorld(); 

        // Vertical position where hero no longer visible
        int offScreenVerticalPosition = (world.getHeight() + this.getImage().getHeight() / 2);

        // Off bottom of screen?
        if (this.getY() > offScreenVerticalPosition)
        {
            // Remove the hero
            world.removeObject(this);

            // Tell the user game is over
            world.showText("GAME OVER", world.getWidth() / 2, world.getHeight() / 2);
        }
    }
}
