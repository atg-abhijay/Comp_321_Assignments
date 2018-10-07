import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sofas_260708548 {
    public static void main(String[] args) {
        HashMap<Integer, HashSet<Integer>> mapping = new HashMap<Integer, HashSet<Integer>>();
        Scanner sc = new Scanner(System.in);
        int numTestScenarios = sc.nextInt();
        for(int i = 0; i < numTestScenarios; i++) {
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
        }
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