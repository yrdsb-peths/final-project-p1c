import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HighScoresScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighScoresScreen extends World
{
    private static int[] nums = new int[10];
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
        Player player = new Player();
        int score = player.score;
        if(score < nums[0] && score > nums[6]){
            //Sort it into array
        }
        if(score > nums[0]){
            nums[0] = score;
            //Move everything down
        }
        Label scorelabel = new Label ("Score: " + score, 60);
        addObject(scorelabel, 400, 250);
    }

    public void run()
    {
        quicksort(nums);
    }

    private void setup(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++){
            arr[i] = i + 1;
        }
    }

    private void shuffle(int[] arr)
    {
        for(int i = 0; i < arr.length; i++){
            int indexes = Greenfoot.getRandomNumber(arr.length - i) + i;
            swap(arr, i, indexes);
        }
    }

    private void swap(int[] arr, int i, int j)
    {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public int partition(int[] a, int lo, int hi) {
        int i = lo; 
        int j = hi + 1;
        while (true) {
            while (a[++i] < a[lo]){ // Find item on left to swap 
                if (i == hi){
                    break;
                }
            }
            while (a[--j] > a[lo]){
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

    public void quicksort(int[] a) {
        quicksort(a, 0, a.length - 1);
    }
    // quicksort the subarray from a[lo] to a[hi]  
    private void quicksort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); 
        quicksort(a, lo, j-1); 
        quicksort(a, j+1, hi);
    }
}
