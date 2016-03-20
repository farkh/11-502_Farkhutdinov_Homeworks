package Jarvis;

/**
 * Created by farkh on 20/03/16.
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        initPoint(x, y);
    }

    private void initPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
