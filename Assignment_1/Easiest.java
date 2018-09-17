import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Easiest {
    public static void main(String[] args) {
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

        for (int inputNum : inputList) {
            // int inputNum = sc.nextInt();
            if (inputNum != 0) {
                int inputNumSum = calculateSum(inputNum);
                boolean foundP = false;
                int p = 10;
                int product = inputNum * p;
                while (!foundP) {
                    product += inputNum;
                    p += 1;
                    int productSumOfDig = calculateSum(product);
                    if (productSumOfDig == inputNumSum) {
                        foundP = true;
                        System.out.println(p);
                    }
                }
            }
        }
    }


    public static int calculateSum(int number) {
        int sumOfDigits = 0;
        while (number > 0) {
            sumOfDigits += number % 10;
            number = number / 10;
        }
        return sumOfDigits;
    }
}
