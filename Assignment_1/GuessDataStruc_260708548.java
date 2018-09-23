import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GuessDataStruc_260708548 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> rowsOfTestCases = readInput();
        for (ArrayList<Integer> tcRow : rowsOfTestCases) {
            break;
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