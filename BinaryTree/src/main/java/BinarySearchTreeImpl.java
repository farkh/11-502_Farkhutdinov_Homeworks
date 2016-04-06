import java.util.LinkedList;
import java.util.Iterator;

/**
 * Created by farkh on 28/03/16.
 */
public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree {
    private Node<T> root;

    public BinarySearchTreeImpl() {
        this.root = null;
    }

    public void insert(int element) {
        if (this.root == null) {
            root = new Node(element);
            return;
        }

        Node node = new Node(element);
        insertRecursive(node, root);
    }

    public void insertRecursive(Node node, Node parent) {
        if (parent == null) {
            return;
        }

        if (node.getData().compareTo(parent.getData()) < 0) {
            if (parent.getLeft() == null) {
                parent.setLeft(node);
            } else {
                insertRecursive(node, parent.getLeft());
            }
        } else if (node.getData().compareTo(parent.getData()) > 0) {
            if (parent.getRight() == null) {
                parent.setRight(node);
            } else {
                insertRecursive(node, parent.getRight());
            }
        }
    }

    public boolean checkSums() {
        LinkedList<Node<T>> queue = new LinkedList<Node<T>>();
        Iterator iterator = queue.iterator();
        queue.add(this.root);

        int previous = 0;
        int current = 0;
        int level = 1;
        int count = 0;

        while (iterator.hasNext()) {
            Node<T> node = (Node<T>) iterator.next();

            if (node.getLeft() != null) {
                queue.add(node.getLeft());
                current += (Integer) node.getLeft().getData();
            }

            if (node.getRight() != null) {
                queue.add(node.getRight());
                current += (Integer) node.getRight().getData();
            }

            count += 2;
            if (Math.pow(2, level) == count) {
                if (previous > current) {
                    return false;
                }
                previous = current;
                current = 0;
                level++;
            }
        }
        return true;
    }

    public boolean checkForBinary(Node<T> node) {
        Node<T> left = node.getLeft();
        Node<T> right = node.getRight();

        boolean checkLeft = true;
        boolean checkRight = true;

        if (left != null && node.getData().compareTo(left.getData()) < 0) {
            checkLeft = false;
        }
        if (right != null && node.getData().compareTo(right.getData()) > 0) {
            checkRight = false;
        }

        if (checkLeft &&  checkRight) {
            return checkForBinary(left) && checkForBinary(right);
        } else {
            return false;
        }
    }

    private int sumLevel(LinkedList<Node<T>> queue) {
        Iterator iterator = queue.iterator();
        int sum = 0;

        while (iterator.hasNext()) {
            Node<T> node = (Node<T>) iterator.next();

            if (node.getData() != null) {
                sum += (Integer) node.getData();
            }
        }
        return sum;
    }

    private LinkedList<Node<T>> takeChildren(LinkedList<Node<T>> parent) {
        LinkedList<Node<T>> children = new LinkedList<Node<T>>();
        Iterator iterator = parent.iterator();

        while (iterator.hasNext()) {
            Node<T> node = (Node<T>) iterator.next();
            if (node.getLeft() != null) {
                children.add(node.getLeft());
            }
            if (node.getRight() != null) {
                children.add(node.getRight());
            }
        }
        return children;
    }

    //Returns true if the sum of the level values is greater than the sum of the previous level
    public boolean checkLevelsSum() {
        LinkedList<Node<T>> children = new LinkedList<Node<T>>();
        children.add(this.root);
        return checkSumsRec(children, 0);
    }


    private boolean checkSumsRec(LinkedList<Node<T>> children, int previous) {
        Iterator iterator = children.iterator();

        if (iterator.hasNext()) {
            int sum = sumLevel(children);

            if (sum >= previous) {
                return checkSumsRec(takeChildren(children), sum);
            } else {
                return false;
            }
        }
        return true;
    }

    private void showRec(Node<T> root, int level) {
        if (root != null) {
            showRec(root.getRight(), level + 1);

            for (int i = 0; i < level; i++) {
                System.out.print("---");
            }

            System.out.println(root.getData());

            showRec(root.getLeft(), level + 1);
        }
    }

    public void show() {
        showRec(this.root, 0);
    }
}
