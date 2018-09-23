import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class GuessDataStruc_260708548 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> rowsOfTestCases = readInput();
        for (ArrayList<Integer> tcRow : rowsOfTestCases) {

            boolean[] whichStructure = {true, true, true};
            String result = "";
            List<Integer> bagOfNumbers = new ArrayList<Integer>();
            // int bagMaxSize = 0;
            for (int num : tcRow) {
                if (num > 0) {
                    bagOfNumbers.add(num);
                    // int bagSize = bagOfNumbers.size();
                    // if (bagMaxSize < bagSize) {
                    //     bagMaxSize = bagSize;
                    // }
                }
                else {
                    int outcome = evalBagAfterRemoval(bagOfNumbers, num * (-1), whichStructure);
                    if (outcome == -1) {
                        result = "impossible";
                        break;
                    }
                }
            }

            if (result != "impossible") {
                // int stackPoints = whichStructure[0];
                // int queuePoints = whichStructure[1];
                // int priorityQueuePoints = whichStructure[2];
                // boolean isStack = stackPoints != 0 && queuePoints == 0 && priorityQueuePoints == 0;
                // boolean isQueue = queuePoints != 0 && stackPoints == 0 && priorityQueuePoints == 0;
                // boolean isPriorityQueue = priorityQueuePoints != 0 && stackPoints == 0 && queuePoints == 0;

                // boolean stackEqualToMax = stackPoints == bagMaxSize;
                // boolean queueEqualToMax = queuePoints == bagMaxSize;
                // boolean priorityQEqualToMax = priorityQueuePoints == bagMaxSize;
                // if (isStack || stackPoints - queuePoints == 1) {
                //     result = "stack";
                // }
                // else if (isQueue || queuePoints - stackPoints == 1) {
                //     result = "queue";
                // }
                // else if (isPriorityQueue) {
                //     result = "priority queue";
                // }
                // else if ((stackPoints != 0 && queuePoints != 0) || (stackPoints != 0 && priorityQueuePoints != 0) || (queuePoints != 0 && priorityQueuePoints != 0)) {
                //     result = "not sure";
                // }

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
                else {
                    result = "not sure";
                }
            }

            System.out.println(result);
            // System.out.println(Arrays.toString(whichStructure));
        }

    }


    public static int evalBagAfterRemoval(List<Integer> bagOfNumbers, int num, boolean[] whichStructure) {
        // bagOfNumbers.forEach(System.out::println);
        // System.out.println("---");
        if (!bagOfNumbers.contains(num)) {
            return -1;
        }
        else {
            if (num != bagOfNumbers.get(bagOfNumbers.size()-1)) {
                //stack
                whichStructure[0] = false;
            }
            if (num != bagOfNumbers.get(0)) {
                //queue
                whichStructure[1] = false;
            }
            if (num != Collections.max(bagOfNumbers)) {
                //priority queue
                whichStructure[2] = false;
            }

            Integer number = num;
            bagOfNumbers.remove(number);
            return 0;
        }
    }


    public static ArrayList<ArrayList<Integer>> readInput() {
        ArrayList<ArrayList<Integer>> rowsOfTestCases = new ArrayList<ArrayList<Integer>>();
        File inputFile = new File("./samples/guessthedatastructure_sample.in");
        try {
            Scanner sc = new Scanner(inputFile);
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
        } catch (Exception e) {
            System.out.println("Some error!");
        }

        return rowsOfTestCases;
    }


    // public static void test() {
    //     Scanner sc = new Scanner(System.in);
    //     int[] nums = new int[2];
    //     for(int i = 0; i < 2; i++) {
    //         int num = sc.nextInt();
    //         nums[i] = num;
    //     }
    //     for (int num : nums) {
    //         System.out.println(num);
    //     }
    // }
}