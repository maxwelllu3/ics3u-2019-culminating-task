import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Bullet extends Actor
{
    private int direction, speed;
    public Bullet(int dir)
    {
        direction = dir;
        speed = 15;
        setRotation(direction);
    }
    
    public void act()
    {
        move(speed);
        if (isTouching(Shellcracker.class))
        {
            removeTouching(Shellcracker.class);
            
        }
    }
}
