import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass for enemies to be based off of.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act() 
    {
        
    }
    /**
     * Method to allow balloons track monkey movement and follow the monkey
     */
    public void trackMonkey()
    {
        if (getWorld().getObjects(Player.class).isEmpty()) return;
        Actor player = (Actor)getWorld().getObjects(Player.class).get(0);
        turnTowards(player.getX(), player.getY());
    }
}
