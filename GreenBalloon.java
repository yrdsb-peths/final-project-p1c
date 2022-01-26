import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * tier 3 enemy
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenBalloon extends Enemy
{
    /**
     * Act - do whatever the GreenBalloon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        trackMonkey();
        move(3);
        if (isTouching(Player.class)){
            if(Health.life.peek() > 2 && !Health.life.isEmpty())
            {
                Health.life.pop();
                Health.life.pop();
            }
            else
            {
                Health.die();
            }
            getWorld().removeObject(this);
        }
    }
}
