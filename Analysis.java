import java.util.ArrayList;
import java.util.HashMap;

public class Analysis {

    //setter methods to build array data
    private final ArrayList<Integer> comparisonlist =  new ArrayList<>();
    private final ArrayList<Integer> swaplist = new ArrayList<>();
    private final ArrayList<Double> timeList = new ArrayList<>();



    public void setComparisonlist(int data){
        comparisonlist.add(data);

    }
    public void setSwaplist(int data){
        swaplist.add(data);

    }
    public void setTimeList(double data){
        timeList.add(data);

    }

    //computes average amount of comparisons
    public String avgcompare(){

        int avg=0;
        if(!this.timeList.isEmpty()) {
            for (int i : this.comparisonlist) {
                avg += i;
            }
            avg /= this.comparisonlist.size();
        }
        return "Avg # of Comparisons of sort tests: "+ avg;
    }

    //computes average amount of swaps
    public String avgswaps(){

        int avg=0;
        if(!this.timeList.isEmpty()) {
            for (int i : this.swaplist) {
                avg += i;
            }
            avg /= this.swaplist.size();
        }
        return "Avg # of Swaps: " + avg;
    }

    //computes avg runtime
    public String avgtime(){
        double avg=0;
        if(!this.timeList.isEmpty()) {
            for (double i : this.timeList) {
                avg += i;
            }
            avg /= Double.valueOf(this.timeList.size());
        }
        return "Avg Time: " + avg/1000000000.0+ " seconds";
    }


}
