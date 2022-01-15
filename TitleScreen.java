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
        
        MenuMonkey ape1 = new MenuMonkey(3);
        addObject(ape1, 150,150);
        MenuMonkey ape2 = new MenuMonkey(-3);
        addObject(ape2, 1050,150);
        MenuMonkey ape3 = new MenuMonkey(-3);
        addObject(ape3, 150,550);
        MenuMonkey ape4 = new MenuMonkey(3);
        addObject(ape4, 1050,550);
        
        MenuNut nut1 = new MenuNut(10);
        addObject(nut1, 600,50);
        MenuNut nut2 = new MenuNut(-10);
        addObject(nut2, 600,650);
        MenuNut nut3 = new MenuNut(10);
        addObject(nut3, 100,330);
        MenuNut nut4 = new MenuNut(-10);
        addObject(nut4, 1100,370);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new GameWorld());
        }
        if(Greenfoot.isKeyDown("S"))
        {
            Greenfoot.setWorld(new ShopWorld());
        }
    }
}