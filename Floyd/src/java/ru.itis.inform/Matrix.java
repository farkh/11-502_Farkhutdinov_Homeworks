
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
  
  public void addEdge(int a, int b, int weight) {
    if (a < count_vertices && b < count_vertices) {
      //oriented graph
      this.matrix[a][b] = weight;
    } else throw new IllegalArgumentException();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (matrix[i][j] == 0 && i != j) { matrix[i][j] = 99; }
        else if (i == j) { matrix[i][j] = 0; }
      }
    }
  }

  public int getSize() {
    return this.max_size;
  }
  
  public void showGraph() {
    System.out.println("Original table:");
    for (int i = 0; i < count_vertices; i++) {
      for (int j = 0; j < count_vertices - 1; j++) {
        System.out.print(matrix[i][j] + ", ");
      }
      System.out.print(matrix[i][count_vertices - 1]);
      System.out.println();
    }
    System.out.println("<<------------------------------->>");
    System.out.println("Table after Floyd's Algorithm:");
    Floyd floydMatrix = new Floyd(matrix);
    floydMatrix.generate();
    floydMatrix.showMin();
  }
}
