import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class EndScreen extends World
{
    GreenfootImage L1 = new GreenfootImage("1done.png");
    GreenfootImage L2 = new GreenfootImage("2done.png");
    GreenfootImage L3 = new GreenfootImage("3done.png");
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
