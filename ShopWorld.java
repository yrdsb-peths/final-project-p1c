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
    public static int money = 0;
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
        Label gold = new Label("Gold: " + money, 50);
        Label buyOne = new Label("Buy: 50 gold", 40);
        Label buyTwo = new Label("Buy: 100 gold", 40);
        Label buyThree = new Label("Buy: 30 gold", 40);
        Label buyFour = new Label("Buy: 150 gold", 40);
        //Add labels
        addObject(gold, 1050, 100);
        addObject(flaming, 400  , 450);
        addObject(steel, 800, 450);
        addObject(hat, 400, 150);
        addObject(armor, 800, 150);
        addObject(buyOne, 400, 525);
        addObject(buyTwo, 800, 525);
        addObject(buyThree, 400, 225);
        addObject(buyFour, 800, 225);
        //Create Buttons
        flamingB = new Button();
        addObject(flamingB,400, 525);
        steelB = new Button();
        addObject(steelB,800, 525);
        hatB = new Button();
        addObject(hatB,400, 225);
        armorB = new Button();
        addObject(armorB,800, 225);
    }

    public void act(){
        if(Greenfoot.isKeyDown("B"))
        {
            Greenfoot.setWorld(new TitleScreen());
        }
        buttonCheck();
    }

    public void buttonCheck()
    {
        if(flamingB.touchingCursor() && money >= 50 && flamingbought == false)
        {
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money - 50;
            Bullet bullet = new Bullet();
            bullet.weaponNum = 2;
            flamingbought = true;
        }
        if(steelB.touchingCursor() && money >= 100 && steelbought == false)
        {
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money - 100;
            Bullet bullet = new Bullet();
            bullet.weaponNum = 3;
            flamingbought = true;
            steelbought = true;
        }
        if(hatB.touchingCursor() && money >= 30 && hatbought == false)
        {
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money - 30;
            Player player = new Player();
            player.armourNum = 2;
            hatbought = true;
        }
        if(armorB.touchingCursor() && money >= 150 && armorbought == false)
        {
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money - 150;
            Player player = new Player();
            player.armourNum = 3;
            armorbought = true;
            hatbought = true;
        }
    }
}
