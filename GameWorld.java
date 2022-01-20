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
    public static int world = 0;
    public static int wave;

    Button wOne;
    Button wTwo;
    Button wThree;

    Label waveCount;
    Label moneyLabel = new Label("", 50);
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 

        setPaintOrder(Button.class, Label.class);

        moneyLabel.setFillColor(Color.YELLOW);
        
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

    public void spawnBalloons(int level, int wave, int timer)
    {
        if(timer == 0) return;
        Enemy balloon;
        if(wave % 7 == 0)
        {
            balloon = new Enemy(EnemyType.orange);
        }
        else if(wave % 5 == 0)
        {
            balloon = new Enemy(EnemyType.green);
        }
        else if(wave % 2 == 0)
        {
            balloon = new Enemy(EnemyType.blue);
        }
        else
        {
            balloon = new Enemy(EnemyType.red);
        }

        if(timer % 100 == 0)
        {
            addObject(balloon, randomLocationX(), 0);
            Greenfoot.delay(10/level);
        }
        else if(timer % 100 == 25)
        {
            addObject(balloon, randomLocationX(), 700);
            Greenfoot.delay(10/level);
        }
        else if(timer % 100 == 50)
        {
            addObject(balloon, 0, randomLocationY());
            Greenfoot.delay(10/level);
        }
        else if(timer % 100 == 75)
        {
            addObject(balloon, 1200, randomLocationY());
            Greenfoot.delay(10/level);
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
    
    public void updateMoney()
    {
        moneyLabel.setValue("Gold: " + ShopWorld.money);
    }
    
    public void death()
    {
        if(Greenfoot.isKeyDown("O"))
        {
            Health.life.clear();
        }
    }
}
