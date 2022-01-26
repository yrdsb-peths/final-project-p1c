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
    Button returnMenu;
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
        
        setPaintOrder(Button.class, Label.class);
        returnMenu = new Button();
        addObject(returnMenu, 120, 650);
        Label b = new Label("\u21e6", 90);
        addObject(b, 120, 644);
        Label goBack = new Label("Press <B> or click the button to go back!", 50);
        addObject(goBack, 700, 650);
    }
    /**
     * Act method that tracks keypresses to change world to titlescreen
     */
    public void act(){
        if(Greenfoot.isKeyDown("B") || returnMenu.touchingCursor())
        {
            Greenfoot.setWorld(new TitleScreen());
        }
    }
}
