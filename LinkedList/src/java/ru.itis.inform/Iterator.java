public interface Iterator<T> {
  boolean hasNext();
  boolean hasPrevious();
  T next();
  T previous();
  //adds an element between next and previous
  void insert(T element);
  T peakNext();
  T peakPrevious();
}
