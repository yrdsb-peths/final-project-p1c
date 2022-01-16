import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clickable button
 */
public class ShopButton extends Actor
{
    // The images of the different button states
    GreenfootImage up = new GreenfootImage("button_up.png");
    GreenfootImage down = new GreenfootImage("button_down.png");
    GreenfootImage hover = new GreenfootImage("button_hover.png");

    // The current state of the button.
    // The initial state of the button is UP
    private State state = State.UP;

    // The text to display on the button
    private String text;
    public int item;
    public static boolean flamingbought = false;
    public static boolean steelbought = false;
    public static boolean hatbought = false;
    public static boolean armorbought = false;
    // Assign descriptive names to numbers
    // Basically, UP = 0, DOWN = 1, HOVER = 2, NONE = 3
    private enum State
    {
        UP, DOWN, HOVER, NONE
    }

    /**
     * Consruct a button with text, width and height
     * @param text The text to show on the button
     * @param width The width of the button
     * @param height the height of the button
     */
    public ShopButton(String text, int width, int height, int buttontype)
    {
        // Scale the image
        up.scale(width, height);
        down.scale(width, height);
        hover.scale(width, height);

        // Show text on the button
        this.text = text;
        Label label = new Label(text, 30);
        up.drawImage(label.getImage(), width/3 -45, 7);
        down.drawImage(label.getImage(), width/3 -45, 7);
        hover.drawImage(label.getImage(), width/3 -45, 7);
        setImage(up);
        item = buttontype;
    }

    public void act()
    {
        // Get mouse info and exit the act() loop if there is no mouse information
        MouseInfo info = Greenfoot.getMouseInfo();
        if(info == null) {
            return;
        }

        // Determine if the mouse is hovering, has pressed down or released on this button
        if(info.getActor() == this)
        {
            ShopButton button = (ShopButton) info.getActor();

            if(Greenfoot.mousePressed(this))
            {
                state = state.DOWN;
            }
            else if(Greenfoot.mouseClicked(this))
            {
                state = state.HOVER;
                // Update the screen with the correct canvas
                ShopWorld shop = new ShopWorld();
                if(item == 1 && shop.money >= 50 && flamingbought == false){
                    shop.money = shop.money - 50;
                    Bullet bullet = new Bullet();
                    bullet.weaponNum = 2;
                    flamingbought = true;
                }
                if(item == 2 && shop.money >= 100 && steelbought == false){
                    shop.money = shop.money - 100;
                    Bullet bullet = new Bullet();
                    bullet.weaponNum = 3;
                    steelbought = true;
                    flamingbought = true;
                }
                if(item == 3 && shop.money >= 30 && hatbought == false){
                    shop.money = shop.money - 30;
                    Player player = new Player();
                    player.armourNum = 2;
                    hatbought = true;
                }
                if(item == 4 && shop.money >= 150 && armorbought == false){
                    shop.money = shop.money - 150;
                    Player player = new Player();
                    player.armourNum = 3;
                    armorbought = true;
                    hatbought = true;
                }
            }
            else
            {
                state = state.HOVER;
            }
        }
        else if(info.getActor() != null)
        {
            if(item == 1 && flamingbought == true){
                state = state.DOWN;
            }
            if(item == 2 && steelbought == true){
                state = state.DOWN;
            }
            if(item == 3 && hatbought == true){
                state = state.DOWN;
            }
            if(item == 4 && armorbought == true){
                state =state.DOWN;
            }
            else{
                state = state.UP;
            }  
        }

        // Update the button image
        updateImage();
    }

    /**
     * Update the button image based on its current state
     */
    private void updateImage()
    {
        ShopWorld world = (ShopWorld) getWorld();
        switch (state)
        {
            case UP:
                setImage(up);
                break;
            case DOWN:
                setImage(down);
                break;
            case HOVER: 
                setImage(hover);
                break;
        }

    }
}
