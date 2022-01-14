import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1);
        Label start = new Label("Start", 85);
        Label spacebar = new Label("Hit spacebar to begin", 60);
        Label shop = new Label("Hit S to open the shop", 60);
        addObject(shop, 600, 450);
        addObject(start, 600, 250);
        addObject(spacebar, 600, 350);
    }
    public void act(){
        if(Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new MyWorld());
        }
        if(Greenfoot.isKeyDown("S"))
        {
            Greenfoot.setWorld(new ShopWorld());
        }
    }
}