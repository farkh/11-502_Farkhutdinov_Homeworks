package ArrayList;
import LinkedList.*;
import sun.awt.image.ImageWatched;

/**
 * Created by farkh on 28/02/16.
 */
public class ArrayList<T> implements List<T> {
    private int size = 0;
    private final int DEFAULT_SIZE = 50;
    private Object[] elements;

    public ArrayList() {
        initArrayList(DEFAULT_SIZE);
    }

    public ArrayList(int size) {
        initArrayList(size);
    }

    public void initArrayList(int size) {
        elements = new Object[size];
    }

    public void add(T element) {
        set(size++, element);
    }

    public void set(int index, T element) {
        if (index < elements.length) {
            elements[index] = element;
        } else if (index == elements.length) {
            increase();
            elements[index] = element;
        } else { throw new IndexOutOfBoundsException(); }
    }

    public void increase() {
        Object[] newArray = new Object[size + 5];

        for (int i = 0; i < size; i++) {
            newArray[i] = elements[i];
        }

        this.elements = newArray;
        size = size + 5;
    }

    public T get(int index) {
        if (index < size && index > 0) {
            return (T) elements[index];
        } else { throw new IndexOutOfBoundsException(); }
    }

    public int getSize() {
        return this.size;
    }

    public LinkedList convertToList() {
        LinkedList converted = new LinkedList();

        for (int i = 0; i < elements.length; i++) {
            while (elements[i] != null) {
                LinkedList element;
                if (elements[i] instanceof LinkedList) {
                    element = (LinkedList) elements[i];
                } else {
                    element = new LinkedList();
                    element.add(elements[i]);
                }

                if (converted.getFirst() != null) {
                    converted = element;
                } else {
                    converted.append(element);
                }
            }
        }
        return converted;
    }



}
