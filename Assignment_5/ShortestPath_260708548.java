import java.util.*;

/**
 * class Vertex to store the vertex number
 * (between 0 and n-1), the shortest
 * distance from the source vertex to it
 * and the edges that originate from it.
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

/**
 * class Edge to store the endVertex of
 * the edge, and the details of its time constraints.
 */
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
    /**
     * constant large value used
     * for the initializations
     */
    final static int largeValue = (int) Math.pow(10, 8);
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

            Vertex[] vertices = new Vertex[numNodes];
            init(vertices, numNodes, sourceVertex);

            /**
             * pq - vertices arranged according to
             * minimum distance from the source vertex.
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
                /**
                 * get the vertex closest
                 * to the source vertex.
                 */
                Vertex u = pq.poll();
                if(u.shortestDistance != largeValue) {
                    for(Edge e: u.edges) {
                        relaxEdge(u, e, pq);
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
     * from the source vertex. the shortest distance
     * of source vertex from source vertex is 0.
     */
    public static void init(Vertex[] vertices, int n, int sourceVertex) {
        for(int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i, largeValue);
        }
        vertices[sourceVertex].shortestDistance = 0;
    }


    public static void relaxEdge(Vertex startVertex, Edge e, PriorityQueue<Vertex> pq) {
        Vertex v = e.endVertex;
        int timeMultiplier = 0;
        int timeWaited = 0;
        int time = startVertex.shortestDistance;
        int permittedTime = e.t0 + timeMultiplier*e.P;
        /**
         * if we are at a time greater than when
         * we are allowed to traverse the edge.
         */
        if(time > permittedTime) {
            /**
             * if it is zero, then we cannot
             * traverse this edge.
             */
            if(e.P != 0) {
                /**
                 * we calculate the new permitted time
                 * that we can traverse the edge at.
                 */
                double timeDiff = time-e.t0;
                timeMultiplier = (int) Math.ceil(timeDiff/e.P);
                permittedTime = e.t0 + timeMultiplier*e.P;
            }
            else {
                return;
            }
        }
        /**
         * how much time we had to wait.
         */
        timeWaited = permittedTime - time;
        int newTime = startVertex.shortestDistance + timeWaited + e.traverseTime;
        /**
         * if we can reach v in shorter time,
         * we update the value associated with it
         * and add it back to the queue if its
         * distance(or time) value changed since
         * now new possibilities may open up which
         * were not open before.
         */
        if(v.shortestDistance > newTime) {
            v.shortestDistance = newTime;
            pq.add(v);
        }
    }
}
