import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Challenge1{

  public Challenge1(){
    
  }

  void run(){

    Scanner s = new Scanner(System.in);
    
    System.out.println("1 for adding elements to queue, 2 for deleting, 3 for merging queues, 4 for reversing queues with stack, and 5 to exit ");

    int choice = s.nextInt();

    if(choice == 1){
      static LinkedList<String> queue = new LinkedList<>();
      

    }

    if(choice == 3){
      System.out.println("Hello");
      
      Queue<Object> queue1 = new LinkedList<>(); 
      queue1.add(1);
      queue1.add(4);
      queue1.add(5);
      queue1.add(8);
      queue1.add("nil");

      System.out.println("Queue 1: " + queue1);

      Queue<Object> queue2 = new LinkedList<>(); 
      queue2.add(2);
      queue2.add(3);
      queue2.add(6);
      queue2.add(7);
      queue2.add("nil");

      Queue<Object> queue3 = new LinkedList<>(); 
      System.out.println("Queue 2: " + queue2);

     
      
      // while (queue1.size() > 0 || queue2.size() > 0) {
      //   if (queue1.size() == 0) {
      //     queue3.add(queue2.getFirst());
      //       queue2.removeFirst();
      //   } 
        
      //   else if (queue2.size() == 0) {
      //     queue3.add(a.getFirst());
      //     queue1.removeFirst();
      //   } 
        
      //   else {
      //     if (queue1.getFirst() > queue3.getFirst()) {
      //       queue3.add(queue1.getFirst());
      //       queue2.removeFirst();
      //     } 
          
      //     else {
      //       queue3.add(queue1.getFirst());
      //       queue1.removeFirst();
      //     }
      //   }
      // }
    
      System.out.println("Merge sorted queue " + queue3);
    }

    if(choice == 4){

      Stack<Integer> stack = new Stack<>();
      Queue<Integer> queue = new LinkedList<>(); 
      queue.add(1);
      queue.add(2);
      queue.add(3);

      System.out.println("Unreversed queue" + queue);

      int length = queue.size(); 

      for (int i = 0; i < length; i++ ) { 
        stack.push(queue.poll());
      }
      
      for (int i = 0; i < length; i++ ) { 
        queue.add(stack.pop());
      }
      
      System.out.println("Reversed queue" + queue);
    }

    else{
      System.exit(0);
    }
  }
}