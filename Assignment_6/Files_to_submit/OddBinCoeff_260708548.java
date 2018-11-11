import java.util.Scanner;

public class OddBinCoeff_260708548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();

        long numOddBinCoeff = 0;
        /**
         * how it works -
         * for any given number n, we convert
         * it into its binary representation.
         * e.g.
         * 1030 = 10000000110 in binary
         *      = 2^10 + 2^2 + 2^1
         *              |
         *              V
         *        3^10, 3^2, 3^1
         *
         * We attach certain coefficients to them and so -
         * T2(1030) = (2^0)*(3^10) + (2^1)*(3^2) + (2^2)*(3^1)
         *
         * Procedure:-
         * 1. Take binary number and express it as sum of powers of 2
         * 2. replace the 2's by 3's
         * 3. starting from the highest exponent of 3, assign coefficients
         *    (2^i) where i = 0, 1, 2 ...
         * 4. take sum of (coefficient)*(power of 3) terms
         */

        /*
         * getting the binary representation
         * of the input long number and turning
         * it into a char array so that we can
         * work with individual bits.
         */
        char[] number = Long.toBinaryString(n).toCharArray();
        int numLength = number.length;
        int threesPower = numLength-1;
        int twosPower = 0;
        for(int i = 0; i < numLength; i++) {
            /**
             * if the bit is set (=1), then we
             * follow the 'Procedure' mentioned above
             */
            if(number[i] == '1') {
                /**
                 * using iterative multiplication instead
                 * of Math.pow() since precision of
                 * calculation is not enough with Math.pow()
                 */
                /** (2^p) term */
                long firstTerm = 1;
                for(int j = 0; j < twosPower; j++) {
                    firstTerm *= 2;
                }
                /** (3^q) term */
                long secondTerm = 1;
                for(int j = 0; j < threesPower; j++) {
                    secondTerm *= 3;
                }
                numOddBinCoeff += firstTerm * secondTerm;
                /**
                 * twosPower only increases when we encounter a
                 * '1' bit while threesPower decreases by 1
                 * every iteration, irrespective of the bit we encounter.
                 */
                twosPower += 1;
            }
            threesPower -= 1;
        }

        System.out.println(numOddBinCoeff);
    }
}