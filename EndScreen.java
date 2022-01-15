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
        super(800, 650, 1);
        Label theend = new Label("Gameover", 85);
        Label spacebar = new Label("Hit spacebar to play again", 60);
        addObject(theend, 400, 250);
        addObject(spacebar, 400, 350);
    }
    public void act(){
        if(Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new TitleScreen());
        }
    }
}
