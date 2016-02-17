public class GraphMatrixImpl implements DirectedGraph, Graph {
  public final int DEFAULT_SIZE = 100;

  private int[][] matrix;
  private int countVertices;
  private int maxSize;

  public GraphMatrixImpl() {
    initGraph(DEFAULT_SIZE);
  }

  public GraphMatrixImpl(int maxSize) {
    initGraph(maxSize);
  }

  public void initGraph(int maxSize) {
    this.maxSize = maxSize;
    this.countVertices = 0;
    this.matrix = new int[maxSize][maxSize];
  }

  public void addVertex() {
    if (this.countVertices < this.maxSize) {
      this.countVertices++;
    } else throw new IllegalArgumentException();
  }

  public void addDirectedEdge(int a, int b, int weight) {
    if (a < countVertices && b < countVertices) {
      this.matrix[a][b] = weight;
    } else throw new IllegalArgumentException();
  }

  public void addEdge(int a, int b, int weight) {
    if (a < countVertices && b < countVertices) {
      this.matrix[a][b] = weight;
      this.matrix[b][a] = weight;
    } else throw new IllegalArgumentException();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (matrix[i][j] == 0 && i != j) { matrix[i][j] = 99; }
        else if (i == j) { matrix[i][j] = 0; }
      }
    }
  }

  public void showGraph() {
    for (int i = 0; i < countVertices; i++) {
      for (int j = 0; j < countVertices - 1; j++) {
        System.out.print(matrix[i][j] + ", ");
      }
      System.out.print(matrix[i][countVertices - 1]);
      System.out.println();
    }
  }
  
  public void runFloyd() {
    Floyd floydMatrix = new Floyd(matrix);
    floydMatrix.generate();
    floydMatrix.showFloydMatrix();
  }
}
