package LinkedList;

import Farey.*;
import Iterator.*;

/**
 * Created by farkh on 20/02/16.
 */

public interface List<T> {
    void add(T Element);
    void remove(T Element);
    Iterator<T> iterator();
}
