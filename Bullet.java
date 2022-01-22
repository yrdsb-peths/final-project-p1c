import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Integer variable to track what type of coconut the player is using
     */
    public static int weaponNum = 1;
    /**
     * Tracks the amount of balloons the Tier 1 Coconut can hit before disappearing
     */
    public int hitsT1 = 2;
    /**
     * Tracks the amount of balloons the Tier 2 Coconut can hit before disappearing
     */
    public int hitsT2 = 3;
    /**
     * Tracks the amount of balloons the Tier 3 Coconut can hit before disappearing
     */
    public int hitsT3 = 5;
    GreenfootImage T1 = new GreenfootImage("coconut1.png");
    GreenfootImage T2 = new GreenfootImage("coconut2.png");
    GreenfootImage T3 = new GreenfootImage("coconut3.png");
    GreenfootSound pop = new GreenfootSound("balloon_pop.wav");
    /**
     * Constructor for objects of class Bullet.
     */
    public Bullet()
    {
        pop.setVolume(60);
    }
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {   
        updateCoconut();
    }
    /**
     * Method to track tier 1 coconut movement speed as well as money gain per different coloured balloon
     */
    private void coconutT1()
    {
        move(9);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        else if (isTouching(OrangeBalloon.class))
        {
            removeTouching(OrangeBalloon.class);
            Player player = new Player();
            player.score++;
            ShopWorld.money += 5;
            T1hits();
        }
        else if (isTouching(GreenBalloon.class)){
            removeTouching(GreenBalloon.class);
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 4;
            Player player = new Player();
            player.score++;
            T1hits();
        }
        else if (isTouching(BlueBalloon.class)){
            removeTouching(BlueBalloon.class);
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 2;
            Player player = new Player();
            player.score++;
            T1hits();
        }
        else if (isTouching(RedBalloon.class)){
            removeTouching(RedBalloon.class);
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 1;
            Player player = new Player();
            player.score++;
            T1hits();
        }
        else if (isTouching(Enemy.class)){
            removeTouching(Enemy.class);
            Player player = new Player();
            player.score++;
            T1hits();
        }
    }
    /**
     * Method to track tier 2 coconut movement speed as well as money gain per different coloured balloon
     */
    private void coconutT2()
    {
        move(14);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        else if (isTouching(OrangeBalloon.class))
        {
            removeTouching(OrangeBalloon.class);
            Player player = new Player();
            player.score++;
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 5;
            T2hits();
        }
        else if (isTouching(GreenBalloon.class)){
            removeTouching(GreenBalloon.class);
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 4;
            Player player = new Player();
            player.score++;
            T2hits();
        }
        else if (isTouching(BlueBalloon.class)){
            removeTouching(BlueBalloon.class);
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 2;
            Player player = new Player();
            player.score++;
            T2hits();
        }
        else if (isTouching(RedBalloon.class)){
            removeTouching(RedBalloon.class);
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 1;
            Player player = new Player();
            player.score++;
            T2hits();
        }
        else if (isTouching(Enemy.class)){
            removeTouching(Enemy.class);
            Player player = new Player();
            player.score++;
            T2hits();
        }
    }
    /**
     * Method to track tier 3 coconut movement speed as well as money gain per different coloured balloon
     */
    private void coconutT3()
    {
        move(20);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        else if (isTouching(OrangeBalloon.class))
        {
            removeTouching(OrangeBalloon.class);
            Player player = new Player();
            player.score++;
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 5;
            T3hits();
        }
        else if (isTouching(GreenBalloon.class)){
            removeTouching(GreenBalloon.class);
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 4;
            Player player = new Player();
            player.score++;
            T3hits();
        }
        else if (isTouching(BlueBalloon.class)){
            removeTouching(BlueBalloon.class);
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 2;
            Player player = new Player();
            player.score++;
            T3hits();
        }
        else if (isTouching(RedBalloon.class)){
            removeTouching(RedBalloon.class);
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 1;
            Player player = new Player();
            player.score++;
            T3hits();
        }
        else if (isTouching(Enemy.class)){
            removeTouching(Enemy.class);
            Player player = new Player();
            player.score++;
            T3hits();
        }
    }
    /**
     * Method to track the amount of hits a tier 1 coconut has taken and to delete it if reached maximum hits
     */
    public void T1hits()
    {
        hitsT1--;
        pop.play();
        if(hitsT1 == 0)
        {
            getWorld().removeObject(this);
            hitsT1 = 2;
        }
    }
    /**
     * Method to track the amount of hits a tier 2 coconut has taken and to delete it if reached maximum hits
     */
    public void T2hits()
    {
        hitsT2--;
        pop.play();
        if(hitsT2 == 0)
        {
            getWorld().removeObject(this);
            hitsT2 = 3;
        }
    }
    /**
     * Method to track the amount of hits a tier 3 coconut has taken and to delete it if reached maximum hits
     */
    public void T3hits()
    {
        hitsT3--;
        pop.play();
        if(hitsT3 == 0)
        {
            getWorld().removeObject(this);
            hitsT3 = 5;
        }
    }
    /**
     * Method to run other methods based on coconut tier
     */
    public void updateCoconut()
    {
        updateCoconutImage();
        if(weaponNum == 1)
        {
            coconutT1();
        }
        else if(weaponNum == 2)
        {
            coconutT2();
        }
        else if(weaponNum == 3)
        {
            coconutT3();
        }
    }
    /**
     * Method to track coconut image based on tier number
     */
    public void updateCoconutImage()
    {
        if(weaponNum == 1)
        {
            setImage(T1);
        }
        else if(weaponNum == 2)
        {
            setImage(T2);
        }
        else if(weaponNum == 3)
        {
            setImage(T3);
        }
    }
}
