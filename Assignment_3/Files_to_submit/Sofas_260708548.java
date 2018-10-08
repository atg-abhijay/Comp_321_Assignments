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
            /**
             * Hashmap where -
             *      key: style
             *      value: hashset of colors available
             *              for that style
             * chose a hashset since we are interested
             * in taking intersections of sets of
             * colors available for different styles
             */
            HashMap<Integer, HashSet<Integer>> mapping = new HashMap<Integer, HashSet<Integer>>();
            int numSofasAvailable = sc.nextInt();
            /**
             * adding colors available
             * for different sofa styles
             */
            for(int j = 0; j < numSofasAvailable; j++) {
                int style = sc.nextInt();
                int color = sc.nextInt();
                if(!mapping.containsKey(style)) {
                    mapping.put(style, new HashSet<Integer>());
                }
                mapping.get(style).add(color);
            }

            // printMap(mapping);
            /**
             * now that we have a hashmap where
             * the key is the style and its value
             * is a hashset of the available colors
             * for that style, the approach is to
             * take intersection of the set of colors
             * available for different styles and find
             * the maximum size of the intersection.
             */

            /**
             * stores the maximum size of the
             * intersection calculated over
             * all the given styles. will
             * be used as final result.
             */
            int maxOverallIntersection = 1;
            /**
             * converting the keyset of styles
             * to a list of styles so that we
             * can pick one style and iterate
             * over the styles that come after it.
             */
            List<Integer> styles = new ArrayList<Integer>(mapping.keySet());
            for(int p = 0; p < styles.size() - 1; p++) {
                /**
                 * two parts -
                 * (i) first, we find the maximum size of the
                 *     intersection of colors. e.g. let it be 3.
                 *
                 * (ii) then, we find the number of styles that
                 *      had intersected with this specific style
                 *      and the intersection had a size of 3.
                 */
                /**
                 * for this specific style, keeping track
                 * of the size of the maximum intersection
                 * when taken with the styles that follow it.
                 */
                int sizeMaxIntersection = 0;
                for(int q = p+1; q < styles.size(); q++) {
                    /**
                     * have to create a new HashSet since
                     * when we call the retainAll() method,
                     * which basically allows us to do
                     * intersection of two sets, the method
                     * modifies the original set. so, we need a copy.
                     */
                    HashSet<Integer> intersection = new HashSet<Integer>(mapping.get(styles.get(p)));
                    intersection.retainAll(mapping.get(styles.get(q)));
                    int intersectionSize = intersection.size();
                    if(sizeMaxIntersection < intersectionSize) {
                        sizeMaxIntersection = intersectionSize;
                    }
                }
                /**
                 * part (i) is now complete
                 */

                int numMaxIntersectionSets = 1; // counting the style itself
                for(int q = p+1; q < styles.size(); q++) {
                    HashSet<Integer> intersection = new HashSet<Integer>(mapping.get(styles.get(p)));
                    intersection.retainAll(mapping.get(styles.get(q)));
                    if(intersection.size() == sizeMaxIntersection) {
                        numMaxIntersectionSets += 1;
                    }
                }
                /**
                 * part (ii) is now complete
                 */

                /**
                 * if the maximum overall size of the intersection
                 * is smaller than the maximum size of the intersection
                 * obtained from this specific style, then the overall
                 * size has to be updated. but, we only do this if the
                 * number of sets with this new maximum is at least as
                 * big as the maximum itself. this is so because we
                 * want a combination of k*k styles and colors. if we
                 * have fewer sets than the maximum, then we would not
                 * be able to have a k*k combination. we cannot touch
                 * the maximum and reduce it since that would change the
                 * result. but if we had extra sets, we could reduce
                 * them to match the maximum. we cannot work with
                 * sets fewer than the maximum.
                 */
                 if(maxOverallIntersection < sizeMaxIntersection) {
                    if(numMaxIntersectionSets >= sizeMaxIntersection) {
                        maxOverallIntersection = sizeMaxIntersection;
                    }
                }
            }
            System.out.println(maxOverallIntersection);
        }
        sc.close();
    }


    /**
     * utility method to print the hashmap
     */
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