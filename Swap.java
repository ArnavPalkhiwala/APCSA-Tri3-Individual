public class Swap{
  void run(int num1, int num2){
    int[] r = {num1, num2};
    System.out.println("Before: " + (r[0]) + " " + (r[1]));
    for(int i = 0; i < r.length; i++){
      if(r[i] < r[i+1]){
        int x = r[i];
        r[i] = r[i+1];
        r[i+1] = x;
        break;
      }
    }
    System.out.println("After: " + (r[0]) + " " + (r[1]));
    
  }
}