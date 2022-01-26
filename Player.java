import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The protagonist monkey that the user controls.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Timer variable to keep track of dash cooldown
     */
    public int dashTimer = 0;
    /**
     * Variable to keep track of shooting cooldown
     */
    public int shootCooldown = 0;
    boolean mouseIsDown = false;
    MouseInfo mouse = Greenfoot.getMouseInfo();
    /**
     * Variable to keep track of armor type
     */
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
    /**
     * Method that takes in keypresses for movement
     */
    private void move()
    {
        if(Greenfoot.isKeyDown("W"))
        {
            setLocation(getX(),getY()-(1+armourNum));
        }
        if(Greenfoot.isKeyDown("A"))
        {
            setLocation(getX()-(1+armourNum),getY());
        }
        if(Greenfoot.isKeyDown("S"))
        {
            setLocation(getX(),getY()+(1+armourNum));
        }
        if(Greenfoot.isKeyDown("D"))
        {
            setLocation(getX()+(1+armourNum),getY());
        }
    }
    /**
     * Method that controls the dash movement
     */
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
    /**
     * The method that tracks the mouse and shoots coconuts on click
     */
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
            shootCooldown = (30 / Bullet.weaponNum);
        }
        shootCooldown--;
    }
    /**
     * Method that turns monkey towards cursor coordinates
     */
    public void turnTowards (MouseInfo mi)
    {
        turnTowards(mi.getX(), mi.getY());
    }
    /**
     * Method that changes monkey image respective to the armor type equipped
     */
    public void updateMonkey()
    {
        if(armourNum == 1)
        {
            setImage(T1);
        }
        else if(armourNum == 2)
        {
            setImage(T2);
        }
        else if(armourNum == 3)
        {
            setImage(T3);
        }
    }
}
