import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Iterator;

/**
 * A class to store a stack for health.
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
        // Values pushed are based on the armour that the
        // player currently has unlocked
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
        
        for(int i = 1; i <= loop; i++) // Loop pushes specific numbers into stack
        {
            life.push(i);
        }
    }
    /**
     * The method to clear all life points and kill the player
     */
    public static void die()
    {
        life.clear();
    }
}
