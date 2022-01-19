import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private int speed;
    int power;
    String color;
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act() 
    {

    }    
    
    public enum EnemyType { orange, blue, green, red}
    
    public Enemy(int speed, int power, int color){
        
    }

    public Enemy(EnemyType type){
        if(type == EnemyType.orange){
            // Instantiate the orange ballon
        }
    }
    
    public void trackMonkey()
    {
        if (getWorld().getObjects(Player.class).isEmpty()) return;
        Actor player = (Actor)getWorld().getObjects(Player.class).get(0);
        turnTowards(player.getX(), player.getY());
    }
}
