public interface DirectedGraph {
  void addVertex();
  void addDirectedEdge(int a, int b, int weight);
  void showGraph();
  void runFloyd();
}
