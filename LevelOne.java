import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOne extends GameWorld
{
    int enemyTimer = 0;
    int numEnemies = 5;
    int time = 0;
    int wave = 1;
    /**
     * Constructor for objects of class LevelOne.
     * 
     */
    public LevelOne()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //super(800, 650, 1);
        Player player = new Player();
        addObject(player, 600, 350);
        
    }

    public void act()
    {
        /*
        Actor player = getObjects(Player.class).get(0); 
        if(enemyTimer <= 0 && numEnemies > 0)
        {
        int ranx = Greenfoot.getRandomNumber(800);
        int rany = Greenfoot.getRandomNumber(700);
        Enemy enemy = new Enemy();
        addObject(enemy, 790, rany);
        enemyTimer = 60;
        numEnemies--;
        }
        enemyTimer--;
        if(getObjects(Enemy.class).size() == 0 && numEnemies == 0){
        Greenfoot.delay(10);
        Greenfoot.setWorld(new LevelTwo());
        }
         */
        if(time % 300 == 0)
        {
            spawnBalloons(1,wave,800);
            wave++;
        }
        time++;
    }
}
