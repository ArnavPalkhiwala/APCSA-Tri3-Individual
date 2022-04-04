import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class MergeSort {
    
    private final ArrayList<Integer> data;
    private final Duration timeElapsed;
    static int sorts = 0;
    static int comparisons = 0;
    int lowerIndex = 0;
    int higherIndex;

    public MergeSort(int size){
        data = new ArrayList<>();
        Instant start = Instant.now();
        for (int i = 0; i < size; i++) {
            data.add((int)(Math.random() * (size+1)));
        }

        this.higherIndex = data.size()-1;

        intRun(data, lowerIndex, higherIndex);

        Instant end = Instant.now();   
        this.timeElapsed = Duration.between(start, end);
    }

    public MergeSort(ArrayList<Integer> sample) {
        data = sample;
        Instant start = Instant.now();

        this.higherIndex = data.size()-1;

        intRun(data, lowerIndex, higherIndex);

        Instant end = Instant.now();   
        this.timeElapsed = Duration.between(start, end);
        
    }

    public static void intRun(ArrayList<Integer> list, int low, int high){

        if(low < high){
            int middle = (low+high)/2;
            intRun(list, low, middle);
            intRun(list, middle + 1, high);
            mergeMethod(list, low, middle, high);

        }
        
        
    }
    
    private static void mergeMethod(ArrayList<Integer> list, int low, int middle, int high) {
        int leftSize = middle - low + 1;
        int rightSize = high - middle;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for(int i = 0; i < leftSize; i++){
            leftArray[i] = list.get(low + 1);

        }

        for(int i = 0; i < rightSize; i++){
            rightArray[i] = list.get(middle + i);
            
        }

        int i = 0, j = 0, track = low;

        while(i < leftSize && j < leftSize){
            comparisons ++;
            sorts++;
            if(leftArray[i] < rightArray[j]){
                list.set(track, leftArray[i]);
                i++;
                track++;
            }

            else{
                list.set(track, rightArray[j]);
                i++;
                track++;
            }
        }

        while(i < leftSize){
            sorts ++;
            list.set(track, leftArray[i]);
            i++;
            track++;
        }

        while(j < rightSize){
            sorts ++;
            list.set(track, rightArray[j]);
            j++;
            track++;
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
