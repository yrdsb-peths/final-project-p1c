import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Iterator;

/**
 * Write a description of class LevelOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOne extends GameWorld
{
    int time = 0;
    int timer = 200;
    Label healthLabel;
    
    /**
     * Constructor for objects of class LevelOne.
     * 
     */
    public LevelOne()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //super(800, 650, 1);
        removeObjects(getObjects(null));
        Player player = new Player();
        addObject(player, 600, 350);
        Health health = new Health();
        addObject(health,70,70);
        healthLabel = new Label("-", 60);
        healthLabel.setFillColor(Color.RED);
        addObject(healthLabel, 120, 70);
        waveCount = new Label("Wave " + wave, 60);
        addObject(moneyLabel, 1050, 100);
        
        wave = 1;
        world = 1;
    }

    public void act()
    {
        if(time % 400 == 0)
        {
            waveCount.setValue("Wave " + wave);
            addObject(waveCount, 600,350);
            spawnBalloons(1,wave,timer);
            wave++;
            timer += 25;
            removeObject(waveCount);
        }
        time++;
        if(!Health.life.isEmpty())
        {
            healthLabel.setValue(Health.life.peek());
        }
        else
        {
            Greenfoot.setWorld(new EndScreen());
        }
        updateMoney();
        death();
    }
}
