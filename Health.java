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
    public static Stack<Integer> life = new Stack<Integer>();
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
        if(life.isEmpty())
        {
            Greenfoot.setWorld(new EndScreen());
        }
    }
}
