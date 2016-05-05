package BarabashiAlbert;
import java.util.Random;

/**
 * Created by farkh on 05/05/16.
 */
public class BAGenerator {
    private final int MAX_SIZE = 25;
    Random random = new Random();
    private int[][] graph;
    private int count;
    private int[] exponents;
    private int sumOfExp;

    public BAGenerator() {
        this.graph = new int[MAX_SIZE][MAX_SIZE];
        this.exponents = new int[MAX_SIZE];

        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                graph[i][j] = 0;
                graph[j][i] = 0;
            }
        }
        graph[0][1] = 1;
        graph[1][0] = 1;
        exponents[0] = 1;
        exponents[1] = 1;
        this.count = 2;
        this.sumOfExp = 2;
    }

    public void generate() {
        for (int i = 2; i < MAX_SIZE; i++) {
            for (int j = 0; j < count; j++) {
                if (isSuitable(j)) {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                    exponents[i]++;
                    exponents[j]++;
                    sumOfExp += 2;
                }
            }
            count++;
        }
    }

    private boolean isSuitable(int vertex) {
        if (random.nextInt() < exponents[vertex] * 100 / sumOfExp) {
            return true;
        } else {
            return false;
        }
    }

    public void show() {
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE - 1; j++) {
                System.out.print(graph[i][j] + ", ");
            }
            System.out.println(graph[i][MAX_SIZE - 1]);
        }
    }
}