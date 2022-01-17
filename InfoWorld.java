import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InfoWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InfoWorld extends World
{

    /**
     * Constructor for objects of class InfoWorld.
     * 
     */
    public InfoWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
    }
    public void act(){
        if(Greenfoot.isKeyDown("B"))
        {
            Greenfoot.setWorld(new TitleScreen());
        }
    }
}
