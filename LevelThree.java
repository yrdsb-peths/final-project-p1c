import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelThree here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class LevelThree extends GameWorld
{
    int enemyTimerThree = 0;
    int numEnemiesThree = 20;
    /**
     * Constructor for objects of class LevelThree.
     * 
     */
    public LevelThree()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //super(800, 650, 1);
        removeObjects(getObjects(null));
        Player player = new Player();
        addObject(player, 600, 350);
    }

    public void act()
    {
        if(enemyTimerThree <= 0 && numEnemiesThree > 0)
        {
            int ranyThree = Greenfoot.getRandomNumber(700);
            Enemy enemyTwo = new Enemy();
            addObject(enemyTwo, 790, ranyThree);
            enemyTimerThree = 10;
            numEnemiesThree--;
        }
        enemyTimerThree--;
        if(getObjects(Enemy.class).size() == 0 && numEnemiesThree == 0){
            Greenfoot.delay(100);
            Greenfoot.setWorld(new EndScreen());
        }
    }
}
