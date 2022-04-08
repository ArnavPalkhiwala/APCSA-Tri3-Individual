import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class InsertionSort extends ParentSort{
    


    public InsertionSort(int size){
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

}
