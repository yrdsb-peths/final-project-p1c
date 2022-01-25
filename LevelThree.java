import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The third and final level/world. The graveyard has much
 * faster enemy spawns with many more enemies spawing at a
 * time. The player should be upgraded significantly to
 * try to survive this ruthless world.
 * 
 * Code extremely similar to LevelOne and LevelTwo, only
 * differing in some variable values.
 * 
 * Aninda Saha, Conrad Mo
 * Jan 21, 2022
 */
public class LevelThree extends GameWorld
{
    int time = 0;
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
        wave = 1;
        world = 3;// Level 3, thus world value is set to three for use in HighScoresScreen
    }
    /**
     * Method to keep track of wave and spawn balloons and to increase the timer count. Also keeps track of health and player death
     */
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
        else
        {
            Greenfoot.setWorld(new EndScreen());
        }
        death();
    }
}
