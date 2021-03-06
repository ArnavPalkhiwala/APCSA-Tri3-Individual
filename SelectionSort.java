import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class SelectionSort extends ParentSort{
    


    public SelectionSort(int size){
        sort(size);
    }
    public void sort(int size){
        Instant start = Instant.now();
        super.sort(size);
        intRun();
        Instant end = Instant.now();
        this.timeElapsed = Duration.between(start, end);
    }

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
                sorts += 1;
            }
        }

        
    }

}
