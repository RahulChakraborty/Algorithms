package graph;

/**
 * Created by rahulchakraborty on 8/7/16.
 */
public class GraphNode {
    int val;
    boolean visited;
    GraphNode[] neighbours;

    GraphNode(int x){
        val =x;
    }
    GraphNode(int x , GraphNode[] neighbours){
        val =x;
        this.neighbours =neighbours;
    }
}
