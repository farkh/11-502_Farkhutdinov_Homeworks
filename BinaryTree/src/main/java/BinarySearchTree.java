/**
 * Created by farkh on 28/03/16.
 */
public interface BinarySearchTree {
    void insert(int element);
    void insertRecursive(Node node, Node parent);
    void show();
    boolean checkLevelsSum();
}
