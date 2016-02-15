
class Main {
  public static void main(String[] args) {
    Graph graph = new Matrix();
    
    graph.addVertex();
    graph.addVertex();
    graph.addVertex();
    graph.addVertex();
    graph.addVertex();

    graph.addEdge(0, 2, 5);
    graph.addEdge(1, 0, 7);
    graph.addEdge(1, 4, 10);
    graph.addEdge(2, 1, 7);
    graph.addEdge(3, 2, 6);
    graph.addEdge(3, 4, 4);
    graph.addEdge(4, 2, 1);

    graph.showGraph();
  }
}
