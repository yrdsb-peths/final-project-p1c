import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Visuals for main menu
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuNut extends Bullet
{
    int spinVal;
    /**
     * Construtor that sets spinVal variable for the act method to use
     */
    public MenuNut(int spinning)
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
        updateCoconutImage();
    }
}
