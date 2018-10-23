import java.util.*;

public class ExactChange_260708548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();
        for(int i = 0; i < numTestCases; i++) {
            int itemPrice = sc.nextInt();
            int numBillsCoins = sc.nextInt();
            int[] billsCoins = new int[numBillsCoins];
            for(int j = 0; j < numBillsCoins; j++) {
                billsCoins[j] = sc.nextInt();
            }
            int[] answer = evaluateSolution(25001, billsCoins, numBillsCoins, itemPrice);
            System.out.println(answer[0] + " " + answer[1]);
        }
        sc.close();
    }


    public static int[] evaluateSolution(int capacity, int[] billsCoins, int numBillsCoins, int itemPrice) {
        Integer[][] dpValues = new Integer[numBillsCoins+1][capacity+1];
        dpValues[0][0] = 0;
        for(int i = 1; i < numBillsCoins+1; i++) {
            int idx = i-1;
            for(int j = 0; j < capacity + 1; j++) {
                if(dpValues[idx][j] == null) {
                    continue;
                }
                dpValues[i][j] = findMinimum(dpValues[i][j], dpValues[i-1][j]);

                int overallWt = j + billsCoins[idx];
                if(overallWt <= capacity) {
                    int overallVal = dpValues[i-1][j] + 1;
                    dpValues[i][overallWt] = findMinimum(overallVal, dpValues[i][overallWt]);
                }
            }
        }

        int[] returnValues = new int[2];
        for(int price = itemPrice; 1 > 0; price++) {
            if(dpValues[numBillsCoins][price] != null) {
                returnValues[0] = price;
                returnValues[1] = dpValues[numBillsCoins][price];
                return returnValues;
            }
        }
    }


    public static Integer findMinimum(Integer num1, Integer num2) {
        if(num1 == null) {
            return num2;
        }
        else if(num2 == null) {
            return num1;
        }

        return Math.min(num1, num2);
    }
}