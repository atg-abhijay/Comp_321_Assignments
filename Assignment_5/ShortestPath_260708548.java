import java.util.*;

public class ShortestPath_260708548 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(53);
        pq.add(72);
        pq.add(19);
        pq.add(24);
        pq.add(35);
        pq.add(43);
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    public static void init(int[] distances, int[] predecessors, int n, int sourceVertex) {
        for(int i = 0; i < n; i++) {
            distances[i] = Integer.MAX_VALUE;
            predecessors[i] = -1;
        }
        distances[sourceVertex] = 0;
    }

}