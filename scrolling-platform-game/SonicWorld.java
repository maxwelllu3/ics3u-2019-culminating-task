import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A side-scrolling platform game.
 * 
 * @author Maxwell B. Lu
 * @version May 16, 2019
 */
public class SonicWorld extends World
{
    /**
     * Instance variables
     * 
     * These are available for use in any method below.
     */    
    // Tile size in pixels for world elements (blocks, clouds, etc)
    // TO STUDENTS: Modify if your game's tiles have different dimensions
    private static final int TILE_SIZE = 32;
    private static final int HALF_TILE_SIZE = TILE_SIZE / 2;

    // World size constants
    // TO STUDENTS: Modify only if you're sure
    //              Should be a resolution that's a multiple of TILE_SIZE
    private static final int VISIBLE_WIDTH = 640;
    private static final int VISIBLE_HEIGHT = 480;

    // Additional useful constants based on world size
    public static final int HALF_VISIBLE_WIDTH = VISIBLE_WIDTH / 2;
    private static final int HALF_VISIBLE_HEIGHT = VISIBLE_HEIGHT / 2;

    // Defining the boundaries of the scrollable world
    // TO STUDENTS: Modify SCROLLABLE_WIDTH if you wish to have a longer level
    public static final int SCROLLABLE_WIDTH = VISIBLE_WIDTH * 3;
    private static final int SCROLLABLE_HEIGHT = VISIBLE_HEIGHT;

    // Sonic
    Sonic theSonic;

    // Track whether game is on
    private boolean isGameOver;
    /**
     * Constructor for objects of class SonicWorld.
     */
    public SonicWorld()
    {    
        // Create a new world with 640x480 cells with a cell size of 1x1 pixels.
        // Final argument of 'false' means that actors in the world are not restricted to the world boundary.
        // See: https://www.greenfoot.org/files/javadoc/greenfoot/World.html#World-int-int-int-boolean-
        super(VISIBLE_WIDTH, VISIBLE_HEIGHT, 1, false);

        // Set up the starting scene
        setup();

        // Game on
        isGameOver = false;
    }

