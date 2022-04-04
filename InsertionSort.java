import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class InsertionSort {
    
    private final ArrayList<Integer> data;
    private final Duration timeElapsed;
    int sorts = 0;
    int comparisons = 0;

    public InsertionSort(int size){
        data = new ArrayList<>();
        Instant start = Instant.now();
        for (int i = 0; i < size; i++) {
            data.add((int)(Math.random() * (size+1)));
        }

        intRun();

        Instant end = Instant.now();   
        this.timeElapsed = Duration.between(start, end);
    }

    public InsertionSort(ArrayList<Integer> sample) {
        data = sample;
        Instant start = Instant.now();
        intRun();

        Instant end = Instant.now();   
        this.timeElapsed = Duration.between(start, end);
        
    }

    public void intRun(){
        
        int key;
        int temp;
        int temp2;

        for(int i = 1; i < data.size(); i++){
            key = data.get(i);
            temp2 = i-1;
            comparisons ++;
            while(temp2 >= 0 && key < data.get(temp2)){
                comparisons ++;
                temp = data.get(temp2);
                sorts++;
                data.set(temp2, data.get(temp2+1));
                data.set(temp2 + 1, temp);
                temp2--;

            }
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
