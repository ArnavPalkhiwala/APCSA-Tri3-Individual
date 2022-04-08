import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class MergeSort extends ParentSort{
    

    public MergeSort(int size){
       sort(size);
    }
    public void sort(int size){
        Instant start = Instant.now();
        super.sort(size);
        this.higherIndex = data.size()-1;
        intRun(data, lowerIndex, higherIndex);
        Instant end = Instant.now();
        this.timeElapsed = Duration.between(start, end);

    }

//merge algo below
    public static void intRun(ArrayList<Integer> list, int low, int high){

        if(low < high){
            int middle = (low+high)/2;
            intRun(list, low, middle);
            intRun(list, middle + 1, high);
            mergeMethod(list, low, middle, high);

        }
        
        
    }
    
    public static void mergeMethod(ArrayList<Integer> list, int low, int middle, int high) {
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
}
