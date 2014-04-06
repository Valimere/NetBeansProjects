/**
 * CMSC350
 * Final Project
 * Stephen Drollinger
 * Valimere@gmail.com
 * DATE 16 Aug 2013
 * NetBeans IDE 7.3
 */

package FinalProject;
import java.util.*;


public class SocialGraph<V> extends AbstractGraph<V>{
/** Construct an empty graph */
  public SocialGraph() {
  }
    
  /** Construct a graph from edges and vertices stored in arrays */
  public SocialGraph(int[][] edges, V[] vertices) {
    super(edges, vertices);
  }

  /** Construct a graph from edges and vertices stored in List */
  public SocialGraph(List<AbstractGraph.Edge> edges, List<V> vertices) {
    super(edges, vertices);
  }

  /** Construct a graph for integer vertices 0, 1, 2 and edge list */
  public SocialGraph(List<AbstractGraph.Edge> edges, int numberOfVertices) {
    super(edges, numberOfVertices);
  }
  
  /** Construct a graph from integer vertices 0, 1, and edge array */
  public SocialGraph(int[][] edges, int numberOfVertices) {
    super(edges, numberOfVertices);
  }
  // Tests whether the social graph is connected or not
  public static void isConnecteed (){

  }
  //
  public static int normalizedDegreeOfCentrality (List<Integer> edges, List<String> vertices){
      int nDOC = ((AbstractGraph.getDegree(vertices)) / AbstractGraph.getVertices(vertices));
      return nDOC;
  }
  public static void numberOfTrianglesIncidentToVertex (){
      
  }
  public void listOfTrianglesIncidentToVertex (){
      
  }
  public void isConclusterIndividual (){
      
  }
  public void AverageClustering (){
      
  }
  public void depthFirstSearch (){
      
  }
  public void BreadthFirstSearch (){
      
  }
    void printEdges() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
