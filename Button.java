import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * Ethan Woo 
 * Jan 15, 2022
 */
public class Button extends Actor
{
    public boolean touchingImage = false;
    GreenfootImage init = new GreenfootImage("button_up.png"); 
    GreenfootImage hover = new GreenfootImage("button_hover.png");
    GreenfootImage after = new GreenfootImage("button_down.png");
    public Button()
    {        
       init.scale(222, 78);
       hover.scale(222, 78);
       after.scale(222, 78); 
       this.setImage(init); 
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this) == true)
        {
           touchingImage = true;
           setImage(after);
        }
        else {
           touchingImage = false;
           
        }
        if(Greenfoot.mouseMoved(this))
        {
            setImage(hover); 
        }
        if(Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage(init); 
        }
    }    
    public boolean touchingCursor()
    {
        return touchingImage; 
    }
}
