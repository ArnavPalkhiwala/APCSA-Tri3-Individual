//something broke here
//don't know what but I changed ur code a bit so that it was less complicated than it needed to be
//it would break if i entered the same integer twice

public class Swap{
  void run(int num1, int num2){
  //  int[] r = {num1, num2};

    System.out.println("Before: " + num1 + " " + num2);
/*
    for(int i = 0; i < r.length; i++){
      if(r[i] < r[i+1]){
        int x = r[i];
        r[i] = r[i+1];
        r[i+1] = x;
        break;
      }
    }*/

    //simpler swap
    int temp= num1;
    num1= num2;
    num2=temp;

    System.out.println("After: " + num1 + " " + num2);
    
  }
}