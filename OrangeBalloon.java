import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OrangeBalloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrangeBalloon extends Enemy
{
    /**
     * Act - do whatever the OrangeBalloon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        trackMonkey();
        move(5);
    }
}
