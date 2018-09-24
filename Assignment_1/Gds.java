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
            boolean[] whichStructure = {true, true, true};
            String result = "";
            List<Integer> bagOfNumbers = new ArrayList<Integer>();
            for (int num : tcRow) {
                if (num > 0) {
                    bagOfNumbers.add(num);
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
                else if ((isStack && isQueue) || (isStack && isPriorityQ) || (isQueue && isPriorityQ)) {
                    result = "not sure";
                }
                else {
                    result = "impossible";
            }
            }

            // bagOfNumbers.forEach(System.out::println);
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

            Integer number = num;
            bagOfNumbers.remove(number);
            return 0;
        }
    }


    public static ArrayList<ArrayList<Integer>> readInput() {
        ArrayList<ArrayList<Integer>> rowsOfTestCases = new ArrayList<ArrayList<Integer>>();
        //guessthedatastructure_sample.in
        // File inputFile = new File("test");
        // try{
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
        // }

        // catch (Exception e) {
        //     System.out.println("some error!");
        // }

        // for (ArrayList<Integer> row : rowsOfTestCases) {
        //     row.forEach(number->System.out.print(number + " "));
        //     System.out.println();
        // }
        return rowsOfTestCases;
    }
}