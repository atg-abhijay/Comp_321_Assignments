import java.util.ArrayList;
import java.util.Scanner;

public class OddBinCoeff_260708548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();
        final long ZERO = (long) 0;
        final long ONE = (long) 1;

        if(n == 1) {
            System.out.println(1);
            return;
        }

        long numOddBinCoeff = ONE;
        boolean evenI = false;
        for(long i = ONE; i < n; i++) {
            for(long j = ZERO; j < (i+1)/2; j++) {
                if((i | (~j)) == -1) {
                    numOddBinCoeff += 2;
                }
            }
            if(evenI) {
                long jUpperBound = (i+1)/2;
                if((i | (~jUpperBound)) == -1) {
                    numOddBinCoeff += 1;
                }
            }
            evenI = !evenI;
        }
        System.out.println(numOddBinCoeff);
    }
}