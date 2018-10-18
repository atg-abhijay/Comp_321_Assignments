import java.util.*;

public class ExactChange_260708548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();
        // System.out.println("Number of Test Cases: " + numTestCases);
        for(int i = 0; i < numTestCases; i++) {
            int itemPrice = sc.nextInt();
            // System.out.println("Price of item: " + itemPrice);
            int numBillsCoins = sc.nextInt();
            // System.out.println("Number of Bills/Coins: " + numBillsCoins);
            List<Integer> billsCoins = new ArrayList<Integer>();
            // System.out.println("Bills/Coins:");
            for(int j = 0; j < numBillsCoins; j++) {
                billsCoins.add(sc.nextInt());
            }
            // System.out.println();
            // billsCoins.forEach(bc->System.out.println(bc));
        }
    }
}