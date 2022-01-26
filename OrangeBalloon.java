import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * tier 4 enemy
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrangeBalloon extends Enemy
{
    /**
     * Act - do whatever the OrangeBalloon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        trackMonkey();
        move(2);
        if (isTouching(Player.class)){
            if(Health.life.peek() > 4 && !Health.life.isEmpty())
            {
                Health.life.pop();
                Health.life.pop();
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
