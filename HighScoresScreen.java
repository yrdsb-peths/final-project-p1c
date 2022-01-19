import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class HighScoresScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighScoresScreen extends World
{
    public static ArrayList<Integer> nums = new ArrayList<Integer>();
    private int target;
    /**
     * Constructor for objects of class HighScoresScreen.
     * 
     */
    public HighScoresScreen()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1);
        setup(nums);
        shuffle(nums);
        Label scorelabel = new Label ("Score:", 60);
        addObject(scorelabel, 400, 250);
        quicksort(nums);
        for (int i = 0; i < nums.size(); i++){
            if (i < 10){
                Label scores = new Label(nums.get(i), 60);
                addObject(scores, 400, 350 + (i * 50));
            }
        }
    }

    public void act(){
        if(Greenfoot.isKeyDown("B"))
        {
            Greenfoot.setWorld(new TitleScreen());
        }
    }

    public void run(){
        
        
    }

    private void setup(ArrayList<Integer> arr)
    {
        for (int i = 0; i < arr.size() - 1; i++){
            arr.set(i, i + 1);
        }
    }

    private void shuffle(ArrayList<Integer> arr)
    {
        for(int i = 0; i < arr.size(); i++){
            int indexes = Greenfoot.getRandomNumber(arr.size() - i) + i;
            swap(arr, i, indexes);
        }
    }

    private void swap(ArrayList<Integer> arr, int i, int j)
    {
        int temp = arr.get(j);
        arr.set(j, arr.get(i));
        arr.set(i, temp);
    }

    public int partition(ArrayList<Integer> a, int lo, int hi) {
        int i = lo; 
        int j = hi + 1;
        while (true) {
            while (a.get(++i) < a.get(lo)){ // Find item on left to swap 
                if (i == hi){
                    break;
                }
            }
            while (a.get(--j) > a.get(lo)){
                if (j == lo){
                    break;
                }
            }
            if (i >= j){
                break;  // Check if pointers cross 
            }
            swap(a, i, j);  // Swap
        }
        // Swap partitioning element
        swap(a, lo, j);
        return j;  // Return index of item now know to be in place
    }

    public void quicksort(ArrayList<Integer> a) {
        quicksort(a, 0, a.size()- 1);
    }
    // quicksort the subarray from a[lo] to a[hi]  
    private void quicksort(ArrayList<Integer> a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); 
        quicksort(a, lo, j-1); 
        quicksort(a, j+1, hi);
    }
}
