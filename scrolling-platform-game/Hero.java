import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

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
    private int speed = 4;

    // Vertical speed
    private int vSpeed = 4;

    // Accelaration for falls
    private int acceleration = 2;

    // Strength of a jump
    private int jumpStrength = -24;

    // Track current theoretical position in wider "scrollable" world
    private int currentX;
    
    // Track position in prior animation frame in wider "scrollable" world
    private int priorX;
    
    // Track whether game is over or not
    private boolean isGameOver;
    
    /**
     * Constructor
     * 
     * This runs once when the Hero object is created.
     */
    Hero(int startingX)
    {
        // Set where hero begins horizontally
        currentX = startingX;
        
        // Last known horizontal position is same as starting position when hero is created
        priorX = currentX;
        
        // Game on
        isGameOver = false;
    }

    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeys();
        checkFall();
        if (!isGameOver)
        {
            checkGameOver();
        }
    }

    /**
     * Respond to keyboard action from the user.
     */
    private void checkKeys()
    {
        if (Greenfoot.isKeyDown("left") && !isGameOver)
        {
            setImage("hero-left.png");
            moveLeft();
        }
        if (Greenfoot.isKeyDown("right") && !isGameOver)
        {
            setImage("hero-right.png");
            moveRight();
        }
        if (Greenfoot.isKeyDown("space") && !isGameOver)
        {
            // Only able to jump when on a solid object
            if (onTile())
            {
                jump();
            }
        }
    }

    /**
     * Should the hero be falling right now?
     */
    public void checkFall()
    {
        if (onTile())
        {
            vSpeed = 0;

            // Get an reference to any object that's created from a subclass of Tile,
            // that is below the hero, if one exists
            Actor under = getOneObjectAtOffset(0, getImage().getHeight() / 2, Tile.class);

            // Bump the hero back up so that they are not "submerged" in tile
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
     * Is the hero currently touching a solid object?
     */
    public boolean onTile()
    {
        // Get an reference to a solid object (subclass of Tile) below the hero, if one exists
        Actor under = getOneObjectAtOffset(0, getImage().getHeight() / 2, Tile.class);

        // If there is no solid object below the hero, 'under' is null
        if (under == null)
        {
            return false;   // Not on a solid object
        }
        else
        {
            return true;
        }
    }

    /**
     * Make the hero jump.
     */
    public void jump()
    {
        vSpeed = jumpStrength;
        fall();
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
        // Get object reference to world
        SideScrollingWorld world = (SideScrollingWorld) getWorld(); 

        // Decide whether to actually move, or make world's tiles move
        if (currentX < world.getHalfVisibleWidth())
        {
            setLocation(getX() + speed, getY());
            currentX = getX();
        }
        else
        {
            // Track position in wider scrolling world
            currentX = currentX + speed;
            
            // Make sure any tiles just outside of right edge of camera space are added before we "arrive"
            world.checkAddTiles(currentX, speed);
            
            // Get a list of all tiles (objects that need to move
            // to make hero look like they are moving)
            List<Tile> tiles = world.getObjects(Tile.class);
            
            // Move all the tile objects
            for (Tile tile : tiles)
            {
                // Tiles move left to make hero appear to move right
                tile.moveLeft(speed);
            }
        }   
    }

    /**
     * Move the hero to the left.
     */
    public void moveLeft()
    {
        // Get object reference to world
        SideScrollingWorld world = (SideScrollingWorld) getWorld(); 

        // Decide whether to actually move, or make world's tiles move
        if (currentX - speed < world.getHalfVisibleWidth())
        {
            setLocation(getX() - speed, getY());
            currentX = getX();
        }
        else
        {
            // Track position in wider scrolling world
            currentX = currentX - speed;
            
            // Get a list of all tiles (objects that need to move
            // to make hero look like they are moving)
            List<Tile> tiles = world.getObjects(Tile.class);
            
            // Move all the tile objects
            for (Tile tile : tiles)
            {
                // Tiles move right to make hero appear to move right
                tile.moveRight(speed);
            }            
        }   
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
            isGameOver = true;
            world.setGameOver();
            world.removeObject(this);

            // Tell the user game is over
            world.showText("GAME OVER", world.getWidth() / 2, world.getHeight() / 2);
        }
    }
}
