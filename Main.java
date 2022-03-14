
import java.util.Scanner; 
import java.util.ArrayList;

public class Main {   
  
    static public void main(String[] args)  {  
        Swap swap = new Swap();
        swap.run(10, 90);
        menu(8); 
    } 

    //Menu Code Below
    public static void menu(int numberOfOptions) {

      ArrayList<Integer>prints = new ArrayList<Integer>();
      boolean ran = false;

      try{
        int selection;  
        Scanner scan = new Scanner(System.in);  
        
        System.out.println("-----------------------\n");
        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
  
        System.out.println("1 - Hello");
        System.out.println("2 - Printy");
        System.out.println("3 - Loopy");
        System.out.println("4 - Classy Print");
        System.out.println("5 - Classy Poem");
        System.out.println("6 - Binary");
        System.out.println("7 - Termy");            
        System.out.println("0 - Quit");
        System.out.println("");
  
        for(int i = 0; i < numberOfOptions; i++){
          prints.add(i + 1);
        }
  
        selection = scan.nextInt();  
  
        
        for(int i = 0; i < prints.size(); i++){
          if(selection == prints.get(i)){
            System.out.println("You picked " + (i+1));
            ran = true;
          }
        }

        if(!ran){
          System.out.println("Invalid Selection");
        }
      }

      catch(Exception e){
        System.out.println("Not a number");
      }
       
      menu(8);
    }

}