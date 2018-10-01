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

        /**
         * BigInteger to store the result
         * for high number of vegetables
         * and large weights
         */
        BigInteger totalWtBaskets = new BigInteger("0");
        /**
         * for n vegetables, the number of possible
         * combinations for the baskets are (2^n)-1
         */
        double numCases = Math.pow(2, numVegetables);
        /**
         * each case denotes a particular 0/1 combination
         * of the vegetables. this can be modelled using
         * binary numbers. a '1' for a certain position
         * means that that vegetable has been added to the
         * basket and a '0' means that it has not been added.
         *
         * we extract this bit for checking whether a specific
         * vegetable is included in the basket or not by
         * taking the number (aka case aka 0/1 combination)
         * and performing bitwise AND with a '1' leftshifted
         * k times (k for index of that specific vegetable
         * in the set of vegetables). if vegetable is part of
         * basket, we add it to the weight of the basket.
         * if the weight of the basket is >= 200 at the end,
         * we add the weight of that basket to the total weight
         * of all baskets.
         */
        for(int number = 0; number < numCases; number++) {
            int basketWeight = 0;
            for(int k = 0; k < numVegetables; k++) {
                if ((number & (1 << k)) != 0) {
                    basketWeight += weights[k];
                }
            }
            if(basketWeight >= 200) {
                totalWtBaskets = totalWtBaskets.add(BigInteger.valueOf((long) basketWeight));
            }
        }
        System.out.println(totalWtBaskets);
    }
}
