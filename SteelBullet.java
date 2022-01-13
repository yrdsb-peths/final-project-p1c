import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SteelBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SteelBullet extends Actor
{
    /**
     * Act - do whatever the SteelBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(7);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        else if (isTouching(Enemy.class)){
            removeTouching(Enemy.class);
            getWorld().removeObject(this);
        }
    }
}
