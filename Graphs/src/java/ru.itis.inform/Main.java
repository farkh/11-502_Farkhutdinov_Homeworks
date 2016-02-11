
class Main {
  public static void main(String[] args) {
    Graph graph = new Matrix();
    
    graph.addVertex();
    graph.addVertex();
    graph.addVertex();
    graph.addVertex();
    graph.addVertex();

    graph.addEdge(0, 2, 5);
    graph.addEdge(0, 3, 4);
    graph.addEdge(3, 4, 3);
    graph.addEdge(2, 1, 8);
    graph.addEdge(2, 4, 5);

    graph.showGraph();
  }
}
