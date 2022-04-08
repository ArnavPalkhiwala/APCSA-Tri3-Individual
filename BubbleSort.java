import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class BubbleSort extends ParentSort{

    public BubbleSort(int size){
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


}
