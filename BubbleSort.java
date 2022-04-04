import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class BubbleSort {
    
    private final ArrayList<Integer> data;
    private final Duration timeElapsed;
    int sorts = 0;
    int comparisons = 0;

    public BubbleSort(int size){
        data = new ArrayList<>();
        Instant start = Instant.now();
        for (int i = 0; i < size; i++) {
            data.add((int)(Math.random() * (size+1)));
        }

        intRun();

        Instant end = Instant.now();   
        this.timeElapsed = Duration.between(start, end);
    }

    public BubbleSort(ArrayList<Integer> sample) {
        data = sample;
        Instant start = Instant.now();
        intRun();

        Instant end = Instant.now();   
        this.timeElapsed = Duration.between(start, end);
        
    }

    public void intRun(){
        
        int temp = 0;

        for(int i = 0; i < data.size()-1; i++){
            for(int j = 0; j < data.size() - 1 - i; j++){
                comparisons ++;
                if(data.get(j) > data.get(j+1)){
                    sorts ++;
                    temp = data.get(j);
                    data.set(j, data.get(j+1));
                    data.set(j+1, temp);
                }  
                }
                
        }
        
    }

    public ArrayList<Integer> getData() {
        return data;
    }

    public int getTimeElapsed() {
        return timeElapsed.getNano();
    }

    public int getComparisons(){
        return comparisons;
    }

    public int getSorts(){
        return sorts;
    }
}
