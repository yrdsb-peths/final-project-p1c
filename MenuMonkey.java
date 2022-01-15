import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuMonkey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuMonkey extends Player
{
    int spinVal;    
    public MenuMonkey(int spinning)
    {
        spinVal = spinning;
    }

    /**
     * Act - do whatever the MenuMonkey wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        turn(spinVal);
        updateMonkey();
    }
}

