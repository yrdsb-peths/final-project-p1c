import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelTwo extends World
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
        super(800, 700, 1);
        Player player = new Player();
        addObject(player, 400, 400);
    }

    public void act()
    {
        if(enemyTimerTwo <= 0 && numEnemiesTwo > 0)
        {
            int ranxTwo = Greenfoot.getRandomNumber(800);
            int ranyTwo = Greenfoot.getRandomNumber(700);
            Enemy enemyTwo = new Enemy();
            addObject(enemyTwo, ranxTwo, ranyTwo);
            enemyTimerTwo = 60;
            numEnemiesTwo--;
        }
        enemyTimerTwo--;
        if(getObjects(Enemy.class).size() == 0 && numEnemiesTwo == 0){
            Greenfoot.delay(100);
            Greenfoot.setWorld(new LevelThree());
        }
    }
}
