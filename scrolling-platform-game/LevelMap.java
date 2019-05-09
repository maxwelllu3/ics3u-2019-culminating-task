
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
    // Tile size in pixels for world elements (blocks, clouds, etc)
    private static final int TILE_SIZE = 32;

    // World size constants
    private static final int VISIBLE_WIDTH = 640;
    private static final int VISIBLE_HEIGHT = 480;
    public static final int HALF_VISIBLE_WIDTH = VISIBLE_WIDTH / 2;
    private static final int HALF_VISIBLE_HEIGHT = VISIBLE_HEIGHT / 2;
    private static final int SCROLLABLE_WIDTH = VISIBLE_WIDTH * 3;
    private static final int SCROLLABLE_HEIGHT = VISIBLE_HEIGHT;

    // Types of tiles in the world
    public static final String TILE_GROUND = "ground";
    public static final String TILE_GROUND_BELOW = "ground, below surface";
    public static final String TILE_METAL_PLATE = "metal plate";
    public static final String TILE_CLOUD = "a cloud";
    public static final String TILE_FENCE = "a fence";

    // Count of tile types in the world
    public static final int COUNT_OF_GROUND = 8;
    public static final int GROUND_BELOW_COLUMNS = COUNT_OF_GROUND;
    public static final int GROUND_BELOW_ROWS = 6;
    public static final int COUNT_OF_GROUND_BELOW = GROUND_BELOW_COLUMNS * GROUND_BELOW_ROWS;
    public static final int COUNT_OF_METAL_PLATES = 20;
    public static final int COUNT_OF_CLOUDS = 2;
    public static final int COUNT_OF_FENCES = 2;

    // Total count of tiles in world
    public static final int COUNT_OF_TILES = COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + COUNT_OF_GROUND_BELOW + COUNT_OF_CLOUDS + COUNT_OF_FENCES;

    // Where the tiles exist (in scrollable world position) and what type they are
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

        /*
         * Set values for arrays to track what tiles are where in the scrollable world
         */

        // 1. Make a series of steps
        for (int i = 0; i < COUNT_OF_METAL_PLATES / 4; i += 1)
        {
            tileX[0 + i * 4] = VISIBLE_WIDTH + TILE_SIZE * 2 + TILE_SIZE * i + TILE_SIZE * 5 * i;
            tileY[0 + i * 4] = VISIBLE_HEIGHT - TILE_SIZE / 2 * 3 - i * TILE_SIZE;
            tileType[0 + i * 4] = TILE_METAL_PLATE;
            tileHasBeenAddedToWorld[0 + i * 4] = false;

            tileX[1 + i * 4] = VISIBLE_WIDTH + TILE_SIZE * 2 + TILE_SIZE * (i + 1) + TILE_SIZE * 5 * i;
            tileY[1 + i * 4] = VISIBLE_HEIGHT - TILE_SIZE / 2 * 3 - i * TILE_SIZE;
            tileType[1 + i * 4] = TILE_METAL_PLATE;
            tileHasBeenAddedToWorld[1 + i * 4] = false;

            tileX[2 + i * 4] = VISIBLE_WIDTH + TILE_SIZE * 2 + TILE_SIZE * (i + 2) + TILE_SIZE * 5 * i;
            tileY[2 + i * 4] = VISIBLE_HEIGHT - TILE_SIZE / 2 * 3 - i * TILE_SIZE;
            tileType[2 + i * 4] = TILE_METAL_PLATE;
            tileHasBeenAddedToWorld[2 + i * 4] = false;

            tileX[3 + i * 4] = VISIBLE_WIDTH + TILE_SIZE * 2 + TILE_SIZE * (i + 3) + TILE_SIZE * 5 * i;
            tileY[3 + i * 4] = VISIBLE_HEIGHT - TILE_SIZE / 2 * 3 - i * TILE_SIZE;
            tileType[3 + i * 4] = TILE_METAL_PLATE;
            tileHasBeenAddedToWorld[3 + i * 4] = false;
        }

        // 2. Make ground at end of level
        for (int i = 0; i < COUNT_OF_GROUND; i += 1)
        {
            tileX[COUNT_OF_METAL_PLATES + i] = SCROLLABLE_WIDTH - TILE_SIZE / 2 - i * TILE_SIZE;
            tileY[COUNT_OF_METAL_PLATES + i] = VISIBLE_HEIGHT / 2 + TILE_SIZE;
            tileType[COUNT_OF_METAL_PLATES + i] = TILE_GROUND;
            tileHasBeenAddedToWorld[COUNT_OF_METAL_PLATES + i] = false;
        }

        // 3. Make sub-ground at end of level
        for (int i = 0; i < GROUND_BELOW_COLUMNS; i += 1)
        {
            for (int j = 0; j < GROUND_BELOW_ROWS; j += 1)
            {
                tileX[COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + GROUND_BELOW_COLUMNS * j + i] = SCROLLABLE_WIDTH - TILE_SIZE / 2 - i * TILE_SIZE;
                tileY[COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + GROUND_BELOW_COLUMNS * j + i] = VISIBLE_HEIGHT / 2 + TILE_SIZE + TILE_SIZE * (j + 1);
                tileType[COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + GROUND_BELOW_COLUMNS * j + i] = TILE_GROUND_BELOW;
                tileHasBeenAddedToWorld[COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + GROUND_BELOW_COLUMNS * j + i] = false;
            }
        }

        // 4. Add some clouds (objects that are not platforms, and move "in the distance" at a slower rate)
        tileX[COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + COUNT_OF_GROUND_BELOW + 0] = 675;
        tileY[COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + COUNT_OF_GROUND_BELOW + 0] = 50;
        tileType[COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + COUNT_OF_GROUND_BELOW + 0] = TILE_CLOUD;
        tileHasBeenAddedToWorld[COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + COUNT_OF_GROUND_BELOW + 0] = false;

        tileX[COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + COUNT_OF_GROUND_BELOW + 1] = 1300;
        tileY[COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + COUNT_OF_GROUND_BELOW + 1] = 100;
        tileType[COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + COUNT_OF_GROUND_BELOW + 1] = TILE_CLOUD;
        tileHasBeenAddedToWorld[COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + COUNT_OF_GROUND_BELOW + 1] = false;

        // 5. Add some fences (objects that are not platforms, but move in the foreground like platforms)
        tileX[COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + COUNT_OF_GROUND_BELOW + COUNT_OF_CLOUDS + 0] = SCROLLABLE_WIDTH - TILE_SIZE / 2 - TILE_SIZE * 3;
        tileY[COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + COUNT_OF_GROUND_BELOW + COUNT_OF_CLOUDS + 0] = VISIBLE_HEIGHT / 2;
        tileType[COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + COUNT_OF_GROUND_BELOW + COUNT_OF_CLOUDS + 0] = TILE_FENCE;
        tileHasBeenAddedToWorld[COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + COUNT_OF_GROUND_BELOW + COUNT_OF_CLOUDS + 0] = false;

        tileX[COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + COUNT_OF_GROUND_BELOW + COUNT_OF_CLOUDS + 1] = SCROLLABLE_WIDTH - TILE_SIZE / 2 - TILE_SIZE * 4;
        tileY[COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + COUNT_OF_GROUND_BELOW + COUNT_OF_CLOUDS + 1] = VISIBLE_HEIGHT / 2;
        tileType[COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + COUNT_OF_GROUND_BELOW + COUNT_OF_CLOUDS + 1] = TILE_FENCE;
        tileHasBeenAddedToWorld[COUNT_OF_METAL_PLATES + COUNT_OF_GROUND + COUNT_OF_GROUND_BELOW + COUNT_OF_CLOUDS + 1] = false;
    }

}
