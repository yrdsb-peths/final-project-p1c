import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Game Over screen of Balloon Defence 3. This is
 * where the game takes you once you have died to the
 * balloon onslaught.
 * 
 * Aninda Saha, Conrad Mo
 * Jan 18, 2022
 */
public class EndScreen extends World
{
    /**
     * Variable to hold endscreen image for level 1
     */
    GreenfootImage L1 = new GreenfootImage("1done.png");
    /**
     * Variable to hold endscreen image for level 2
     */
    GreenfootImage L2 = new GreenfootImage("2done.png");
    /**
     * Variable to hold endscreen image for level 3
     */
    GreenfootImage L3 = new GreenfootImage("3done.png");
    /**
     * Variable to record final wave that player died on
     */
    static int waveValue;
    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1);
        waveValue = GameWorld.wave-1;
        Label gO = new Label("Game Over!", 85);
        Label cont = new Label("Press <H> to see High Scores!", 60);
        Label finalscore = new Label("Wave Reached: " + waveValue + "!", 60);
        addObject(finalscore, 600, 500);
        addObject(gO, 600, 250);
        addObject(cont, 600, 350);
    }
    /**
     * Act method to switch background image based on level 
     * and to switch world to highscore if "H" is pressed
     */
    public void act(){
        switch(GameWorld.world) 
        {
            case 1:
                setBackground(L1);
                break;
            case 2: 
                setBackground(L2); 
                break;
            case 3: 
                setBackground(L3); 
                break;
        }
        if(Greenfoot.isKeyDown("H"))
        {
            Greenfoot.setWorld(new HighScoresScreen());
        }
    }
}
