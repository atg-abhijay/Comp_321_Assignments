import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EasiestProblem_260708548 {
    public static void main(String[] args) {
        List<Integer> inputList = readInput();
        for (int inputNum : inputList) {
            // sum of digits of the input number
            int inputNumSum = calculateSum(inputNum);
            boolean foundP = false;
            int p = 10;
            /**
             * Under the premise that addition is faster than
             * multiplication, instead of having to calculate inputNum*p
             * repeatedly, form the base number
             * (product) as inputNum*10 and add inputNum
             * to it at each iteration. increment p at
             * each iteration as well. Adding just the number
             * at each iteration is much simpler than having
             * to multiply with a brand new number.
             */
            int product = inputNum * p;
            while (!foundP) {
                product += inputNum;
                p += 1;
                int productSumOfDigits = calculateSum(product);
                if (productSumOfDigits == inputNumSum) {
                    foundP = true;
                    System.out.println(p);
                }
            }
        }
    }


    /**
     *
     * @return a list containing the input numbers
    */
    public static List<Integer> readInput() {
        List<Integer> inputList = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int inputNum = sc.nextInt();
            if (inputNum != 0) {
                inputList.add(inputNum);
            }
            else {
                break;
            }
        }
        sc.close();
        return inputList;
    }


    /**
     *
     * @param number
     * @return sum of the digits of the number
     */
    public static int calculateSum(int number) {
        int sumOfDigits = 0;
        while (number > 0) {
            sumOfDigits += number % 10;
            number = number / 10;
        }
        return sumOfDigits;
    }
}
