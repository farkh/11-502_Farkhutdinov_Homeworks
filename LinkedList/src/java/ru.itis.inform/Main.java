public class Main {
  public static void main(String[] args) {
     LinkedList list = new LinkedList();

     for (int i = 1; i <= 10; i++) {
       list.add(i);
     }

     list.remove(1);
     list.remove(10);
     list.remove(6);

     list.show();
  }
}
