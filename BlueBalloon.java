import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tier 2 enemy
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueBalloon extends Enemy
{
    /**
     * Act - do whatever the BlueBalloon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        trackMonkey();
        move(2);
        if (isTouching(Player.class)){
            if(!Health.life.isEmpty()){
                Health.life.pop();
            }
            getWorld().removeObject(this);
        }
    }
}
