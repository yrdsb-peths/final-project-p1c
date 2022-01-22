import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Iterator;

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
    /**
     * Stack to hold life points
     */
    public static Stack<Integer> life = new Stack<Integer>();
    /**
     * Constructor for objects of class Health.
     */
    public Health()
    {
        int loop = 0;
        if(Player.armourNum == 1)
        {
            loop = 5;
        }
        else if(Player.armourNum == 2)
        {
            loop = 7;
        }
        else if(Player.armourNum == 3)
        {
            loop = 10;
        }
        
        for(int i = 1; i <= loop; i++)
        {
            life.push(i);
        }
    }
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    /**
     * The method to clear all life points and kill the player
     */
    public static void die()
    {
        life.clear();
    }
}
