import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public int dashTimer = 0;
    MouseInfo mouse = Greenfoot.getMouseInfo();
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        dash();
        
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null)
        {
            turnTowards(mouse);
        }
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

    public void turnTowards (int x, int y)
    {
        double dx = x - getX();
        double dy = y - getY();
        double angle = Math.atan2(dy,dx)*180.0/Math.PI;
        setRotation( (int)angle );
    }
    public void turnTowards (MouseInfo mi)
    {
        turnTowards(mi.getX(), mi.getY());
    }
}
