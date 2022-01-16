import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShopWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShopWorld extends World
{
    public static int money = 0; //Placeholder numbre for testing gold
    public static boolean flamingbought = false;
    public static boolean steelbought = false;
    private int heightOffset = 25;  // the height of the buttons
    private int fontSize = 25;  // font size of button text
    private int hoverTextFontSize = 10;
    private Label hoverTextLabel;
    Label flaming = new Label("Flaming Coconut", 35);
    Label steel = new Label("Steel Coconut", 35);
    Label hat = new Label("Fresh Hat", 30);
    Label armor = new Label("Military Gear", 30);
    /**
     * Constructor for objects of class ShopWorld.
     * 
     */
    public ShopWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1);
        createShopButtons();
        hoverTextLabel = new Label("", hoverTextFontSize);
        Label gold = new Label("Gold: " + money, 35);
        addObject(gold, 600, 50);
        addObject(flaming, 400  , 450);
        addObject(steel, 800, 450);
        addObject(hat, 400, 150);
        addObject(armor, 800, 150);
    }

    public void act(){
        if(Greenfoot.isKeyDown("B"))
        {
            Greenfoot.setWorld(new TitleScreen());
        }
    }

    /**
     * Create and update the labels
     * This method moves labels to the "front" so they can be clicked
     */
    private void createShopButtons()
    {
        // label settings
        int x = 500;
        int y = 500;
        int buttonWidth = 200;
        int buttonHeight = 50;

        // get the padding on the ends of the buttons
        int offset = getWidth() - (buttonWidth * 2  );

        // Create the buttons
        String weaponupgrade = "Buy (50 gold)";
        ShopButton button = new ShopButton(weaponupgrade, buttonWidth, buttonHeight, 1);
        addObject(button, 400, y);
        String weaponupgradetwo = "Buy (100 gold)";
        ShopButton buttontwo = new ShopButton(weaponupgradetwo, buttonWidth, buttonHeight, 2);
        addObject(buttontwo, 800, y);
        String hatupgrade = "Buy (30 gold)";
        ShopButton buttonthree = new ShopButton(hatupgrade, buttonWidth, buttonHeight, 3);
        addObject(buttonthree, 400, y - 300);
        String armorupgrade = "Buy (150 gold)";
        ShopButton buttonfour = new ShopButton(armorupgrade, buttonWidth, buttonHeight, 4);
        addObject(buttonfour, 800, y - 300);
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
