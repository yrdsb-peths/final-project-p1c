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
    Button hiScoB; //Button for high score page
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1);
        Label start = new Label("Start Playing!", 75);
        start.setLineColor(Color.CYAN);
        Label shop = new Label("Shop!", 50);
        shop.setLineColor(Color.MAGENTA);
        Label info = new Label("Instructions!", 50);
        info.setLineColor(Color.ORANGE);
        Label hiScore = new Label("Highest Waves!", 40);
        hiScore.setLineColor(Color.WHITE);
        hiScore.setFillColor(Color.BLACK);
        addObject(shop, 400, 430);
        addObject(start, 600, 270);
        addObject(info, 800, 430);
        addObject(hiScore, 600, 570);

        Label space = new Label("<space>", 65);
        Label s = new Label("<S>", 65);
        Label i = new Label("<I>", 65);
        Label h = new Label("<H>", 65);
        addObject(space, 600, 350);
        addObject(s, 400, 500);
        addObject(i, 800, 500);
        addObject(h, 600, 630);

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

        hiScoB = new Button();
        addObject(hiScoB, 600, 630);
    }

    public void act()
    {
        worldCheck();
    }

    public void worldCheck()
    {
        if(startB.touchingCursor()  || Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new GameWorld());
        }
        if(shopB.touchingCursor() || Greenfoot.isKeyDown("S"))
        {
            Greenfoot.setWorld(new ShopWorld());
        }
        if(infoB.touchingCursor() || Greenfoot.isKeyDown("I"))
        {
            Greenfoot.setWorld(new InfoWorld());
        }
        if(hiScoB.touchingCursor() || Greenfoot.isKeyDown("H"))
        {
            Greenfoot.setWorld(new HighScoresScreen());
        }
    }
}