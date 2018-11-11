import java.util.Scanner;

public class OddBinCoeff_260708548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();

        long numOddBinCoeff = 0;
        char[] number = Long.toBinaryString(n).toCharArray();
        int numLength = number.length;
        // for(char c: number) {
        //     System.out.print(c);
        // }
        // System.out.println();
        // System.out.println(numLength);
        int power = numLength-1;
        int twosPower = 0;
        for(int i = 0; i < numLength; i++) {
            if(number[i] == '1') {
                long firstTerm = 1;
                for(int j = 0; j < twosPower; j++) {
                    firstTerm *= 2;
                }
                long secondTerm = 1;
                for(int j = 0; j < power; j++) {
                    secondTerm *= 3;
                }
                numOddBinCoeff += firstTerm * secondTerm;
                twosPower += 1;
            }
            power -= 1;
        }

        System.out.println(numOddBinCoeff);
    }
}