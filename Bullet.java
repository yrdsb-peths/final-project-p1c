import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    public static int weaponNum = 1;
    public int hitsT1 = 2;
    public int hitsT2 = 3;
    public int hitsT3 = 5;
    GreenfootImage T1 = new GreenfootImage("coconut1.png");
    GreenfootImage T2 = new GreenfootImage("coconut2.png");
    GreenfootImage T3 = new GreenfootImage("coconut3.png");
    GreenfootSound pop = new GreenfootSound("balloon_pop.wav");
    
    
    
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

    private void coconutT1()
    {
        move(9);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        else if (isTouching(Enemy.class))
        {
            removeTouching(Enemy.class);
            Player player = new Player();
            player.score++;
            ShopWorld.money += 5;
            T1hits();
        }
    }

    private void coconutT2()
    {
        move(14);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        else if (isTouching(Enemy.class))
        {
            removeTouching(Enemy.class);
            Player player = new Player();
            player.score++;
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 5;
            T2hits();
        }
    }

    private void coconutT3()
    {
        move(20);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        else if (isTouching(Enemy.class))
        {
            removeTouching(Enemy.class);
            Player player = new Player();
            player.score++;
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 5;
            T3hits();
        }
    }

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
