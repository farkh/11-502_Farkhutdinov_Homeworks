/**
 * Created by farkh on 06/04/16.
 */
public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTreeImpl<Integer>();
        int[] array = { 6, 5, 11, 1, 10, 9, 2, 7, 8 };

        for (int i : array) {
            tree.insert(i);
        }

        tree.show();
        System.out.println(tree.checkLevelsSum());
    }
}
