import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class SelectionSort {
    
    private final ArrayList<Integer> data;
    private final Duration timeElapsed;
    int sorts = 5000;
    int comparisons = 0;

    public SelectionSort(int size){
        data = new ArrayList<>();
        Instant start = Instant.now();
        for (int i = 0; i < size; i++) {
            data.add((int)(Math.random() * (size+1)));
        }

        intRun();

        Instant end = Instant.now();   
        this.timeElapsed = Duration.between(start, end);
    }

    // public SelectionSort(ArrayList<Integer> sample) {
    //     data = sample;
        
    // }

    public void intRun(){
        
        int temp = 0;
        int smallestValue = 0;
        int minIndex = 0;

        for(int i = 0; i < data.size(); i++){
            smallestValue = data.get(i);
            minIndex = i;

            for(int j = i; j < data.size(); j++){
                comparisons ++;
                if(data.get(j) < smallestValue){
                    smallestValue = data.get(j);
                    minIndex = j;
                }
            }

            if(smallestValue < data.get(i)){
                temp = data.get(i);
                data.set(i, data.get(minIndex));
                data.set(minIndex, temp);
            }
        }

        
    }

    public ArrayList<Integer> getData() {
        return data;
    }

    public int getTimeElapsed() {
        return timeElapsed.getNano();
    }
}
