public class Main {
  public static void main(String[] args) {
     LinkedList<Integer> list = new LinkedList<>();

     list.add(5);
     list.add(3);
     list.add(8);


     Iterator<Integer> iterator = list.iterator();

     while (iterator.hasNext()) {
      System.out.println(iterator.next());
     }
  }
}
