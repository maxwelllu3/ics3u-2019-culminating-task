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

    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeys();
        fall();
    }

    /**
     * Respond to keyboard action from the user.
     */
    private void checkKeys()
    {
        if (Greenfoot.isKeyDown("left")) {
            setImage("hero-left.png");
            moveLeft();
        }
        if (Greenfoot.isKeyDown("right")) {
            setImage("hero-right.png");
            moveRight();
        }
    }
    
    /**
     * Make the hero fall.
     */
    public void fall()
    {
        setLocation(getX(), getY() + vSpeed);
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

}
