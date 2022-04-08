//something broke here
//don't know what but I changed ur code a bit so that it fit challenge description
//it would break if i entered the same integer twice

public class Swap{
  private int value;
  public Swap(int a){
    value =a;
  }
  public void swap(Swap a){
    int value= this.value;
    this.value=a.value;
    a.value=value;
  }
  public static void run(int num1, int num2){
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
    Swap a =  new Swap(num1);
    Swap b =  new Swap(num2);
    a.swap(b);
    System.out.println("After: " + num1 + " " + num2);
    
  }
}