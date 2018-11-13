import java.beans.VetoableChangeListener;
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
        String[] letters = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        Scanner sc = new Scanner(System.in);
        String[] nV = sc.nextLine().split(" ");
        int numVertices = Integer.parseInt(nV[0]);
        ArrayList<Vertex> graph = new ArrayList<Vertex>();

        /**
         * adding the vertices to the
         * graph along with their neighbors
         */
        for(int i = 0; i < numVertices; i++) {
            // System.out.println("Iteration: " + i);
            Vertex v = new Vertex(i);
            String[] nbs = sc.nextLine().split(" ");
            // System.out.println("Length: " + nbs.length);
            for(int j = 0; j < nbs.length; j++) {
                if(nbs[j] != "") {
                    v.neighbors.add(Integer.parseInt(nbs[j]));
                }
            }
            graph.add(v);
        }

        graph.sort(new Comparator<Vertex>() {
            @Override
            public int compare(Vertex v1, Vertex v2) {
                return Integer.compare(v2.neighbors.size(), v1.neighbors.size());
            }
        });

        ArrayList<Integer> vertexNumbers = new ArrayList<Integer>();
        for(Vertex v: graph) {
            vertexNumbers.add(v.number);
        }

        int colorToUse = 0;
        boolean stop = false;
        while(!stop) {
            stop = true;
            Vertex v = null;
            for(Vertex u: graph) {
                if(u.visited == false) {
                    u.visited = true;
                    u.color = colorToUse;
                    v = u;
                    stop = false;
                    colorToUse += 1;
                    break;
                }
            }

            for(Vertex p: graph) {
                if(!p.visited && !v.neighbors.contains(p.number)) {
                    p.visited = true;
                    p.color = v.color;
                }
            }
        }

        // boolean stop = false;
        // while(!stop) {
        //     Vertex v = graph.get(0);
        //     if(v.visited = false) {
        //         v.color = colorToUse;
        //         v.visited = true;
        //     }

        //     for(Vertex u: graph) {
        //         if(!v.neighbors.contains(u.number)) {
        //             u.color = v.color;
        //             graph.remove(u);
        //         }
        //     }
        //     colorToUse += 1;
        // }

        System.out.println(colorToUse);
    }

    public static void printArray(ArrayList<Integer> vertexNums, String[] letters) {
        for(int i = 0; i < vertexNums.size(); i++) {
            System.out.print(letters[vertexNums.get(i)] + " ");
        }
        System.out.println();
    }
}