import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public static int score = 0;
    public int dashTimer = 0;
    public int shootCooldown = 0;
    boolean mouseIsDown = false;
    MouseInfo mouse = Greenfoot.getMouseInfo();
    public static int armourNum = 1;
    GreenfootImage T1 = new GreenfootImage("o1.png");
    GreenfootImage T2 = new GreenfootImage("o2.png");
    GreenfootImage T3 = new GreenfootImage("o3.png");
    
    
    public Player()
    {
        
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        dash();
        MouseInfo mouse = Greenfoot.getMouseInfo();
        shoot(mouse);
        if(mouse != null)
        {
            turnTowards(mouse);
        }
        updateMonkey();
    }    

    private void move()
    {
        if(Greenfoot.isKeyDown("W"))
        {
            setLocation(getX(),getY()-2);
        }
        if(Greenfoot.isKeyDown("A"))
        {
            setLocation(getX()-2,getY());
        }
        if(Greenfoot.isKeyDown("S"))
        {
            setLocation(getX(),getY()+2);
        }
        if(Greenfoot.isKeyDown("D"))
        {
            setLocation(getX()+2,getY());
        }
    }

    public void dash()
    {
        if(dashTimer <= 0)
        {
            if(Greenfoot.isKeyDown("shift"))
            {
                move(100);
                dashTimer = 75;
            }
        }
        dashTimer--;
    }

    public void shoot(MouseInfo mouse){
        if(Greenfoot.mousePressed(null)){
            mouseIsDown = true;
        }
        else if(Greenfoot.mouseClicked(null) || Greenfoot.mouseDragEnded(null)){
            mouseIsDown = false;
        }
        if(mouseIsDown && shootCooldown <= 0){
            Bullet bullet = new Bullet();
            getWorld().addObject(bullet,getX(),getY());
            bullet.turnTowards(mouse.getX(), mouse.getY());
            shootCooldown = 30;
        }
        shootCooldown--;
    }

    public void turnTowards (MouseInfo mi)
    {
        turnTowards(mi.getX(), mi.getY());
    }
    
    public void updateMonkey()
    {
        if(armourNum == 1)
        {
            monkeyT1();
            setImage(T1);
        }
        else if(armourNum == 2)
        {
            monkeyT2();
            setImage(T2);
        }
        else if(armourNum == 3)
        {
            monkeyT3();
            setImage(T3);
        }
    }
    public void monkeyT1()
    {
        
    }
    public void monkeyT2()
    {
        
    }
    public void monkeyT3()
    {
        
    }
}
