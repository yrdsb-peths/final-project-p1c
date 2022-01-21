import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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

        setPaintOrder(Button.class, Label.class);

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
     * Manages keypresses to select different levels
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
     * Recursive method to spawn enemies based on wave number and time renaming
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

    private int randomLocationX()
    {
        int x = Greenfoot.getRandomNumber(1200);
        return x;
    }

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
