import java.util.*;

/**
 * class Vertex to store the vertex number
 * (between 0 and n-1) and the shortest
 * distance from the source vertex to it
 */
class Vertex {
    public int number;
    public Integer shortestDistance;
    public ArrayList<Edge> edges;

    Vertex(int num, int dist) {
        this.number = num;
        this.shortestDistance = dist;
    }

    public void addEdge(Edge e) {
        edges.add(e);
    }
}


class Edge {
    public Vertex startVertex;
    public Vertex endVertex;
    public int t0;
    public int P;
    public int traverseTime;

    Edge(Vertex u, Vertex v, int t0, int p, int timeToTraverse) {
        this.startVertex = u;
        this.endVertex = v;
        this.t0 = t0;
        this.P = p;
        this.traverseTime = timeToTraverse;
    }
}


public class ShortestPath_260708548 {
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // int[] sample = new int[] {53, 72, 19, 24, 35, 43};
        // for(int num: sample) {
        //     pq.add(num);
        // }
        // sample[0] = 3;
        // sample[2] = 12;
        // while(!pq.isEmpty()) {
        //     System.out.println(pq.poll());
        // }

        Scanner sc = new Scanner(System.in);
        while(true) {
            /**
             * First line of the test case
             */
            int numNodes = sc.nextInt();
            int numEdges = sc.nextInt();
            int numQueries = sc.nextInt();
            int sourceVertex = sc.nextInt();

            /**
             * Finished all the test cases
             */
            if(numNodes + numEdges + numQueries + sourceVertex == 0) {
                break;
            }

            /**
             * predecessors[i] will store the predecessor
             * of i in the shortest path obtained.
             */
            Vertex[] vertices = new Vertex[numEdges];
            Vertex[] predecessors = new Vertex[numNodes];
            init(distances, predecessors, numNodes, sourceVertex);

            /**
             * verticesDetermined - vertices whose final shortest-path
             * weights are determined
             * pq - keys will be shortest-path weights for the vertices
             */
            ArrayList<Vertex> verticesDetermined = new ArrayList<>();
            PriorityQueue<Vertex> pq = new PriorityQueue(new Comparator<Vertex>() {
                @Override
                public int compare(Vertex v1, Vertex v2) {
                    return v1.shortestDistance - v2.shortestDistance;
                }
            });

            for(int i = 0; i < numEdges; i++) {
                pq.add(vertices[i]);
            }




            while(!pq.isEmpty()) {
                Vertex u = pq.poll();
                verticesDetermined.add(u);


            }
            for(int i = 0; i < numEdges; i++) {
                int uVertex = sc.nextInt();
                int vVertex = sc.nextInt();
            }
        }
    }


    /**
     * initialize vertices having infinite distances
     * from the source vertex. setting predecessors
     * of all vertices to null. the shortest distance
     * of source vertex from source vertex is 0.
     */
    public static void init(Vertex[] vertices, Vertex[] predecessors, int n, int sourceVertex) {
        for(int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i, Integer.MAX_VALUE);
            predecessors[i] = null;
        }
        vertices[sourceVertex].shortestDistance = 0;
    }

}