    /**
     * Set up the entire world.
     */
    private void setup()
    {
        // TO STUDENTS: Add, revise, or remove methods as needed to define your own game's world
        // addLeftGround();
        //  addFences();
        //  addFloatingRockSteps();
        //  addClouds();
        //  addRightGround();
        addSonic();
        addShellcracker();
        for (int i = 0; i < 4; i += 1)
        {
            int x = 7 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 4 * TILE_SIZE + HALF_TILE_SIZE;
            FloatingRock floatingrock = new FloatingRock(x, y);
            addObject(floatingrock, x, y);
        }

        for (int i = 0; i < 17; i += 1)
        {
            int x = HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 14 * TILE_SIZE + HALF_TILE_SIZE;
            Ground ground = new Ground(x, y);
            addObject(ground, x, y);
        }

        for (int i = 0; i < 18; i += 1)
        {
            int x = 11 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 2 * TILE_SIZE + HALF_TILE_SIZE;
            FloatingRock floatingrock = new FloatingRock(x, y);
            addObject(floatingrock, x, y);
        }

        for (int i = 0; i < 4; i += 1)
        {
            int x = 17 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 11 * TILE_SIZE + HALF_TILE_SIZE;
            FloatingRock floatingrock = new FloatingRock(x, y);
            addObject(floatingrock, x, y);
        }

        for (int i = 0; i < 4; i += 1)
        {
            int x = 22 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 9 * TILE_SIZE + HALF_TILE_SIZE;
            FloatingRock floatingrock = new FloatingRock(x, y);
            addObject(floatingrock, x, y);
        }

        for (int i = 0; i < 9; i += 1)
        {
            int x = 12 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 6 * TILE_SIZE + HALF_TILE_SIZE;
            FloatingRock floatingrock = new FloatingRock(x, y);
            addObject(floatingrock, x, y);
        }

        for (int i = 0; i < 4; i += 1)
        {
            int x = 29 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 4 * TILE_SIZE + HALF_TILE_SIZE;
            FloatingRock floatingrock = new FloatingRock(x, y);
            addObject(floatingrock, x, y);
        }

        for (int i = 0; i < 4; i += 1)
        {
            int x = 33 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 6 * TILE_SIZE + HALF_TILE_SIZE;
            FloatingRock floatingrock = new FloatingRock(x, y);
            addObject(floatingrock, x, y);
        }

        for (int i = 0; i < 4; i += 1)
        {
            int x = 37 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 8 * TILE_SIZE + HALF_TILE_SIZE;
            FloatingRock floatingrock = new FloatingRock(x, y);
            addObject(floatingrock, x, y);
        }

        for (int i = 0; i < 4; i += 1)
        {
            int x = 33 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 10 * TILE_SIZE + HALF_TILE_SIZE;
            FloatingRock floatingrock = new FloatingRock(x, y);
            addObject(floatingrock, x, y);
        }

        for (int i = 0; i < 10; i += 1)
        {
            int x = 37 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 12 * TILE_SIZE + HALF_TILE_SIZE;
            FloatingRock floatingrock = new FloatingRock(x, y);
            addObject(floatingrock, x, y);
        }

        for (int i = 0; i < 4; i += 1)
        {
            int x = 47 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 10 * TILE_SIZE + HALF_TILE_SIZE;
            FloatingRock floatingrock = new FloatingRock(x, y);
            addObject(floatingrock, x, y);
        }

        for (int i = 0; i < 4; i += 1)
        {
            int x = 51 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 8 * TILE_SIZE + HALF_TILE_SIZE;
            FloatingRock floatingrock = new FloatingRock(x, y);
            addObject(floatingrock, x, y);
        }

        for (int i = 0; i < 5; i += 1)
        {
            int x = 56 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 6 * TILE_SIZE + HALF_TILE_SIZE;
            Ground ground = new Ground(x, y);
            addObject(ground, x, y);
        }

        for (int i = 0; i < 5; i += 1)
        {
            int x = 56 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 7 * TILE_SIZE + HALF_TILE_SIZE;
            GroundBelow groundbelow = new GroundBelow(x, y);
            addObject(groundbelow, x, y);
        }

        for (int i = 0; i < 5; i += 1)
        {
            int x = 56 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 8 * TILE_SIZE + HALF_TILE_SIZE;
            GroundBelow groundbelow = new GroundBelow(x, y);
            addObject(groundbelow, x, y);
        }

        for (int i = 0; i < 5; i += 1)
        {
            int x = 56 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 9 * TILE_SIZE + HALF_TILE_SIZE;
            GroundBelow groundbelow = new GroundBelow(x, y);
            addObject(groundbelow, x, y);
        }

        for (int i = 0; i < 5; i += 1)
        {
            int x = 56 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 10 * TILE_SIZE + HALF_TILE_SIZE;
            GroundBelow groundbelow = new GroundBelow(x, y);
            addObject(groundbelow, x, y);
        }

        for (int i = 0; i < 5; i += 1)
        {
            int x = 56 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 11 * TILE_SIZE + HALF_TILE_SIZE;
            GroundBelow groundbelow = new GroundBelow(x, y);
            addObject(groundbelow, x, y);
        }

        for (int i = 0; i < 5; i += 1)
        {
            int x = 56 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 12 * TILE_SIZE + HALF_TILE_SIZE;
            GroundBelow groundbelow = new GroundBelow(x, y);
            addObject(groundbelow, x, y);
        }

        for (int i = 0; i < 5; i += 1)
        {
            int x = 56 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 13 * TILE_SIZE + HALF_TILE_SIZE;
            GroundBelow groundbelow = new GroundBelow(x, y);
            addObject(groundbelow, x, y);
        }

        for (int i = 0; i < 5; i += 1)
        {
            int x = 56 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 14 * TILE_SIZE + HALF_TILE_SIZE;
            GroundBelow groundbelow = new GroundBelow(x, y);
            addObject(groundbelow, x, y);
        }

        for (int i = 0; i < 5; i += 1)
        {
            int x = 56 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 15 * TILE_SIZE + HALF_TILE_SIZE;
            GroundBelow groundbelow = new GroundBelow(x, y);
            addObject(groundbelow, x, y);
        }

    }

    /**
     * Act
     * 
     * This method is called approximately 60 times per second.
     */
    public void act()
    {

    }

    /**
     * Add the hero to the world.
     */
    private void addSonic()
    {
        // Initial horizontal position
        int initialX = TILE_SIZE * 3;

        // Instantiate the hero object
        theSonic = new Sonic(initialX);

        // Add hero in bottom left corner of screen
        addObject(theSonic, initialX, getHeight() / 4 * 2);
    }
    
    /**
     * Add the hero to the world.
     */
    private void addShellcracker()
    {

        Shellcracker theShellcracker = new Shellcracker();

        addObject(theShellcracker, 470, 415);
    }

    /**
     * Return an object reference to the hero.
     */
    public Sonic getSonic()
    {
        return theSonic;
    }

    public void started()
    {
        Greenfoot.playSound("music1.mp3");
    }

    /**
     * Set game over
     */
    public void setGameOver()
    {
        isGameOver = true;
    }
}

