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
    public int shootCooldown = 0;
    public int weapon = 0;
    public static int weaponUpgradeCooldown = 0;
    boolean mouseIsDown = false;
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
        shoot(mouse);
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

    public void shoot(MouseInfo mouse){
        if(Greenfoot.mousePressed(null)){
            mouseIsDown = true;
        }
        else if(Greenfoot.mouseClicked(null) || Greenfoot.mouseDragEnded(null)){
            mouseIsDown = false;
        }
        if(mouseIsDown && shootCooldown <= 0){
            if(weapon == 0){
                Bullet bullet = new Bullet();
                getWorld().addObject(bullet,getX(),getY());
                bullet.turnTowards(mouse.getX(), mouse.getY());
                shootCooldown = 30;
            }
            if(weapon == 1){
                SteelBullet steelbullet = new SteelBullet();
                getWorld().addObject(steelbullet,getX(),getY());
                steelbullet.turnTowards(mouse.getX(), mouse.getY());
                shootCooldown = 15;
            }
        }
        if (isTouching(WeaponUpgrade.class)){
            removeTouching(WeaponUpgrade.class);
            weapon = 1;
            weaponUpgradeCooldown = 120;
        }
        weaponUpgradeCooldown--;
        shootCooldown--;
        if(weaponUpgradeCooldown == 0){
            weapon = 0;
        }
    }

    public void turnTowards (MouseInfo mi)
    {
        turnTowards(mi.getX(), mi.getY());
    }
    public int getCooldown(){
        return weaponUpgradeCooldown;
    }
}
