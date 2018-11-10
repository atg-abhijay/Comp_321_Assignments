import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class OddBinCoeff_260708548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        // BigInteger[] factorials = new BigInteger[n];
        ArrayList<BigInteger> factorials = new ArrayList<BigInteger>();
        factorials.add(BigInteger.ONE);
        factorials.add(BigInteger.ONE);
        if(n.compareTo(BigInteger.ONE) == 0) {
            System.out.println(1);
            return;
        }
        final BigInteger TWO = new BigInteger("2");
        BigInteger numOddBinCoeff = new BigInteger("3");
        for(BigInteger i = TWO; i.compareTo(n) < 0; i = i.add(BigInteger.ONE)) {
            BigInteger jUpperBound = i.add(BigInteger.ONE).divide(TWO);
            for(BigInteger j = BigInteger.ZERO; j.compareTo(jUpperBound) < 0; j = j.add(BigInteger.ONE)) {

            }
            if(i.divideAndRemainder(TWO)[1].compareTo(BigInteger.ZERO) ==  0) {
                BigInteger numAtHalf = factorials.get(jUpperBound);
                if(numAtHalf.divideAndRemainder(TWO)[1]);
            }
        }
        System.out.println(numOddBinCoeff);
    }

    public static BigInteger calculateFactorial(ArrayList<BigInteger> factorials, BigInteger i, BigInteger j) {
        BigInteger factorialI = factorials.get(i);
        BigInteger factorialJ = factorials.get(j);

    }
}