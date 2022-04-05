
import java.util.ArrayList;
import java.util.Scanner; 

public class Main {   
  
    static public void main(String[] args)  { 
        
        boolean everything = true;
        //menu options
        String[] choices = new String[]{"1 - Challenge 1", "2 - Calculator", "3 - Sorting", "0 - Quit"};

        Scanner scan = new Scanner(System.in);

        while(everything){ 

            System.out.println("-----------------------\n");
            System.out.println("Choose from these choices");
            System.out.println("-------------------------\n");
    /*
            System.out.println("1 - Challenge 1");
            System.out.println("2 - Calculator");
            System.out.println("3 - Sorting");   
            System.out.println("0 - Quit");
            */

            //not hard coded menu
            for(int i=0; i<choices.length; i++){
                System.out.println(choices[i]);
            }
            System.out.println("");

            String choice1 = scan.nextLine();

            switch(choice1){

                case "0":
                    everything = false;
                    break;

                case "1":
                    System.out.println("Challenge 1");
                    int[][] keypad = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, {0} };      
                    Matrix m = new Matrix(keypad);
                    System.out.println(m);
                    System.out.println("");
                    System.out.println("Challenge 2");
                    Swap swap = new Swap();
                    swap.run(10, 90);
                    System.out.println("Challenge 3");
                    System.out.println("");  
                            
                    Challenge1 c1 = new Challenge1();
                    c1.run();

                    break;
                        
                case "2":
                    try{ 
                        System.out.println("Enter your Calculation! Or QUIT ");
                        String expression = scan.nextLine();  
                                // a = 2
                                //pi = 3.1415
                        Calculator calc = new Calculator(expression.replaceAll("a", "3").replaceAll("b", "4"));
                        System.out.println(calc); 
                    }
                        
                    catch(Exception E){
                        System.out.println("This is invalid");
                    }
            
                    break;
                
                case "3":
                    int bubbleComparisons = 0;
                    int bubbleSwaps = 0;
                    double bubbleTime = 0;
                
                    int insertionComparisons = 0;
                    int insertionSwaps = 0;
                    double insertionTime = 0;
                
                    int mergeComparisons = 0;
                    int mergeSwaps = 0;
                    double mergeTime = 0;
                
                    int selectionComparisons = 0;
                    int selectionSwaps = 0;
                    double selectionTime = 0;
                    boolean run = true;
                    while(true){ 
                        System.out.println("-----------------------\n");
                        System.out.println("Choose from these choices");
                        System.out.println("-------------------------\n");
                
                        System.out.println("1 - Selection Sort");
                        System.out.println("2 - Merge Sort");
                        System.out.println("3 - Bubble Sort");
                        System.out.println("4 - Insertion Sort");
                        System.out.println("5 - Analytics (Avg. Time, Swaps, Comparisons) and Best Sort");       
                        System.out.println("0 - Quit");
                        System.out.println("");
                        
                        String sort = scan.nextLine();
                
                        int sum=0, TIMES=12, SIZE=5000, totalSwaps = 0;
                        long time = 0;
                        int comparison = 0;
                
                        switch(sort){
                            case "1":
                                for(int i=0; i< TIMES; i++) {
                                    SelectionSort s = new SelectionSort(SIZE);
                                    for(int j = 0; j<s.getData().size(); j++) {
                                        // System.out.println(s.getData()); //line to see the data
                                        sum += s.getData().get(j);
                                    }
                                    System.out.println("Average random: " + sum / ((i+1)*SIZE));
                                    System.out.println("Nanoseconds: " + s.getTimeElapsed());
                                    time += s.getTimeElapsed();
                
                                    comparison = s.getComparisons();
                                    totalSwaps = s.getSorts();
                                }
                                System.out.println("Average random: " + sum / (TIMES*SIZE));
                                System.out.println("Total Nanoseconds: " + time );
                                System.out.println("Total Seconds: " + time /1000000000.0);
                                System.out.println("Comparisons: " + comparison);
                                System.out.println("Swaps: " + totalSwaps);
                
                                selectionTime = (time/1000000000.0);
                                selectionComparisons = comparison;
                                selectionSwaps = totalSwaps;
                
                                break;
                
                            case "2":
                                for(int i=0; i< TIMES; i++) {
                                    MergeSort s = new MergeSort(SIZE);
                                    for(int j = 0; j<s.getData().size(); j++) {
                                        // System.out.println(s.getData()); //line to see the data
                                        sum += s.getData().get(j);
                                    }
                                    System.out.println("Average random: " + sum / ((i+1)*SIZE));
                                    System.out.println("Nanoseconds: " + s.getTimeElapsed());
                                    time += s.getTimeElapsed();
                
                                    comparison = s.getComparisons();
                                    totalSwaps = s.getSorts();
                                }
                                System.out.println("Average random: " + sum / (TIMES*SIZE));
                                System.out.println("Total Nanoseconds: " + time );
                                System.out.println("Total Seconds: " + time /1000000000.0);
                                System.out.println("Comparisons: " + comparison);
                                System.out.println("Swaps: " + totalSwaps);
                
                                mergeTime = (time/1000000000.0);
                                mergeComparisons = comparison;
                                mergeSwaps = totalSwaps;
                
                                break;
                
                
                            case "3":
                                for(int i=0; i< TIMES; i++) {
                                    BubbleSort s = new BubbleSort(SIZE);
                                    for(int j = 0; j<s.getData().size(); j++) {
                                            // System.out.println(s.getData()); //line to see the data
                                        sum += s.getData().get(j);
                                    }
                                    System.out.println("Average random: " + sum / ((i+1)*SIZE));
                                    System.out.println("Nanoseconds: " + s.getTimeElapsed());
                                    time += s.getTimeElapsed();
                
                                    comparison = s.getComparisons();
                                    totalSwaps = s.getSorts();
                                }
                                System.out.println("Average random: " + sum / (TIMES*SIZE));
                                System.out.println("Total Nanoseconds: " + time );
                                System.out.println("Total Seconds: " + time /1000000000.0);
                
                                bubbleTime = (time/1000000000.0);
                                bubbleComparisons = comparison;
                                bubbleSwaps = totalSwaps;
                
                                System.out.println("Comparisons: " + comparison);
                                System.out.println("Swaps: " + totalSwaps);
                
                                break;
                
                            
                            case "4":
                                for(int i=0; i< TIMES; i++) {
                                    InsertionSort s = new InsertionSort(SIZE);
                                    for(int j = 0; j<s.getData().size(); j++) {
                                            // System.out.println(s.getData()); //line to see the data
                                        sum += s.getData().get(j);
                                    }
                                    System.out.println("Average random: " + sum / ((i+1)*SIZE));
                                    System.out.println("Nanoseconds: " + s.getTimeElapsed());
                                    time += s.getTimeElapsed();
                
                                    comparison = s.getComparisons();
                                    totalSwaps = s.getSorts();
                                }
                                System.out.println("Average random: " + sum / (TIMES*SIZE));
                                System.out.println("Total Nanoseconds: " + time );
                                System.out.println("Total Seconds: " + time /1000000000.0);
                                insertionTime = (time/1000000000.0);
                                insertionComparisons = comparison;
                                insertionSwaps = totalSwaps;
                                System.out.println("Comparisons: " + comparison);
                                System.out.println("Swaps: " + totalSwaps);
                
                                break;
                
                            case "5":
                                ArrayList<Integer>comparisonList = new ArrayList<Integer>();
                                comparisonList.add(insertionComparisons);
                                comparisonList.add(selectionComparisons);
                                comparisonList.add(mergeComparisons);
                                comparisonList.add(bubbleComparisons);
                
                                int max = 0;
                                int min = 100000000;
                
                                for(int i = 0; i < comparisonList.size(); i++){
                                    if(comparisonList.get(i) < min){
                                        min = comparisonList.get(i);
                                    }
                                    if(comparisonList.get(i) > max){
                                        max = comparisonList.get(i);
                                    }
                                }
                
                                comparisonList.remove(comparisonList.indexOf(max));
                                comparisonList.remove(comparisonList.indexOf(min));
                
                                System.out.println("Avg # of Comparisons: " + (comparisonList.get(0) + comparisonList.get(1))/2);
                
                                ArrayList<Integer>swapsList = new ArrayList<Integer>();
                                swapsList.add(insertionSwaps);
                                swapsList.add(selectionSwaps);
                                swapsList.add(mergeSwaps);
                                swapsList.add(bubbleSwaps);
                
                                max = 0;
                                min = 100000000;
                
                                for(int i = 0; i < swapsList.size(); i++){
                                    if(swapsList.get(i) < min){
                                        min = swapsList.get(i);
                                    }
                                    if(swapsList.get(i) > max){
                                        max = swapsList.get(i);
                                    }
                                }
                
                                swapsList.remove(swapsList.indexOf(max));
                                swapsList.remove(swapsList.indexOf(min));
                
                                System.out.println("Avg # of Swaps: " + (swapsList.get(0) + swapsList.get(1))/2);
                
                
                                ArrayList<Double>timeList = new ArrayList<Double>();
                                timeList.add(insertionTime);
                                timeList.add(selectionTime);
                                timeList.add(mergeTime);
                                timeList.add(bubbleTime);
                
                                double max2 = 0;
                                double min2 = 100000000;
                
                                for(int i = 0; i < timeList.size(); i++){
                                    if(timeList.get(i) < min){
                                        min2 = timeList.get(i);
                                    }
                                    if(timeList.get(i) > max){
                                        max2 = timeList.get(i);
                                    }
                                }
                
                                // timeList.remove(timeList.indexOf(max2)+1);
                                // timeList.remove(timeList.indexOf(min2)-1);
                
                                System.out.println("Avg Times: " + (timeList.get(0) + timeList.get(1))/2 + " seconds");
                
                                System.out.println("It is clear that merge sort is the best sorting algorithm because it has the most efficient time of " + mergeTime + " seconds, with " + mergeComparisons + " comparisons, and " + mergeSwaps + " swaps");
                
                                break;
                            
                            case "0":
                                run = false;
                                break;
                        }

                }

        
        }

    }
      
    }

}