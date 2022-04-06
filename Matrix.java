public class Matrix{

  private final int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }
  public static int[][] keypad() {
    return new int[][]{ { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, {-1, 0, -1} };
  }

  // declare and initialize a random length arrays
  public static int[][] numbers() {
    return new int[][]{ { 0, 1 },
            { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
            { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 } };
  }

  @Override
  public String toString() {
      /*
    String s = "";
    String reverse = "";
    for(int i = 0; i < matrix.length; i++){
      for(int j = 0; j < matrix[i].length; j++){
        s += Integer.toString(matrix[i][j]);
      }
      s+="\n";
    }
    for(int i = s.length() - 1; i >= 0; i--){
      reverse += s.charAt(i);
    }
    return reverse;*/


    //traverse matrix array
    for(int i = 0; i<matrix.length; i++){
      for(int j =0; j<matrix[i].length; j++){
        if(matrix[i][j]>=0) {
          System.out.print(Integer.toHexString(matrix[i][j]));
          System.out.print(" ");
        }
        else{
          System.out.print("  ");
        }
      }
      System.out.println(" ");
    }
    System.out.println("");

    //reverse traversing array
    for (int i =matrix.length-1; i>=0; i--){
      for(int j=matrix[i].length-1; j>=0; j--){
        if(matrix[i][j]>=0) {
          System.out.print(Integer.toHexString(matrix[i][j]));
          System.out.print(" ");
        }
        else{
          System.out.print("  ");
        }
      }
      System.out.println(" ");
    }
    return "";
  }
  
}