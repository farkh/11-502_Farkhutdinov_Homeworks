
public class DijkstraAlgorithm {
    private final int INF = Integer.MAX_VALUE;
    private int vertexesNum;
    int[][] matrix;

    public DijkstraAlgorithm(int[][] matrix) {
        this.matrix = matrix;
        this.vertexesNum = matrix.length;
    }

    public int[] dijkstra (int startVert) {
        boolean[] marked = new boolean[vertexesNum];
        int[] distance = new int[vertexesNum];

        init(distance, INF);
        distance[startVert] = 0;

        //infinite loop
        for ( ; ; ) {
            int currentVertex = -1;

            for (int nextVertex = 0; nextVertex < vertexesNum; nextVertex++) {
                if (!marked[nextVertex] && distance[nextVertex] < INF && (currentVertex == -1 || distance[nextVertex] < distance[currentVertex])) {
                    currentVertex = nextVertex;
                }
            }

            if (currentVertex == -1) break;
            marked[currentVertex] = true;

            for (int nextVertex = 0; nextVertex < vertexesNum; nextVertex++) {
                if (!marked[nextVertex] && matrix[currentVertex][nextVertex] < INF) {
                    distance[nextVertex] = min(distance[nextVertex], distance[currentVertex] + matrix[currentVertex][nextVertex]);
                }
            }
        }
        return distance;
    }

    private void init(int[] matrix, int value) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = value;
        }
    }

    private int min(int a, int b) {
        if (a <= b) {
            return a;
        } else {
            return b;
        }
    }

    public void showDistance(int[] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i] + "; ");
        }
    }
}