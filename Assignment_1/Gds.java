import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Gds {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> rowsOfTestCases = readInput();
        for (ArrayList<Integer> tcRow : rowsOfTestCases) {
            /**
             * we will assume at the beginning that
             * all 3 data structures could be possible/true
             */
            boolean[] whichStructure = {true, true, true};
            String result = "";
            List<Integer> bagOfNumbers = new ArrayList<Integer>();
            for (Integer num : tcRow) {
                /**
                 * if num is positive, that means
                 * it is being added to the bag
                 */
                if (num > 0) {
                    bagOfNumbers.add(num);
                }
                /**
                 * if num is negative, it is
                 * being removed from the bag
                 */
                else {
                    result = evalBagAfterRemoval(bagOfNumbers, num * (-1), whichStructure);
                }
            }

            boolean isStack = whichStructure[0];
            boolean isQueue = whichStructure[1];
            boolean isPriorityQ = whichStructure[2];

            if (isStack && !isQueue && !isPriorityQ) {
                result = "stack";
            }
            else if (!isStack && isQueue && !isPriorityQ) {
                result = "queue";
            }
            else if (!isStack && !isQueue && isPriorityQ) {
                result = "priority queue";
            }
            /**
             * if two of them are
             * true at the same time
             */
            else if ((isStack && isQueue) || (isStack && isPriorityQ) || (isQueue && isPriorityQ)) {
                result = "not sure";
            }
            /**
             * if neither a stack, nor a
             * queue nor a priority queue
             */
            else if (!isStack && !isQueue && !isPriorityQ){
                result = "impossible";
            }
            System.out.println(result);
        }
    }


    public static String evalBagAfterRemoval(List<Integer> bagOfNumbers, Integer num, boolean[] whichStructure) {
        if (!bagOfNumbers.contains(num)) {
            return "impossible";
        }

        if (bagOfNumbers.size() != 0) {
            if (num != bagOfNumbers.get(bagOfNumbers.size()-1)) {
                //not stack
                whichStructure[0] = false;
            }
            if (num != bagOfNumbers.get(0)) {
                //not queue
                whichStructure[1] = false;
            }
            if (num != Collections.max(bagOfNumbers)) {
                //not priority queue
                whichStructure[2] = false;
            }
            bagOfNumbers.remove(num);
        }
        return "";
    }


    /**
     * Obtains all the input test cases.
     *
     * @return An arraylist of arraylist of integers.
     * Each arraylist (within the outer arraylist)
     * corresponds to one testcase. To differentiate
     * between numbers associated with type-1 and type-2
     * commands, numbers followed by a type-1 command
     * are inserted as is into the arraylist and those
     * after a type-2 command are multiplied by (-1).
     */
    public static ArrayList<ArrayList<Integer>> readInput() {
        ArrayList<ArrayList<Integer>> rowsOfTestCases = new ArrayList<ArrayList<Integer>>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int numLines = sc.nextInt();
            ArrayList<Integer> tcRow = new ArrayList<Integer>();
            for (int i = 0; i < numLines; i++) {
                int command = sc.nextInt();
                if (command == 1) {
                    tcRow.add(sc.nextInt());
                }
                else {
                    tcRow.add(sc.nextInt() * -1);
                }
            }
            rowsOfTestCases.add(tcRow);
        }
        sc.close();
        return rowsOfTestCases;
    }
}