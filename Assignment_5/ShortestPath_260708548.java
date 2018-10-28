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
    // public int t0;
    // public int P;
    // public int traverseTime;
    public int weight;

    Edge(Vertex v, int w) {
        this.endVertex = v;
        // this.t0 = t0;
        // this.P = p;
        // this.traverseTime = timeToTraverse;
        this.weight = w;
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
            // int numQueries = sc.nextInt();
            int sourceVertex = sc.nextInt();
            System.out.println(numNodes + ", " + numEdges + ", " + sourceVertex);

            /**
             * Finished all the test cases
             */
            // if(numNodes + numEdges + numQueries + sourceVertex == 0) {
            //     break;
            // }

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
            System.out.println("Added vertices to Priority Queue.");

            /**
             * adding edges connected to the vertices
             */
            for(int i = 0; i < numEdges; i++) {
                Vertex startVertex = vertices[sc.nextInt()];
                Edge e = new Edge(vertices[sc.nextInt()],
                                  sc.nextInt());
                startVertex.addEdge(e);
            }
            System.out.println("Finished making and adding edges.");

            int count = 0;
            while(!pq.isEmpty()) {
                Vertex u = pq.peek();
                verticesDetermined.add(u);
                System.out.println("Edges relaxed:");
                for(Edge e: u.edges) {
                    relaxEdge(u, e, predecessors);
                }
                System.out.println();
                pq.poll();
                Vertex[] pqArray = new Vertex[pq.size()];
                pqArray = pq.toArray(pqArray);
                pq = convertArrayToPQ(pqArray);
                // Arrays.sort(pqArrayBefore, new Comparator<Vertex>() {
                //     @Override
                //     public int compare(Vertex v1, Vertex v2) {
                //         return Integer.compare(v1.shortestDistance, v2.shortestDistance);
                //     }
                // });
                // System.out.println("PQ state: ");
                // for(int i = 0; i < pqArrayBefore.length; i++) {
                //     System.out.println(pqArrayBefore[i].number + ", " + pqArrayBefore[i].shortestDistance);
                // }
                // System.out.println();
                // count += 1;
            }

            verticesDetermined.forEach(v->System.out.println("Vertex #: " + v.number + ", Distance: " + v.shortestDistance));
            break;
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
        if(v.shortestDistance > startVertex.shortestDistance + e.weight) {
            v.shortestDistance = startVertex.shortestDistance + e.weight;
            System.out.println(startVertex.number + ", " + v.number + ", " + v.shortestDistance);
            predecessors[v.number] = startVertex;
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