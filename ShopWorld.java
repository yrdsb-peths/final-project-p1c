    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShopWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShopWorld extends World
{
    Button flamingB;
    Button steelB;
    Button hatB;
    Button armorB;
    public static boolean flamingbought = false;
    public static boolean steelbought = false;
    public static boolean hatbought = false;
    public static boolean armorbought = false;
    public static int money = 10000;
    Label flaming = new Label("Flaming Coconut", 35);
    Label steel = new Label("Steel Coconut", 35);
    Label hat = new Label("Fresh Hat", 35);
    Label armor = new Label("Military Gear", 35);
    Label buyOne;
    Label buyTwo;
    Label buyThree;
    Label buyFour;
    Label gold;
    
    Button returnMenu;
    /**
     * Constructor for objects of class ShopWorld.
     * 
     */
    public ShopWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1);
        
        setPaintOrder(Button.class, Label.class);
        gold = new Label("Gold: " + money, 50);
        gold.setFillColor(Color.YELLOW);
        
        
        if(flamingbought == true){
            buyOne = new Label("BOUGHT", 40);
        }
        else{
            buyOne = new Label("Buy: 200 gold", 40);
        }
        if(steelbought == true){
            buyTwo = new Label("BOUGHT", 40);
        }
        else{
            buyTwo = new Label("Buy: 500 gold", 40);
        }
        if(hatbought == true){
            buyThree = new Label("BOUGHT", 40);
        }
        else{
            buyThree = new Label("Buy: 150 gold", 40);
        }
        if(armorbought == true){
            buyFour = new Label("BOUGHT", 40);
        }
        else{
            buyFour = new Label("Buy: 600 gold", 40);
        }
        //Add labels
        addObject(gold, 1050, 100);
        addObject(flaming, 400, 450);
        addObject(steel, 800, 450);
        addObject(hat, 400, 300);
        addObject(armor, 800, 300);
        addObject(buyOne, 400, 525);
        addObject(buyTwo, 800, 525);
        addObject(buyThree, 400, 375);
        addObject(buyFour, 800, 375);
        //Create Buttons
        flamingB = new Button();
        addObject(flamingB,400, 525);
        steelB = new Button();
        addObject(steelB,800, 525);
        hatB = new Button();
        addObject(hatB,400, 375);
        armorB = new Button();
        addObject(armorB,800, 375);
        
        returnMenu = new Button();
        addObject(returnMenu, 120, 650);
        Label b = new Label("\u21e6", 90);
        addObject(b, 120, 644);
        Label goBack = new Label("Press <B> or click the button to go back!", 50);
        addObject(goBack, 700, 650);
    }

    public void act(){
        if(Greenfoot.isKeyDown("B") || returnMenu.touchingCursor())
        {
            Greenfoot.setWorld(new TitleScreen());
        }
        buttonCheck();
        updateShop();
        gold.setValue("Gold: " + money);
    }

    public void updateShop()
    {
        if(flamingbought == true){
            buyOne.setValue("BOUGHT");
        }
        if(steelbought == true){
            buyTwo.setValue("BOUGHT");
        }
        if(hatbought == true){
            buyThree.setValue("BOUGHT");
        }
        if(armorbought == true){
            buyFour.setValue("BOUGHT");
        }
    }

    public void buttonCheck()
    {
        if(flamingB.touchingCursor() && money >= 200 && flamingbought == false)
        {
            money -= 200;
            Bullet.weaponNum = 2;
            flamingbought = true;
        }
        if(steelB.touchingCursor() && money >= 500 && steelbought == false)
        {
            money -= 500;
            Bullet.weaponNum = 3;
            flamingbought = true;
            steelbought = true;
        }
        if(hatB.touchingCursor() && money >= 150 && hatbought == false)
        {
            money -= 150;
            Player.armourNum = 2;
            hatbought = true;
        }
        if(armorB.touchingCursor() && money >= 600 && armorbought == false)
        {
            money -= 600;
            Player.armourNum = 3;
            armorbought = true;
            hatbought = true;
        }
    }
}
