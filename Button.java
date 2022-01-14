import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clickable button
 */
public class Button extends Actor
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
    public Button(String text, int width, int height)
    {
        // Scale the image
        up.scale(width, height);
        down.scale(width, height);
        hover.scale(width, height);

        // Show text on the button
        this.text = text;
        Label label = new Label(text, height);
        up.drawImage(label.getImage(), width/3, 0);
        down.drawImage(label.getImage(), width/3, 0);
        hover.drawImage(label.getImage(), width/3, 0);
        setImage(up);
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
            Button button = (Button) info.getActor();

            if(Greenfoot.mousePressed(this))
            {
                state = state.DOWN;
            }
            else if(Greenfoot.mouseClicked(this))
            {
                state = state.HOVER;
                // Update the screen with the correct canvas
                
            }
            else
            {
                state = state.HOVER;
            }
        }
        else if(info.getActor() != null)
        {
            state = state.UP;   
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
