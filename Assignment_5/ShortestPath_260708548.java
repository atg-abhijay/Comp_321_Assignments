import java.util.*;

class Vertex {
    public int index;
    public Integer shortestDistance;

    Vertex(int idx, int dist) {
        this.index = idx;
        this.shortestDistance = dist;
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
             * distances[i] will store the shortest
             * distance of i from the source vertex.
             * predecessors[i] will store the predecessor
             * of i in the shortest path obtained.
             */
            int[] distances = new int[numEdges];
            int[] predecessors = new int[numNodes];
            init(distances, predecessors, numNodes, sourceVertex);

            /**
             * verticesDetermined - vertices whose final shortest-path
             * weights are determined
             * pq - keys will be shortest-path weights distances[i]
             */
            ArrayList<Integer> verticesDetermined = new ArrayList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i = 0; i < numEdges; i++) {
                pq.add(distances[i]);
            }

            /**
             * will keep track of the shortest path
             * formed througout the graph
             */

            while(!pq.isEmpty()) {
                int minDistance = pq.poll();

            }
            for(int i = 0; i < numEdges; i++) {
                int uVertex = sc.nextInt();
                int vVertex = sc.nextInt();
            }
        }
    }


    /**
     * initialize distance from source vertex for
     * all vertices to be infinity except distance
     * of source vertex from itself, which is 0.
     * set the predecessors of each of the vertices to -1.
     */
    public static void init(int[] distances, int[] predecessors, int n, int sourceVertex) {
        for(int i = 0; i < n; i++) {
            distances[i] = Integer.MAX_VALUE;
            predecessors[i] = -1;
        }
        distances[sourceVertex] = 0;
    }

}