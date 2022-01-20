import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    int speed;
    int power;
    public int moneyValue;

    GreenfootImage redB = new GreenfootImage("balloon1.png");
    GreenfootImage blueB = new GreenfootImage("balloon2.png");
    GreenfootImage greenB = new GreenfootImage("balloon3.png");
    GreenfootImage orangeB = new GreenfootImage("balloon4.png");
    
    public Enemy(int speedVal, int powerVal, int moneyVal)
    {
        speed = speedVal;
        power = powerVal;
        moneyValue = moneyVal;
    }
    
    public Enemy(EnemyType type)
    {
        if(type == EnemyType.red)
        {
            this(1, 1, 1);
            setImage(redB);
        }
        else if(type == EnemyType.blue)
        {
            this(2, 1, 2);
            setImage(blueB);
        }
        else if(type == EnemyType.green)
        {
            this(3, 2, 4);
            setImage(greenB);
        }
        else if(type == EnemyType.orange)
        {
            this(2, 4, 5);
            setImage(orangeB);
        }
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act() 
    {
        trackMonkey();
        move(speed);
        if (isTouching(Player.class)){
            for(int i = 0; i < power; i++)
            {
                if(!Health.life.isEmpty())
                {
                    Health.life.pop();
                }
                else
                {
                    Health.die();
                }
            }
            getWorld().removeObject(this);
        }
    }    

    public void trackMonkey()
    {
        if (getWorld().getObjects(Player.class).isEmpty()) return;
        Actor player = (Actor)getWorld().getObjects(Player.class).get(0);
        turnTowards(player.getX(), player.getY());
    }
    
    
    public static int getMoneyValue()
    {
        return moneyValue;
    }
}
