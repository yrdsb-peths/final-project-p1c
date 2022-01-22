import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InfoWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InfoWorld extends World
{
    Label lineOne = new Label("WASD to move around", 60);
    Label lineTwo = new Label("Shift to dash into the direction you're facing", 60);
    Label lineThree = new Label("Left Click to shoot and move mouse to aim", 60);
    Label lineFour = new Label("Avoid balloons and shoot them to pop them", 60);
    Label lineFive = new Label("Hit <B> to go back", 60);
    /**
     * Constructor for objects of class InfoWorld.
     * 
     */
    public InfoWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1);
        addObject(lineOne, 600, 200);
        addObject(lineTwo, 600, 300);
        addObject(lineThree, 600, 400);
        addObject(lineFour, 600, 500);
        addObject(lineFive, 600, 600);
    }
    /**
     * Act method that tracks keypresses to change world to titlescreen
     */
    public void act(){
        if(Greenfoot.isKeyDown("B"))
        {
            Greenfoot.setWorld(new TitleScreen());
        }
    }
}
