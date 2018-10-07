import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Sofas_260708548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestScenarios = sc.nextInt();
        for(int i = 0; i < numTestScenarios; i++) {
            HashMap<Integer, HashSet<Integer>> mapping = new HashMap<Integer, HashSet<Integer>>();
            int numSofasAvailable = sc.nextInt();
            for(int j = 0; j < numSofasAvailable; j++) {
                int style = sc.nextInt();
                int color = sc.nextInt();
                if(!mapping.containsKey(style)) {
                    mapping.put(style, new HashSet<Integer>());

                }
                mapping.get(style).add(color);
            }
            // printMap(mapping);
            int maxOverallIntersection = 1;
            // int finalStyle = 0;
            List<Integer> styles = new ArrayList<Integer>(mapping.keySet());
            for(int p = 0; p < styles.size() - 1; p++) {
                int sizeMaxIntersection = 0;
                for(int q = p+1; q < styles.size(); q++) {
                    HashSet<Integer> intersection = new HashSet<Integer>(mapping.get(styles.get(p)));
                    intersection.retainAll(mapping.get(styles.get(q)));
                    int intersectionSize = intersection.size();
                    if(sizeMaxIntersection < intersectionSize) {
                        sizeMaxIntersection = intersectionSize;
                        // styleWithMaxIntersection = styles.get(p);
                    }
                }
                int numMaxIntersectionSets = 1;
                for(int q = p+1; q < styles.size(); q++) {
                    HashSet<Integer> intersection = new HashSet<Integer>(mapping.get(styles.get(p)));
                    intersection.retainAll(mapping.get(styles.get(q)));
                    if(intersection.size() == sizeMaxIntersection) {
                        numMaxIntersectionSets += 1;
                    }
                }

                if(maxOverallIntersection < sizeMaxIntersection) {
                    if(numMaxIntersectionSets >= sizeMaxIntersection) {
                        maxOverallIntersection = sizeMaxIntersection;
                        // finalStyle = styles.get(p);
                    }
                }
            }
            System.out.println(maxOverallIntersection);
        }
        sc.close();
    }


    public static void printMap(HashMap<Integer, HashSet<Integer>> mapping) {
        for(int style: mapping.keySet()) {
            System.out.print("Style " + style + ": ");
            HashSet<Integer> set = mapping.get(style);
            for(int color: set) {
                System.out.print(color + ", ");
            }
            System.out.println();
        }
    }
}