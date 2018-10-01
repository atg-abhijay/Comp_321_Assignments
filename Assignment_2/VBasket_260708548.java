import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class VBasket_260708548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numVegetables = sc.nextInt();
        int[] weights = new int[numVegetables];
        for (int i = 0; i < numVegetables; i++) {
            int weight = sc.nextInt();
            weights[i] = weight;
        }
        sc.close();

        BigInteger totalWtBaskets = new BigInteger("0");
        double numCases = Math.pow(2, numVegetables);
        for(int number = 0; number < numCases; number++) {
            int sumNums = 0;
            for(int k = 0; k < numVegetables; k++) {
                if ((number & (1 << k)) != 0) {
                    sumNums += weights[k];
                }
            }
            if(sumNums >= 200) {
                totalWtBaskets = totalWtBaskets.add(BigInteger.valueOf((long) sumNums));
            }
        }
        System.out.println(totalWtBaskets);
        // int totalWtBaskets = maxWeight;
        // int basketLowerBound = 200;
    }

    public static int findTotalWeight(int startingWeight, int[] weights) {
        int totalWtBaskets = 0;
        if(startingWeight < 200) {
            totalWtBaskets += startingWeight;
            return totalWtBaskets;
        }
        else {

        }
        return 0;
    }
}