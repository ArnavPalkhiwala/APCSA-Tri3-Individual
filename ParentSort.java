import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class ParentSort {
    public ArrayList<Integer> data= new ArrayList<>();
    public Duration timeElapsed;
    public static int sorts = 0;
    public static int comparisons = 0;
    public static int lowerIndex = 0;
    public static int higherIndex;

    //generates the random data set
    public void sort(int size){
        for (int i = 0; i < size; i++) {
           data.add((int)(Math.random() * (size+1)));
        }
    }
    public ArrayList<Integer> getData() {
        return data;
    }

    public long getTimeElapsed() {
        return timeElapsed.getNano();
    }

    public int getComparisons(){
        return comparisons;
    }

    public int getSorts(){
        return sorts;
    }


}
