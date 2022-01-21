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
    public static ArrayList<Integer> nums1 = new ArrayList<Integer>();
    public static ArrayList<Integer> nums2 = new ArrayList<Integer>();
    public static ArrayList<Integer> nums3 = new ArrayList<Integer>();
    private int target;
    Label level1;
    Label l11;
    Label l12;
    Label l13;
    Label level2;
    Label l21;
    Label l22;
    Label l23;
    Label level3;
    Label l31;
    Label l32;
    Label l33;
    /**
     * Constructor for objects of class HighScoresScreen.
     * 
     */
    public HighScoresScreen()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1);
        level1 = new Label("World 1 High Waves!", 45);
        level1.setFillColor(Color.GREEN);
        addObject(level1, 210, 100);

        level2 = new Label("World 2 High Waves!", 45);
        level2.setFillColor(Color.ORANGE);
        addObject(level2, 600, 100);

        level3 = new Label("World 3 High Waves!", 45);
        level3.setFillColor(Color.MAGENTA);
        addObject(level3, 990, 100);

        l11 = new Label("1: ", 70);
        addObject(l11, 100, 200);
        l12 = new Label("2: ", 70);
        addObject(l12, 100, 350);
        l13 = new Label("3: ", 70);
        addObject(l13, 100, 500);

        l21 = new Label("1: ", 70);
        addObject(l21, 500, 200);
        l22 = new Label("2: ", 70);
        addObject(l22, 500, 350);
        l23 = new Label("3: ", 70);
        addObject(l23, 500, 500);

        l31 = new Label("1: ", 70);
        addObject(l31, 850, 200);
        l32 = new Label("2: ", 70);
        addObject(l32, 850, 350);
        l33 = new Label("3: ", 70);
        addObject(l33, 850, 500);

        if(nums1.size() < 3)
        {
            nums1.add(0);
            nums1.add(0);
            nums1.add(0);
        }
        if(nums2.size() < 3)
        {
            nums2.add(0);
            nums2.add(0);
            nums2.add(0);
        }
        if(nums3.size() < 3)
        {
            nums3.add(0);
            nums3.add(0);
            nums3.add(0);
        }
        sort();
    }

    public void act(){
        updateAll();
        if(Greenfoot.isKeyDown("B"))
        {
            Greenfoot.setWorld(new TitleScreen());
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
        shuffle(a);
        quicksort(a, 0, a.size()- 1);
    }
    // quicksort the subarray from a[lo] to a[hi]  
    private void quicksort(ArrayList<Integer> a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); 
        quicksort(a, lo, j-1); 
        quicksort(a, j+1, hi);
    }

    private void sort()
    {
        switch(GameWorld.world)
        {
            case 1:
                nums1.add(EndScreen.waveValue);
                quicksort(nums1);
                update1();
                break;
            case 2:
                nums2.add(EndScreen.waveValue);
                quicksort(nums2);
                update2();
                break;
            case 3:
                nums3.add(EndScreen.waveValue);
                quicksort(nums3);
                update3();
                break;
        }
    }

    public void updateAll()
    {
        update1();
        update2();
        update3();
    }

    public void update1()
    {
        int val = nums1.size();
        l11.setValue("1: " + nums1.get(val - 1));
        l12.setValue("2: " + nums1.get(val - 2));
        l13.setValue("3: " + nums1.get(val - 3));
    }

    public void update2()
    {
        int val = nums2.size();
        l21.setValue("1: " + nums2.get(val - 1));
        l22.setValue("2: " + nums2.get(val - 2));
        l23.setValue("3: " + nums2.get(val - 3));
    }

    public void update3()
    {
        int val = nums3.size();
        l31.setValue("1: " + nums3.get(val - 1));
        l32.setValue("2: " + nums3.get(val - 2));
        l33.setValue("3: " + nums3.get(val - 3));
    }
}
