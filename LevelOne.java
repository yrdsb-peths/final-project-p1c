import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The first level/world of Balloon Defence 3. It is a 
 * grasslands-type level where the enemies are quite
 * low in numbers and easy for first time players.
 * 
 * Aninda Saha, Conrad Mo
 * Jan 21, 2022
 */
public class LevelOne extends GameWorld
{
    int time = 0; // Variable used to increment when the spawning method is called
    int timer = 200; // Variable used as 3rd parameter of spawnBalloons
    Label healthLabel; // Shows health

    /**
     * Constructor for objects of class LevelOne.
     * 
     */
    public LevelOne()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //super(800, 650, 1);
        removeObjects(getObjects(null));
        
        // Creates+adds a new Player object
        Player player = new Player();
        addObject(player, 600, 350);
        
        // Creates an instance of Health which displays on screen
        Health health = new Health();
        addObject(health,70,70);
        healthLabel = new Label("-", 60);
        healthLabel.setFillColor(Color.RED);
        addObject(healthLabel, 120, 70);
        // WaveCount Label for displaying the wave when balloons are spawning
        waveCount = new Label("Wave " + wave, 60);
        wave = 1;
        world = 1; // Level 1, thus world value is set to one for use in HighScoresScreen
    }
    /**
     * Act method increments variables for wave and spawn balloons and to 
     * increase the timer count. Also keeps track and updates health and 
     * checks for player death.
     */
    public void act()
    {
        if(time % 400 == 0)
        {
            waveCount.setValue("Wave " + wave); // Displays wave number on screen as balloons spawn
            addObject(waveCount, 600,350);
            spawnBalloons(1,wave,timer);
            wave++;
            timer += 25;
            removeObject(waveCount); // Label is removed when balloon spawning finishes
        }
        time++;
        if(!Health.life.isEmpty()) // Updates health value shown based on the stack in Health class
        {
            healthLabel.setValue(Health.life.peek());
        }
        else
        {
            Greenfoot.setWorld(new EndScreen()); // If the stack is empty, game over
        }
        death();
    }
}
