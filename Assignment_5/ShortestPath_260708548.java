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
    // public int weight;

    Edge(Vertex v, int t0, int p, int timeToTraverse) {
        this.endVertex = v;
        this.t0 = t0;
        this.P = p;
        this.traverseTime = timeToTraverse;
        // this.weight = w;
    }
}


public class ShortestPath_260708548 {
    // static int time = 0;
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
        // System.out.println("Welcome!");
        Scanner sc = new Scanner(System.in);
        while(true) {
            /**
             * First line of the test case
             */
            int numNodes = sc.nextInt();
            int numEdges = sc.nextInt();
            int numQueries = sc.nextInt();
            int sourceVertex = sc.nextInt();
            // System.out.println(numNodes + ", " + numEdges + ", " + numQueries + ", " + sourceVertex);

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
            Vertex[] predecessors = new Vertex[numNodes];
            init(vertices, predecessors, numNodes, sourceVertex);
            // for(int i = 0; i < vertices.length; i++) {
            //     Vertex v = vertices[i];
            //     System.out.println("Index: " + i + ", " + v.shortestDistance);
            // }

            /**
             * verticesDetermined - vertices whose final shortest-path
             * weights are determined
             * pq - keys will be shortest-path weights for the vertices
             */
            ArrayList<Vertex> verticesDetermined = new ArrayList<>();
            PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>(new Comparator<Vertex>() {
                @Override
                public int compare(Vertex v1, Vertex v2) {
                    return Integer.compare(v1.shortestDistance, v2.shortestDistance);
                }
            });

            for(int i = 0; i < numNodes; i++) {
                pq.add(vertices[i]);
            }
            // System.out.println("Added vertices to Priority Queue.");

            /**
             * adding edges connected to the vertices
             */
            for(int i = 0; i < numEdges; i++) {
                Vertex startVertex = vertices[sc.nextInt()];
                Edge e = new Edge(vertices[sc.nextInt()], sc.nextInt(),
                                  sc.nextInt(), sc.nextInt());
                startVertex.addEdge(e);
            }
            // System.out.println("Finished making and adding edges.");

            while(!pq.isEmpty()) {
                Vertex u = pq.peek();
                verticesDetermined.add(u);
                if(u.shortestDistance != Integer.MAX_VALUE) {
                    for(Edge e: u.edges) {
                        relaxEdge(u, e, predecessors);
                    }
                }
                pq.poll();
                Vertex[] pqArray = new Vertex[pq.size()];
                pqArray = pq.toArray(pqArray);
                pq = convertArrayToPQ(pqArray);
            }

            for(Vertex v: verticesDetermined) {
                if(v.shortestDistance == Integer.MAX_VALUE) {
                    System.out.println("Impossible");
                }
                else {
                    // System.out.println("Vertex #: " + v.number + ", Distance: " + v.shortestDistance);
                    System.out.println(v.shortestDistance);
                }
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


    public static void relaxEdge(Vertex startVertex, Edge e, Vertex[] predecessors) {
        Vertex v = e.endVertex;
        int timeMultiplier = 0;
        int timeWaited = 0;
        int time = startVertex.shortestDistance;
        while(true) {
            int permittedTime = e.t0 + timeMultiplier*e.P;
            if(time > permittedTime) {
                timeMultiplier += 1;
            }
            else if (time < permittedTime) {
                time += 1;
                timeWaited += 1;
            }
            else {
                int newTime = startVertex.shortestDistance + timeWaited + e.traverseTime;
                if(v.shortestDistance > newTime) {
                    v.shortestDistance = newTime;
                    // System.out.println(startVertex.number + ", " + v.number + ", " + v.shortestDistance);
                    predecessors[v.number] = startVertex;
                    break;
                }
            }
        }
    }


    public static PriorityQueue<Vertex> convertArrayToPQ(Vertex[] midExecutionVertices) {
        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>(new Comparator<Vertex>() {
            @Override
            public int compare(Vertex v1, Vertex v2) {
                return Integer.compare(v1.shortestDistance, v2.shortestDistance);
            }
        });

        for(int i = 0; i < midExecutionVertices.length; i++) {
            pq.add(midExecutionVertices[i]);
        }

        return pq;
    }
}