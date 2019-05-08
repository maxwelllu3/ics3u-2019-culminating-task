import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Template for a side-scrolling platform game.
 * 
 * @author R. Gordon
 * @version May 8, 2019
 */
public class SideScrollingWorld extends World
{
    /**
     * Instance variables
     * 
     * These are available for use in any method below.
     */    
    // Tile size in pixels for world elements (blocks, clouds, etc)
    private static final int TILE_SIZE = 32;
    
    /**
     * Constructor for objects of class SideScrollingWorld.
     */
    public SideScrollingWorld()
    {    
        // Create a new world with 640x480 cells with a cell size of 1x1 pixels.
        // Final argument of 'false' means that actors in the world are not restricted to the world boundary.
        // See: https://www.greenfoot.org/files/javadoc/greenfoot/World.html#World-int-int-int-boolean-
        super(640, 480, 1, false);
        
        // Set up the starting scene
        setup();
    }
    
    /**
     * Set up the starting scene.
     */
    private void setup()
    {
        addHero();
        addGroundAtBottom();
    }
    
    /**
     * Add the hero to the world.
     */
    private void addHero()
    {
        // Make the hero
        Hero theHero = new Hero();
       
        // Add hero in bottom left corner of screen
        addObject(theHero, getWidth() - 5 * getWidth() / 6, getHeight() / 4 * 3);
    }
    
    
    /**
     * Add blocks to create the ground to walk on at bottom of screen.
     */
    private void addGroundAtBottom()
    {
        // How many tiles will cover the bottom of the screen?
        int tilesToCreate = getWidth() / TILE_SIZE;
        
        // Loop to create and add the tile objects
        for (int i = 0; i < tilesToCreate; i += 1)
        {
            // Add ground objects at bottom of screen
            // NOTE: Actors are added based on their centrepoint, so the math is a bit trickier.
            int x = i * TILE_SIZE + TILE_SIZE / 2;
            int y = getHeight() - TILE_SIZE / 2;
            
            // Create a ground tile
            Ground groundTile = new Ground();
            
            // Add the objects
            addObject(groundTile, x, y);
        }
    }
}








