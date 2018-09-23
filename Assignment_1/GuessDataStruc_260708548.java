import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class GuessDataStruc_260708548 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> rowsOfTestCases = readInput();
        for (ArrayList<Integer> tcRow : rowsOfTestCases) {

            int[] points = new int[3];
            String result = "";
            List<Integer> bagOfNumbers = new ArrayList<Integer>();
            for (int num : tcRow) {
                if (num > 0) {
                    bagOfNumbers.add(num);
                }
                else {
                    int outcome = evalBagAfterRemoval(bagOfNumbers, num * (-1), points);
                    if (outcome == -1) {
                        result = "impossible";
                        break;
                    }
                }
            }

            if (result != "impossible") {
                int stackPoints = points[0];
                int queuePoints = points[1];
                int priorityQueuePoints = points[2];
                boolean isStack = stackPoints != 0 && queuePoints == 0 && priorityQueuePoints == 0;
                boolean isQueue = queuePoints != 0 && stackPoints == 0 && priorityQueuePoints == 0;
                boolean isPriorityQueue = priorityQueuePoints != 0 && stackPoints == 0 && queuePoints == 0;

                if (isStack) {
                    result = "stack";
                }
                else if (isQueue) {
                    result = "queue";
                }
                else if (isPriorityQueue) {
                    result = "priority queue";
                }
                else if ((isStack && isQueue) || (isStack && isPriorityQueue) || (isQueue &&isPriorityQueue)) {
                    result = "not sure";
                }
            }

            System.out.println(result);
        }

    }


    public static int evalBagAfterRemoval(List<Integer> bagOfNumbers, int num, int[] points) {
        if (!bagOfNumbers.contains(num)) {
            return -1;
        }
        else {
            if (num == bagOfNumbers.get(0)) {
                points[1] += 1;
            }
            if (num == bagOfNumbers.get(bagOfNumbers.size()-1)) {
                points[0] += 1;
            }
            if (num == Collections.max(bagOfNumbers)) {
                points[2] += 1;
            }
            return 0;
        }
    }


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