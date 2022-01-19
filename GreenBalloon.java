import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenBalloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenBalloon extends Enemy
{
    int power = 2;
    int speed =3;
    GreenfootImage image;
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
            for(int i = 0 ; i< power ; i++){
                if(!Health.life.isEmpty()){
                    Health.life.pop();
                } else {
                    Health.die();
                }
            }
            // remove the balloon
            getWorld().removeObject(this);
        }
    }
}
