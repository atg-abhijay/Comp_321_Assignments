import java.util.*;

public class ExactChange_260708548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /**
         * reading in the input
         */
        int numTestCases = sc.nextInt();
        for(int i = 0; i < numTestCases; i++) {
            int itemPrice = sc.nextInt();
            int numBillsCoins = sc.nextInt();
            int[] billsCoins = new int[numBillsCoins];
            for(int j = 0; j < numBillsCoins; j++) {
                billsCoins[j] = sc.nextInt();
            }
            /**
             * the answer as returned as an int array.
             * the first entry is the amount of money
             * paid and the second is the number of bills used.
             */
            int[] answer = evaluateSolution(25001, billsCoins, numBillsCoins, itemPrice);
            System.out.println(answer[0] + " " + answer[1]);
        }
        sc.close();
    }


    public static int[] evaluateSolution(int capacity, int[] billsCoins, int numBillsCoins, int itemPrice) {
        /**
         * initializing an array to store
         * values pertaining to (number of bills
         * used, capacity)
         */
        Integer[][] dpValues = new Integer[numBillsCoins+1][capacity+1];
        dpValues[0][0] = 0;
        /**
         * rows serve to represent
         * the different bills
         */
        for(int i = 1; i < numBillsCoins+1; i++) {
            int idx = i-1;
            for(int j = 0; j < capacity + 1; j++) {
                /**
                 * don't need the null values.
                 * they will act as our positive,
                 * infinite, upper bound.
                 */
                if(dpValues[idx][j] == null) {
                    continue;
                }
                /**
                 * calling the separate function defined
                 * below to compute the minimum.
                 */
                dpValues[i][j] = findMinimum(dpValues[i][j], dpValues[i-1][j]);

                int overallWt = j + billsCoins[idx];
                /**
                 * updating values in dpValues if
                 * the overall weight is less than the
                 * capacity.
                 */
                if(overallWt <= capacity) {
                    int overallVal = dpValues[i-1][j] + 1;
                    dpValues[i][overallWt] = findMinimum(overallVal, dpValues[i][overallWt]);
                }
            }
        }

        int[] returnValues = new int[2];
        /**
         * after completion of above loop,
         * searching for first non-null value
         * and using it to return the price (or
         * amount of money paid) and the number
         * of bills used to make the payment.
         */
        for(int price = itemPrice; 1 > 0; price++) {
            if(dpValues[numBillsCoins][price] != null) {
                returnValues[0] = price;
                returnValues[1] = dpValues[numBillsCoins][price];
                return returnValues;
            }
        }
    }


    /**
     * have to define a different function
     * findMinimum since the array[][] contains
     * null values. as stated before, think of
     * the null values as positive infinity.
     * (therefore, any value would be less than null)
     * @param num1
     * @param num2
     * @return minimum between num1 and num2, which also
     * accomodates the fact that they may be null values
     */
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