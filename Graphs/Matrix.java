public class Matrix implements Graph {
  public final int DEFAULT_SIZE = 100;
  
  private int[][] matrix;
  private int count_vertices;
  private int max_size;
  
  public Matrix() {
    initGraph(DEFAULT_SIZE);
  }

  public Matrix(int maxSize) {
    initGraph(maxSize);
  }

  public void initGraph (int maxSize) {
    this.max_size = maxSize;
    this.count_vertices = 0;
    this.matrix = new int[maxSize][maxSize];
  }

  public void addVertex() {
    if (this.count_vertices < this.max_size) {  
      this.count_vertices++;  
    }
    else throw new IllegalArgumentException();
  }  
  
  public void addEdge(int a, int b) {
    this.matrix[a][b] = 1;
  }
  
  public void showGraph() {
    for (int i = 0; i < count_vertices; i++) {
      for (int j = 0; j < count_vertices - 1; j++) {
        System.out.print(matrix[i][j] + ", ");
      }
      System.out.print(matrix[i][count_vertices - 1]);
      System.out.println();
    }
  }
}
