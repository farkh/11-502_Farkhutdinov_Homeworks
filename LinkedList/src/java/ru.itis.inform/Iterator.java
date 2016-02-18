public interface Iterator<T> {
  boolean hasNext();
  T next();
  T previous();
  //adds an element between next and previous
  void insert(T element);
}
