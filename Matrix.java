public class Matrix{

  private final int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }


  @Override
  public String toString(){
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
    return reverse;
  }
  
}