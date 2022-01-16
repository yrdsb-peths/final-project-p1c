import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Iterator;

/**
 * Write a description of class RedBalloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedBalloon extends Enemy
{
    /**
     * Act - do whatever the RedBalloon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        trackMonkey();
        move(2);
        if (isTouching(Player.class)){
            Health.life.pop();
            getWorld().removeObject(this);
        }
    }
}
