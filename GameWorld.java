import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    public static int world = 1;
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("1"))
        {
            Greenfoot.setWorld(new LevelOne());
        }
        if(Greenfoot.isKeyDown("2"))
        {
            Greenfoot.setWorld(new LevelTwo());
        }
        if(Greenfoot.isKeyDown("3"))
        {
            Greenfoot.setWorld(new LevelThree());
        }
    }

    public void spawnBalloons(int level, int wave, int timer)
    {
        if(timer == 0) return;
        Enemy balloon = new Enemy();
        if(wave % 10 == 0)
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
        
        if(timer % 400 == 0)
        {
            addObject(balloon, randomLocationX(), 0);
            Greenfoot.delay(10);
        }
        else if(timer % 400 == (100/level))
        {
            addObject(balloon, randomLocationX(), 700);
            Greenfoot.delay(10);
        }
        else if(timer % 400 == (200/level))
        {
            addObject(balloon, 0, randomLocationY());
            Greenfoot.delay(10);
        }
        else if(timer % 400 == (300/level))
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
}
