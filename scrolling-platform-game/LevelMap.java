/**
 * This class contains arrays that map out what tile objects exist in the game level.
 * 
 * @author R. Gordon
 * @version May 8, 2019
 */
public class LevelMap  
{
    /**
     * These variables can be used anywhere in the world below. 
     */    
    // Types of tiles in the world
    public static final String TILE_GROUND = "ground";
    public static final String TILE_METAL_PLATE = "metal plate";

    // Count of tiles in the world
    public static final int COUNT_OF_TILES = 40;

    // Where the tiles exist in the wider scrolling world and what type they are
    public int tileX[];
    public int tileY[];
    public String tileType[];
    public boolean tileHasBeenAddedToWorld[];

    /**
     * Constructor for objects of class LevelMap
     */
    public LevelMap()
    {
        // Initialize arrays based on how many tiles are going to be placed in scrollable world
        tileX = new int[COUNT_OF_TILES];
        tileY = new int[COUNT_OF_TILES];
        tileType = new String[COUNT_OF_TILES];
        tileHasBeenAddedToWorld = new boolean[COUNT_OF_TILES];

        // Set values for arrays to track what tiles are where in the scrollable world
        
        // Make a series of steps
        for (int i = 0; i < 10; i += 1)
        {
            tileX[0 + i * 4] = 640 + 32 + 32 * i + i * 64;
            tileY[0 + i * 4] = 432 - i * 32;
            tileType[0 + i * 4] = TILE_METAL_PLATE;
            tileHasBeenAddedToWorld[0 + i * 4] = false;
            
            tileX[1 + i * 4] = 640 + 32 + 32 * i + 16 + i * 64;
            tileY[1 + i * 4] = 432 - i * 32;
            tileType[1 + i * 4] = TILE_METAL_PLATE;
            tileHasBeenAddedToWorld[1 + i * 4] = false;
            
            tileX[2 + i * 4] = 640 + 32 + 32 * i + 32 + i * 64;
            tileY[2 + i * 4] = 432 - i * 32;
            tileType[2 + i * 4] = TILE_METAL_PLATE;
            tileHasBeenAddedToWorld[2 + i * 4] = false;
            
            tileX[3 + i * 4] = 640 + 32 + 32 * i + 48 + i * 64;
            tileY[3 + i * 4] = 432 - i * 32;
            tileType[3 + i * 4] = TILE_METAL_PLATE;
            tileHasBeenAddedToWorld[3 + i * 4] = false;
        }
    }

}
