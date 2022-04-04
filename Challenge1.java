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
    
    System.out.println("1 for adding elements to queue or deleting, 3 for merging queues, 4 for reversing queues with stack, and 5 to exit ");

    int choice = s.nextInt();
    
    LinkedList<Object> overallQueue = new LinkedList<>();
    overallQueue.add("Seven");

    //Checking if is add or delete
    if(choice == 1){
      boolean stop = false;
      while(!stop){
        System.out.print("Add or delete? ");

        //checking if this is add
        if(s.next().equalsIgnoreCase("Add")){
          System.out.println("Add to queue");
          overallQueue.add(s.next()); //getting the value user wanted added
          System.out.println("Current queue: " + overallQueue); //printing current queue
          System.out.println("Word count " + overallQueue.size()); //printing word count
        }

        else{ //if not add
          overallQueue.remove(); //removing from queue
          System.out.println("Current queue: " + overallQueue); //printing current queue
          System.out.println("Word count " + overallQueue.size()); //printing word count
        }

        System.out.println("Again? Type N to stop"); //check for conntinuation 
        if(s.next().equals("N")){
          stop = true; //stop here
        }
      }
    }

    if(choice == 3){ //merge sort
      System.out.println("Hello");
      
      Queue<Object> queue1 = new LinkedList<>(); //using linked list
      queue1.add(1);
      queue1.add(4);  //adding to queue
      queue1.add(5);
      queue1.add(8);
      queue1.add("nil");

      System.out.println("Queue 1: " + queue1); //printing queue1

      Queue<Object> queue2 = new LinkedList<>(); 
      queue2.add(2);
      queue2.add(3);//adding to queue
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
    
      System.out.println("Merge sorted queue " + queue3); //sorted queue

      run();

    }

    if(choice == 4){

      Stack<Integer> stack = new Stack<>(); //making stack
      Queue<Integer> queue = new LinkedList<>(); 
      queue.add(1);
      queue.add(2);
      queue.add(3);

      System.out.println("Unreversed queue" + queue);

      int length = queue.size(); 

      for (int i = 0; i < length; i++ ) { 
        stack.push(queue.poll()); //adding to stack
      }
      
      for (int i = 0; i < length; i++ ) { 
        queue.add(stack.pop()); //readding to queue
      }
      
      System.out.println("Reversed queue" + queue); //reverse que

      run();
    }

    else{
    }
  }
}