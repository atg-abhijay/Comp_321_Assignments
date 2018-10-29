import java.util.*;

/**
 * class Vertex to store the vertex number
 * (between 0 and n-1) and the shortest
 * distance from the source vertex to it
 */
class Vertex {
    public int number;
    public Integer shortestDistance;
    public ArrayList<Edge> edges = new ArrayList<Edge>();

    Vertex(int num, int dist) {
        this.number = num;
        this.shortestDistance = dist;
    }

    public void addEdge(Edge e) {
        edges.add(e);
    }
}


class Edge {
    public Vertex endVertex;
    public int t0;
    public int P;
    public int traverseTime;

    Edge(Vertex v, int t0, int p, int timeToTraverse) {
        this.endVertex = v;
        this.t0 = t0;
        this.P = p;
        this.traverseTime = timeToTraverse;
    }
}


public class ShortestPath_260708548 {
    static int largeValue = (int) Math.pow(10, 8);
    public static void main(String[] args) {
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
            Vertex[] vertices = new Vertex[numNodes];
            init(vertices, numNodes, sourceVertex);

            /**
             * verticesDetermined - vertices whose final shortest-path
             * weights are determined
             * pq - keys will be shortest-path weights for the vertices
             */
            PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>(new Comparator<Vertex>() {
                @Override
                public int compare(Vertex v1, Vertex v2) {
                    return Integer.compare(v1.shortestDistance, v2.shortestDistance);
                }
            });

            for(int i = 0; i < numNodes; i++) {
                pq.add(vertices[i]);
            }

            /**
             * adding edges connected to the vertices
             */
            for(int i = 0; i < numEdges; i++) {
                Vertex startVertex = vertices[sc.nextInt()];
                Edge e = new Edge(vertices[sc.nextInt()], sc.nextInt(),
                                  sc.nextInt(), sc.nextInt());
                startVertex.addEdge(e);
            }

            while(!pq.isEmpty()) {
                Vertex u = pq.poll();
                if(u.shortestDistance != largeValue) {
                    for(Edge e: u.edges) {
                        relaxEdge(u, e);
                    }
                }
            }

            for(int i = 0; i < numQueries; i++) {
                Vertex queryNode = vertices[sc.nextInt()];
                if(queryNode.shortestDistance == largeValue) {
                    System.out.println("Impossible");
                }
                else {
                    System.out.println(queryNode.shortestDistance);
                }

            }
            System.out.println();
        }
        sc.close();
    }


    /**
     * initialize vertices having infinite distances
     * from the source vertex. setting predecessors
     * of all vertices to null. the shortest distance
     * of source vertex from source vertex is 0.
     */
    public static void init(Vertex[] vertices, int n, int sourceVertex) {
        for(int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i, largeValue);
        }
        vertices[sourceVertex].shortestDistance = 0;
    }


    public static void relaxEdge(Vertex startVertex, Edge e) {
        Vertex v = e.endVertex;
        int timeMultiplier = 0;
        int timeWaited = 0;
        int time = startVertex.shortestDistance;
        int permittedTime = e.t0 + timeMultiplier*e.P;
        if(time > permittedTime) {
            if(e.P != 0) {
                double timeDiff = time-permittedTime;
                timeMultiplier = (int) Math.ceil(timeDiff/e.P);
                permittedTime = e.t0 + timeMultiplier*e.P;
            }
            else {
                return;
            }
        }
        timeWaited = permittedTime - time;
        int newTime = startVertex.shortestDistance + timeWaited + e.traverseTime;
        if(v.shortestDistance > newTime) {
            v.shortestDistance = newTime;
        }
    }
}
