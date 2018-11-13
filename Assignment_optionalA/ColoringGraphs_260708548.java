import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Vertex {
    public Integer number;
    public int color;
    public ArrayList<Integer> neighbors;
    public boolean visited;

    Vertex(int i) {
        this.number = i;
        this.color = 0;
        this.neighbors = new ArrayList<Integer>();
        this.visited = false;
    }

}

public class ColoringGraphs_260708548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nV = sc.nextLine().split(" ");
        int numVertices = Integer.parseInt(nV[0]);
        ArrayList<Vertex> graph = new ArrayList<Vertex>();

        /**
         * adding the vertices to the
         * graph along with their neighbors
         */
        for(int i = 0; i < numVertices; i++) {
            Vertex v = new Vertex(i);
            String[] nbs = sc.nextLine().split(" ");
            for(int j = 0; j < nbs.length; j++) {
                if(nbs[j] != "") {
                    v.neighbors.add(Integer.parseInt(nbs[j]));
                }
            }
            graph.add(v);
        }
        sc.close();

        /**
         * sorting the graph in descending
         * order of vertex degrees
         */
        graph.sort(new Comparator<Vertex>() {
            @Override
            public int compare(Vertex v1, Vertex v2) {
                return Integer.compare(v2.neighbors.size(), v1.neighbors.size());
            }
        });


        int colorToUse = 0;
        /**
         * at each iteration of the while loop,
         * we start with the vertex with the highest degree
         * that has not been visited yet. if there exists such
         * a vertex, then we do not stop. we have to
         * refresh the stop value to true at the
         * beginning of every iteration. if all the
         * vertices have been visited, then stop remains
         * true and we will stop once we finish the current
         * iteration.
         */
        boolean stop = false;
        while(!stop) {
            stop = true;
            /**
             * first vertex to
             * obtain the new color
             */
            Vertex v = null;
            for(Vertex u: graph) {
                if(u.visited == false) {
                    /**
                     * if u has not been visited yet,
                     * we assign it a new color and
                     * set some other values.
                     */
                    u.visited = true;
                    u.color = colorToUse;
                    v = u;
                    stop = false;
                    colorToUse += 1;
                    break;
                }
            }

            /**
             * get all those vertices who have not been
             * visited yet and are not a part of
             * v's neighbor list. since they are not
             * neighbors of v, we can assign them the
             * same color as v.
             */
            for(Vertex p: graph) {
                if(!p.visited && !v.neighbors.contains(p.number)) {
                    p.visited = true;
                    p.color = v.color;
                }
            }
        }

        System.out.println(colorToUse);
    }
}