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
    public static final int COUNT_OF_TILES = 1;
    
    // Where the tiles exist in the wider scrolling world and what type they are
    public int tileX[];
    public int tileY[];
    public String tileType[];

    /**
     * Constructor for objects of class LevelMap
     */
    public LevelMap()
    {
        // Initialize arrays based on how many tiles are going to be placed in scrollable world
        tileX = new int[COUNT_OF_TILES];
        tileY = new int[COUNT_OF_TILES];
        tileType = new String[COUNT_OF_TILES];
        
        // Set values for arrays to track what tiles are where in the scrollable world
        tileX[0] = 688;
        tileY[0] = 464;
        tileType[0] = TILE_METAL_PLATE;
    }


}
