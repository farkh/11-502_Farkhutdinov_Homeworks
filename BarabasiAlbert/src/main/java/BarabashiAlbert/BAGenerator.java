package BarabashiAlbert;
import java.util.Random;

/**
 * Created by farkh on 05/05/16.
 */
public class BAGenerator {
    private final int DEFAULT_SIZE = 25;
    Random random = new Random();
    private int size;
    private int[][] graph;
    private int count;
    private int[] exponents;
    private int sumOfExp;

    public BAGenerator() {
        init(DEFAULT_SIZE);
    }

    public BAGenerator(int size) {
        init(size);
    }

    private void init(int size) {
        this.graph = new int[size][size];
        this.exponents = new int[size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
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
        this.size = size;
    }

    public void generate() {
        for (int i = 2; i < this.size; i++) {
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
        return compare(vertex);
    }

    private boolean compare(int vertex) {
        return random.nextInt() < calcP(vertex);
    }

    private int calcP(int vertex) {
        return exponents[vertex] * 100 / sumOfExp;
    }

    public void show() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size - 1; j++) {
                System.out.print(graph[i][j] + ", ");
            }
            System.out.println(graph[i][this.size - 1]);
        }
    }
}