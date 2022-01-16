import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelTwo extends GameWorld
{
    int enemyTimerTwo = 0;
    int numEnemiesTwo = 10;
    /**
     * Constructor for objects of class LevelTwo.
     * 
     */
    public LevelTwo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //super(800, 650, 1);
        removeObjects(getObjects(null));
        Player player = new Player();
        addObject(player, 600, 350);
    }

    public void act()
    {
        if(enemyTimerTwo <= 0 && numEnemiesTwo > 0)
        {
            int ranyTwo = Greenfoot.getRandomNumber(700);
            Enemy enemyTwo = new Enemy();
            addObject(enemyTwo, 790, ranyTwo);
            enemyTimerTwo = 30;
            numEnemiesTwo--;
        }
        enemyTimerTwo--;
        if(getObjects(Enemy.class).size() == 0 && numEnemiesTwo == 0){
            Greenfoot.delay(100);
            Greenfoot.setWorld(new LevelThree());
        }
    }
}
