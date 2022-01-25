import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The second level/world. This world is a desert style world,
 * where the enemy spawns are greater in number and more
 * frequent. Recommended for intermediate players.
 * 
 * Code extremely similar to LevelOne, only some variable
 * values differ.
 * 
 * Aninda Saha, Conrad Mo
 * Jan 21, 2022
 */
public class LevelTwo extends GameWorld
{
    int time = 0;
    int timer = 300;
    Label healthLabel;
    /**
     * Constructor for objects of class LevelTwo.
     * 
     */
    public LevelTwo()
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
        world = 2;// Level 2, thus world value is set to two for use in HighScoresScreen
    }
    /**
     * Method to keep track of wave and spawn balloons and to increase the timer count. Also keeps track of health and player death
     */
    public void act()
    {
        if(time % 350 == 0)
        {
            waveCount.setValue("Wave " + wave);
            addObject(waveCount, 600,350);
            spawnBalloons(2,wave,timer);
            wave++;
            timer += 50;
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
