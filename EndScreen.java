import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class EndScreen extends World
{
    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1);
        Label theend = new Label("Game Over!", 85);
        Label spacebar = new Label("Hit <backspace> to return to menu!", 60);
        Player player = new Player();
        int score = player.score;
        HighScoresScreen highscores = new HighScoresScreen();
        Label finalscore = new Label("Score: " + score, 60);
        addObject(finalscore, 600, 500);
        addObject(theend, 600, 250);
        addObject(spacebar, 600, 350);
        player.score = 0;
    }
    public void act(){
        if(Greenfoot.isKeyDown("backspace"))
        {
            Greenfoot.setWorld(new TitleScreen());
        }
    }
}
