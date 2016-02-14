
class Main {
  public static void main(String args[]) {
    FareySequenceGenerator sequence = new FareySequenceGenerator(6, 50);
    sequence.generate();  
    sequence.show();
  }
}  
