/**
 * Created by farkh on 28/03/16.
 */
public class Node<T extends Comparable<T>> {
    private Node<T> left;
    private Node<T> right;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getLeft() {
        return this.left;
    }

    public Node<T> getRight() {
        return this.right;
    }

    public T getData() {
        return this.data;
    }
}
