package LinkedList;

/**
 * Created by farkh on 15/03/16.
 */
public class LinkedList<T extends Comparable<T>> implements List<T> {
    private Node<T> first;
    private Node<T> last;
    private int length;

    public LinkedList() {
        this.first = null;
        this.last = null;
        length = 0;
    }

    public Node<T> getFirst() {
        return this.first;
    }

    public Node<T> getLast() {
        return this.last;
    }

    public int getLength() {
        return this.length;
    }

    public void setFirst(Node<T> node) {
        this.first = node;
    }

    public void add(T element) {
        Node<T> newElement = new Node<T>(element);
        if (first == null) {
            this.first = newElement;
            this.last = newElement;
        } else {
            this.last.setNext(newElement);
            newElement.setPrevious(this.last);
            this.last = newElement;
        }
        this.length++;
    }

    public void insert(Node<T> previous, T element, Node<T> next) {

    }

    public void remove(T element) {
        Node<T> currElement = this.first;

        //check for
        for (int i = 0; i < length; i++) {
            if (i == 0 && currElement.getValue() == element) {
                first.getNext().setPrevious(null);
                this.first = first.getNext();
                length--;
                return;
            }

            if (currElement.getNext().getValue() == element) {
                if (i == length - 2) {
                    currElement.setNext(null);
                    length--;
                    return;
                } else {
                    Node<T> afterRemoving = currElement.getNext().getNext();
                    currElement.setNext(afterRemoving);
                    afterRemoving.setPrevious(currElement);
                    length--;
                    return;
                }
            }
            currElement = currElement.getNext();
        }
    }

    public void showList() {
        Node<T> showingElement = this.first;

        while (showingElement != null) {
            showingElement.show();
            showingElement = showingElement.getNext();
        }
    }

    public void append(LinkedList list) {
        this.first.setPrevious(list.getLast());
        list.getLast().setNext(this.first);
        this.first = list.getFirst();
        this.length += list.getLength();
    }

    public boolean checkEquals(LinkedList<T> second) {
        Node<T> elemFirst = this.first;
        Node<T> elemSecond = second.getFirst();

        if (this.length != second.getLength()) {
            return false;
        }
        while (elemFirst != null) {
            if (elemFirst.getValue() != elemSecond.getValue()) {
                return false;
            }
            elemFirst = elemFirst.getNext();
            elemSecond = elemSecond.getNext();
        }
        return true;
    }

    public static <T extends Comparable<T>> LinkedList merge(LinkedList<T> first, LinkedList<T> second) {
        LinkedList<T> merged = new LinkedList<T>();
        Node<T> firstNode = first.getLast();
        Node<T> secondNode = second.getLast();

        while (firstNode != null && secondNode != null) {
            while (firstNode.getValue().compareTo(secondNode.getValue()) > 0 && secondNode.getPrevious() != null) {
                merged.add(secondNode.getValue());
                secondNode = secondNode.getPrevious();
            }
            if (firstNode.getValue().compareTo(secondNode.getValue()) > 0 && secondNode.getPrevious() == null) {
                merged.add(secondNode.getValue());
                secondNode = secondNode.getPrevious();
                break;
            }

            while (firstNode.getValue().compareTo(secondNode.getValue()) <= 0 && firstNode.getPrevious() != null) {
                merged.add(firstNode.getValue());
                firstNode = firstNode.getPrevious();
            }
            if (firstNode.getValue().compareTo(secondNode.getValue()) <= 0 && firstNode.getPrevious() == null) {
                merged.add(firstNode.getValue());
                firstNode = firstNode.getPrevious();
                break;
            }
        }

        Node<T> remaining = null;

        if (firstNode != null) {
            remaining = firstNode;
        } else if (secondNode != null) {
            remaining = secondNode;
        }

        while (remaining != null) {
            merged.add(remaining.getValue());
            remaining = remaining.getPrevious();
        }

        return merged;
    }

}
