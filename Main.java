
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

                //not hard coded menu
            for (String choice : choices) {
                System.out.println(choice);
            }


                String choice1 = scan.nextLine();

                switch (choice1) {

                    case "0":
                        everything = false;
                        break;

                    case "1":
                        //menu user interface for challenge 1 category
                        System.out.println("Challenge 1");
                       // int[][] keypad = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {0}};
                        String[] menu= new String[]{"1) Matrix", "2) Swap", "3) Queue fiddling"};
                        for (String value : menu) {
                            System.out.println(value);
                        }

                        //challenge 1 menu that leads to matrix, swap and queue stuff
                        String choice2= scan.nextLine();
                        Main.challenge1menu(choice2);
                        break;

                    case "2":
                        //calculator stuff
                        try {
                            Calculator allMath2 = new Calculator("200 % (300 + 5 + 300) / 200 + 1 * 100");
                            System.out.println("All Math2\n" + allMath2);
                            System.out.println("Refer to expression above for syntax");
                            System.out.println("Enter your Calculation! Or QUIT ");

                            String expression = scan.nextLine();
                            // a = 2
                            //pi = 3.1415
                            Calculator calc = new Calculator(expression.replaceAll("a", "3").replaceAll("b", "4"));
                            System.out.println(calc);
                        } catch (Exception E) {
                            System.out.println("This is invalid");
                        }

                        break;

// sort algo menu start here
                    case "3":
                        boolean run = true;

                        while (run) {


                            System.out.println("-----------------------\n");
                            System.out.println("Choose from these choices");
                            System.out.println("-------------------------\n");

                            String[] sorts= new String[]{"1 - Selection Sort", "2 - Merge Sort", "3 - Bubble Sort", "4 - Insertion Sort", "5 - Analytics (Avg. Time, Swaps, Comparisons) and Best Sort", "0 - Quit"};
                            for(String i: sorts){
                                System.out.println(i);
                                System.out.println("-----------");
                            }

                            String sort = scan.nextLine();
                            if(!sort.equals("5") && !sort.equals("0")) {
                                //starts sorting algo based on user input

                                Main.sortmenu(sort);
                            }
                            else if(sort.equals("5")){

                                //perform analysis method/class here
                                System.out.println(output.avgcompare());
                                System.out.println(output.avgswaps());
                                System.out.println(output.avgtime());

                              //concluding statement
                               System.out.println("It is clear that merge sort is the best sorting algorithm because it has the most efficient time of " + mergeTime + " seconds, with " + mergeComparison + " comparisons, and " + mergeSwap + " swaps");

                            }
                            else if(sort.equals("0")){
                                run =false;
                            }
                            else{
                                System.out.println("Invalid input");
                            }
                        }
                }
    }
      scan.close();
    }

    //cleaning up menu code to make it more readable
    public static void challenge1menu(String a){
        switch (a) {
            case "1" -> {
                Matrix m = new Matrix(Matrix.keypad());
                Matrix m1 = new Matrix(Matrix.numbers());
                System.out.println(m);
                System.out.println(m1);
            }
            case "2" -> {
                Scanner scan = new Scanner(System.in);
                System.out.println("Challenge 2");

                //user input for swaps
                System.out.println("Please input an integer: ");
                int num1 = scan.nextInt();
                System.out.println("Please input another integer: ");
                int num2 = scan.nextInt();

                Swap.run(num1, num2);
                System.out.println("Challenge 3");

            }
            case "3" -> {
                Challenge1 c1 = new Challenge1();
                c1.run();
            }
        }

    }

    //sorting menu improved to remove redundancy
    static int mergeSwap;
    static double mergeTime;
    static int mergeComparison;
    static Analysis output = new Analysis();
public static void sortmenu(String choice){
    int sum = 0, TIMES = 12, SIZE = 5000;

    int totalSwaps = 0;
    long time = 0;
    int comparison = 0;
    for (int i = 0; i < TIMES; i++) {

        ParentSort s ;

        //eliminating redundant code here by combining them
        //through polymorphism
        if(choice.equals("1")) {
            s = new SelectionSort(SIZE);
        }
       else if (choice.equals("2")) {
             s = new MergeSort(SIZE);
        }
       else if(choice.equals("4")) {
           s = new InsertionSort(SIZE);
        }
       else{
           s = new BubbleSort(SIZE);
        }

        for (int j = 0; j < s.getData().size(); j++) {
            // System.out.println(s.getData()); //line to see the data
            sum += s.getData().get(j);
        }
        System.out.println("Average random: " + sum / ((i + 1) * SIZE));
        System.out.println("Nanoseconds: " + s.getTimeElapsed());
        time += s.getTimeElapsed();

        comparison = s.getComparisons();
        totalSwaps = s.getSorts();
    }
    System.out.println("Average random: " + sum / (TIMES * SIZE));
    System.out.println("Total Nanoseconds: " + time);
    System.out.println("Total Seconds: " + time / 1000000000.0);
    System.out.println("Comparisons: " + comparison);
    System.out.println("Swaps: " + totalSwaps);

    //setting up data for analysis
    output.setSwaplist(totalSwaps);
    output.setComparisonlist(comparison);
    output.setTimeList(time);

    //added this to try and keep owners original intent for code purpose
        if(choice.equals("2")){
            mergeSwap=totalSwaps;
            mergeComparison=comparison;
            mergeTime=time;
        }
    }
}