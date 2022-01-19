import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Button startB; //Button for start game
    Button infoB; //Button for instructions page
    Button shopB; //Button for shop page
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1);
        Label start = new Label("Start Playing!", 75);
        Label shop = new Label("Shop!", 50);
        Label info = new Label("Instructions!", 50);
        addObject(shop, 400, 430);
        addObject(start, 600, 270);
        addObject(info, 800, 430);
        
        Label space = new Label("<space>", 65);
        Label s = new Label("<S>", 65);
        Label i = new Label("<I>", 65);
        addObject(space, 600, 350);
        addObject(s, 400, 500);
        addObject(i, 800, 500);
        
        MenuMonkey ape1 = new MenuMonkey(3);
        addObject(ape1, 150,200);
        MenuMonkey ape2 = new MenuMonkey(-3);
        addObject(ape2, 1050,200);
        MenuMonkey ape3 = new MenuMonkey(-3);
        addObject(ape3, 150,550);
        MenuMonkey ape4 = new MenuMonkey(3);
        addObject(ape4, 1050,550);
        
        MenuNut nut1 = new MenuNut(-10);
        addObject(nut1, 400,650);
        MenuNut nut2 = new MenuNut(10);
        addObject(nut2, 800,650);
        MenuNut nut3 = new MenuNut(10);
        addObject(nut3, 100,350);
        MenuNut nut4 = new MenuNut(-10);
        addObject(nut4, 1100,350);
        
        startB = new Button();
        addObject(startB,600,350);
        
        shopB = new Button();
        addObject(shopB, 400, 500);
        
        infoB = new Button();
        addObject(infoB, 800, 500);
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
        if(Greenfoot.isKeyDown("I"))
        {
            Greenfoot.setWorld(new InfoWorld());
        }
        if(Greenfoot.isKeyDown("H")){
            Greenfoot.setWorld(new HighScoresScreen());
        }
        buttonCheck();
    }
    
    public void buttonCheck()
    {
        if(startB.touchingCursor())
        {
            Greenfoot.setWorld(new GameWorld());
        }
        if(shopB.touchingCursor())
        {
            Greenfoot.setWorld(new ShopWorld());
        }
        if(infoB.touchingCursor())
        {
            Greenfoot.setWorld(new InfoWorld());
        }
    }
}