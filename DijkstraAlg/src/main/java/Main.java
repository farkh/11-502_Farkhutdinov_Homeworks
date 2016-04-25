
public class Main {
    public static void main(String[] args) {
        final int INF = Integer.MAX_VALUE;
        int[][] matrix = new int[][] {
                {INF, 7, 9, INF, INF, 14},
                {7, INF, 10, 15, INF, INF},
                {9, 10, INF, 11, INF, 2},
                {INF, 15, 11, INF, 6, INF},
                {INF, INF, INF, 6, INF, 9},
                {14, INF, 2, INF, 9, INF}
        };

        DijkstraAlgorithm algorithm = new DijkstraAlgorithm(matrix);
        algorithm.showDistance(algorithm.dijkstra(0));
    }
}
