import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelThree here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class LevelThree extends GameWorld
{
    int time = 0;
    int wave = 1;
    int timer = 400;
    Label healthLabel;
    /**
     * Constructor for objects of class LevelThree.
     * 
     */
    public LevelThree()
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
    }

    public void act()
    {
        if(time % 300 == 0)
        {
            waveCount.setValue("Wave " + wave);
            addObject(waveCount, 600,350);
            spawnBalloons(3,wave,timer);
            wave++;
            timer += 100;
            removeObject(waveCount);
        }
        time++;
        if(!Health.life.isEmpty())
        {
            healthLabel.setValue(Health.life.peek());
        }
    }
}
