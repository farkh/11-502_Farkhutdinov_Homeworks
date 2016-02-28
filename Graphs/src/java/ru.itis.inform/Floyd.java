import java.math.*;

public class Floyd {
  private int[][] d;
  private int length;

  public Floyd(int[][] matrix) {
    initFloyd(matrix);
  }  

  public void initFloyd(int[][] matrix) {
    d = matrix;
    length = 5;
  }

  public void generate() {
    for (int k = 0; k < length; k++) {
      for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
          d[i][j] = Math.min(d[i][j], (d[i][k] + d[k][j]));
        } 
      }
    } 
  }

  public int[][] getArray() {
    return d;
  }

  public void showFloydMatrix() {
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        System.out.print(d[i][j] + ", ");
      }
      System.out.println();
    }
  }
}
