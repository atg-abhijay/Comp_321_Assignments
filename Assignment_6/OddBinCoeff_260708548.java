import java.util.Scanner;

public class OddBinCoeff_260708548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();

        double numOddBinCoeff = 0;
        char[] number = Long.toBinaryString(n).toCharArray();
        int numLength = number.length;
        int power = numLength-1;
        int twosPower = 0;
        for(int i = 0; i < numLength; i++) {
            if(number[i] == '1') {
                numOddBinCoeff += Math.pow(2, twosPower) * Math.pow(3, power);
                twosPower += 1;
            }
            power -= 1;
        }

        System.out.println((long) numOddBinCoeff);
    }
}