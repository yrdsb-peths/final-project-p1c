import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    public static int weaponNum = 3;
    public int hitsT2 = 2;
    public int hitsT3 = 3;
    GreenfootImage T1 = new GreenfootImage("coconut1.png");
    GreenfootImage T2 = new GreenfootImage("coconut2.png");
    GreenfootImage T3 = new GreenfootImage("coconut3.png");
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */public void act()
    {   
        switch (weaponNum)
        {
            case 1: coconutT1();
            case 2: coconutT2();
            case 3: coconutT3();
        }
        
        updateImage();
    }
    
    private void coconutT1()
    {
        move(3);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        else if (isTouching(Enemy.class)){
            removeTouching(Enemy.class);
            getWorld().removeObject(this);
        }
    }
    private void coconutT2()
    {
        move(5);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        else if (isTouching(Enemy.class)){
            removeTouching(Enemy.class);
            hitsT2--;
            if(hitsT2 == 0)
            {
                getWorld().removeObject(this);
            }
            hitsT2 = 2;
        }
    }
    private void coconutT3()
    {
        move(7);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        else if (isTouching(Enemy.class)){
            removeTouching(Enemy.class);
            hitsT3--;
            if(hitsT3 == 0)
            {
                getWorld().removeObject(this);
            }
            hitsT3 = 3;
        }
    }
    
    private void updateImage()
    {
        switch(weaponNum)
        {
            case 1: setImage(T1);
            case 2: setImage(T2);
            case 3: setImage(T3);
        }
    }
}
