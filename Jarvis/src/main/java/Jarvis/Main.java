package Jarvis;
import java.util.Scanner;

/**
 * Created by farkh on 20/03/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JarvisAlg jarvis = new JarvisAlg();
        int pointsNumber = 9;
        Point[] lot = new Point[pointsNumber];
        int x, y;

        lot[0] = new Point(1, 1);
        lot[1] = new Point(1, 3);
        lot[2] = new Point(2, 0);
        lot[3] = new Point(2, 2);
        lot[4] = new Point(2, 3);
        lot[5] = new Point(3, 2);
        lot[6] = new Point(3, 4);
        lot[7] = new Point(4, 1);
        lot[8] = new Point(4, 3);

        Point[] result = jarvis.findShell(lot);
        for (int i = 0; i < pointsNumber; i++) {
            if (result[i] != null) {
                System.out.println("( " + result[i].getX() + " " + ";" + " " + result[i].getY() + ");");
            }
        }
    }
}
