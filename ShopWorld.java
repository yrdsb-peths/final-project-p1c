import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShopWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShopWorld extends World
{
    public static int money = 0;
    private int heightOffset = 50;  // the height of the buttons
    private int fontSize = heightOffset;  // font size of button text
    private int hoverTextFontSize = 20;
    private Label hoverTextLabel;
    Label flaming = new Label("Flaming Coconut: 50 gold", 35);
    Label steel = new Label("Steel Coconut: 200 gold", 35);
    /**
     * Constructor for objects of class ShopWorld.
     * 
     */
    public ShopWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1);
        createButtons();
        hoverTextLabel = new Label("", hoverTextFontSize);
        addObject(flaming, 400, 450);
        addObject(steel, 800, 450);
    }

    /**
     * Create and update the labels
     * This method moves labels to the "front" so they can be clicked
     */
    private void createButtons()
    {
        // label settings
        int x = 500;
        int y = 500;
        int buttonWidth = 150;
        int buttonHeight = fontSize;

        // get the padding on the ends of the buttons
        int offset = getWidth() - (buttonWidth * 2  );

        // Create the buttons
        String weaponupgrade = "Buy";
        Button button = new Button(weaponupgrade, buttonWidth, buttonHeight);
        addObject(button, 400, y);
        String weaponupgradetwo = "Buy";
        Button buttontwo = new Button(weaponupgradetwo, buttonWidth, buttonHeight);
        addObject(buttontwo, 800, y);
    }

    /**
     * Display the name of the exercise from the given letter
     */
    /*public void displayHoverText(String letter)
    {
    int x = 100;
    int y = hoverTextFontSize;
    String displayText = "Pog";
    hoverTextLabel.setValue(displayText);        
    hoverTextLabel.setFillColor(Color.GRAY);
    addObject(hoverTextLabel, x, y);
    }

     */
    /**
     * Cancel the hover Text
     */
    public void cancelHoverText()
    {
        hoverTextLabel.setValue(""); 
    }
}
