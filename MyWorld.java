import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int enemyTimer = 0;
    int numEnemies = 100;
    int weaponupgradespawn;
    int weaponUpgradeTime = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 650, 1);
        Player player = new Player();
        addObject(player, 400, 400);
    }

    public void act()
    {
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
        weaponupgradespawn = Greenfoot.getRandomNumber(1);
        if(weaponupgradespawn == 0 && getObjects(WeaponUpgrade.class).size() == 0 && weaponUpgradeTime == 0){
            int upgradex = Greenfoot.getRandomNumber(700);
            int upgradey = Greenfoot.getRandomNumber(600);
            WeaponUpgrade upgrade = new WeaponUpgrade();
            addObject(upgrade, upgradex, upgradey);
            weaponUpgradeTime = 120;
        }
        weaponUpgradeTime--;
    }
}
