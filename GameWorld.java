import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * The hub from which the player is able to select which world
 * they would like to try. The grassland, desert, and graveyard
 * levels are featured on screen for the player to select.
 * 
 * Aninda Saha, Conrad Mo 
 * Jan 22, 2022
 */
public class GameWorld extends World
{
    /**
     * Integer to select different worlds and to keep track of them
     */
    public static int world = 0;
    /**
     * Integer to keep track of wave number
     */
    public static int wave;

    // Create buttons respective to each selectable world
    Button wOne;
    Button wTwo;
    Button wThree;

    Label waveCount;
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 

        setPaintOrder(Button.class, Label.class); // Make Buttons be ontop of Labels

        // Create the three buttons and their respective Labels
        wOne = new Button();
        wTwo = new Button();
        wThree = new Button();
        Label one = new Label("World 1!", 75);
        one.setLineColor(Color.GREEN);
        one.setFillColor(Color.BLACK);
        Label two = new Label("World 2!", 75);
        two.setLineColor(Color.ORANGE);
        two.setFillColor(Color.BLACK);
        Label three = new Label("World 3!", 75);
        three.setLineColor(Color.RED);
        three.setFillColor(Color.BLACK);

        // Add objects as well as new Labels to show respective key inputs
        addObject(wOne, 200, 370);
        addObject(new Label("<1>", 65), 200, 370);
        addObject(wTwo, 600, 370);
        addObject(new Label("<2>", 65), 600, 370);
        addObject(wThree, 1000, 370);
        addObject(new Label("<3>", 65), 1000, 370);

        addObject(one, 200, 300);
        addObject(two, 600, 300);
        addObject(three, 1000, 300);
    }

    /**
     * Manages keypresses and checks for button presses to 
     * change the world to different levels
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("1") || wOne.touchingCursor())
        {
            removeObjects(getObjects(null));
            Greenfoot.setWorld(new LevelOne());
        }
        if(Greenfoot.isKeyDown("2") || wTwo.touchingCursor())
        {
            removeObjects(getObjects(null));
            Greenfoot.setWorld(new LevelTwo());
        }
        if(Greenfoot.isKeyDown("3") || wThree.touchingCursor())
        {
            removeObjects(getObjects(null));
            Greenfoot.setWorld(new LevelThree());
        }
        if(Greenfoot.isKeyDown("B"))
        {
            Greenfoot.setWorld(new TitleScreen());
        }
    }

    /**
     * Recursive method to spawn enemies based on wave number and 
     * time remaining. The level parameter is used to reduce the delay
     * between each balloon spawn to give less time for the player
     * to prepare in higher levels. The wave parameter is used to
     * decide which of the 4 balloon types to spawn, with the
     * stronger types having an advantage over the weaker ones.
     * Lastly timer is used to increment the spawns as in each recursive
     * call it reduces the value until it % 100 gives a desirable
     * number. The Balloons are then spawned on the edges of the
     * screen randomly.
     */
    public void spawnBalloons(int level, int wave, int timer)
    {
        if(timer == 0) return;
        Enemy balloon = new Enemy();
        if(wave % 7 == 0)
        {
            balloon = new OrangeBalloon();
        }
        else if(wave % 5 == 0)
        {
            balloon = new GreenBalloon();
        }
        else if(wave % 2 == 0)
        {
            balloon = new BlueBalloon();
        }
        else
        {
            balloon = new RedBalloon();
        }

        if(timer % 100 == 0)
        {
            addObject(balloon, randomLocationX(), 0);
            Greenfoot.delay(10);
        }
        else if(timer % 100 == (25/level))
        {
            addObject(balloon, randomLocationX(), 700);
            Greenfoot.delay(10);
        }
        else if(timer % 100 == (50/level))
        {
            addObject(balloon, 0, randomLocationY());
            Greenfoot.delay(10);
        }
        else if(timer % 100 == (75/level))
        {
            addObject(balloon, 1200, randomLocationY());
            Greenfoot.delay(10);
        }
        spawnBalloons(level, wave, timer-1);
    }

    /**
     * Gets a random location in the x-axis and returns it
     */
    private int randomLocationX()
    {
        int x = Greenfoot.getRandomNumber(1200);
        return x;
    }
    
    /**
     * Gets a random location in the y-axis and returns it
     */
    private int randomLocationY()
    {
        int y = Greenfoot.getRandomNumber(700);
        return y;
    }

    /**
     * A method to instantly kill your character
     */
    public void death()
    {
        if(Greenfoot.isKeyDown("O"))
        {
            Health.life.clear();
        }
    }
}
