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
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */public void act()
    {   
        updateCoconut();
    }

    private void coconutT1()
    {
        move(9);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        else if (isTouching(OrangeBalloon.class))
        {
            OrangeBalloon.health--;
            if(OrangeBalloon.health == 0)
            {
                removeTouching(Enemy.class);
                Player player = new Player();
                player.score++;
                hitsT1--;
                ShopWorld shop = new ShopWorld();
                shop.money = shop.money + 5;
                if(hitsT1 == 0)
                {
                    getWorld().removeObject(this);
                    hitsT1 = 2;
                }
            }
        }
        else if (isTouching(GreenBalloon.class)){
            removeTouching(GreenBalloon.class);
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 4;
            Player player = new Player();
            player.score++;
            hitsT1--;
            if(hitsT1 == 0)
            {
                getWorld().removeObject(this);
                hitsT1 = 2;
            }
        }
        else if (isTouching(BlueBalloon.class)){
            removeTouching(BlueBalloon.class);
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 2;
            Player player = new Player();
            player.score++;
            hitsT1--;
            if(hitsT1 == 0)
            {
                getWorld().removeObject(this);
                hitsT1 = 2;
            }
        }
        else if (isTouching(RedBalloon.class)){
            removeTouching(RedBalloon.class);
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 1;
            Player player = new Player();
            player.score++;
            hitsT1--;
            if(hitsT1 == 0)
            {
                getWorld().removeObject(this);
                hitsT1 = 2;
            }
        }
        else if (isTouching(Enemy.class)){
            removeTouching(Enemy.class);
            Player player = new Player();
            player.score++;
            hitsT1--;
            if(hitsT1 == 0)
            {
                getWorld().removeObject(this);
                hitsT1 = 2;
            }
        }
    }

    private void coconutT2()
    {
        move(14);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        else if (isTouching(OrangeBalloon.class))
        {
            OrangeBalloon.health--;
            if(OrangeBalloon.health == 0)
            {
                removeTouching(Enemy.class);
                Player player = new Player();
                player.score++;
                hitsT1--;
                ShopWorld shop = new ShopWorld();
                shop.money = shop.money + 5;
                if(hitsT1 == 0)
                {
                    getWorld().removeObject(this);
                    hitsT1 = 2;
                }
            }
        }
        else if (isTouching(GreenBalloon.class)){
            removeTouching(GreenBalloon.class);
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 4;
            Player player = new Player();
            player.score++;
            hitsT1--;
            if(hitsT1 == 0)
            {
                getWorld().removeObject(this);
                hitsT1 = 2;
            }
        }
        else if (isTouching(BlueBalloon.class)){
            removeTouching(BlueBalloon.class);
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 2;
            Player player = new Player();
            player.score++;
            hitsT1--;
            if(hitsT1 == 0)
            {
                getWorld().removeObject(this);
                hitsT1 = 2;
            }
        }
        else if (isTouching(RedBalloon.class)){
            removeTouching(RedBalloon.class);
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 1;
            Player player = new Player();
            player.score++;
            hitsT1--;
            if(hitsT1 == 0)
            {
                getWorld().removeObject(this);
                hitsT1 = 2;
            }
        }
        else if (isTouching(Enemy.class)){
            removeTouching(Enemy.class);
            Player player = new Player();
            player.score++;
            hitsT2--;
            if(hitsT2 == 0)
            {
                getWorld().removeObject(this);
                hitsT2 = 3;
            }

        }
    }

    private void coconutT3()
    {
        move(20);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        else if (isTouching(OrangeBalloon.class))
        {
            OrangeBalloon.health--;
            if(OrangeBalloon.health == 0)
            {
                removeTouching(Enemy.class);
                Player player = new Player();
                player.score++;
                ShopWorld shop = new ShopWorld();
                shop.money = shop.money + 5;
                hitsT1--;
                if(hitsT1 == 0)
                {
                    getWorld().removeObject(this);
                    hitsT1 = 2;
                }
            }
        }
        else if (isTouching(GreenBalloon.class)){
            removeTouching(GreenBalloon.class);
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 4;
            Player player = new Player();
            player.score++;
            hitsT1--;
            if(hitsT1 == 0)
            {
                getWorld().removeObject(this);
                hitsT1 = 2;
            }
        }
        else if (isTouching(BlueBalloon.class)){
            removeTouching(BlueBalloon.class);
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 2;
            Player player = new Player();
            player.score++;
            hitsT1--;
            if(hitsT1 == 0)
            {
                getWorld().removeObject(this);
                hitsT1 = 2;
            }
        }
        else if (isTouching(RedBalloon.class)){
            removeTouching(RedBalloon.class);
            ShopWorld shop = new ShopWorld();
            shop.money = shop.money + 1;
            Player player = new Player();
            player.score++;
            hitsT1--;
            if(hitsT1 == 0)
            {
                getWorld().removeObject(this);
                hitsT1 = 2;
            }
        }
        else if (isTouching(Enemy.class)){
            removeTouching(Enemy.class);
            Player player = new Player();
            player.score++;
            hitsT3--;
            if(hitsT3 == 0)
            {
                getWorld().removeObject(this);
                hitsT3 = 5;
            }
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
