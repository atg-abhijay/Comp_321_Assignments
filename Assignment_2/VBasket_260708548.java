import java.util.Scanner;

public class VBasket_260708548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numVegetables = sc.nextInt();
        int[] weights = new int[numVegetables];
        int maxWeight = 0;
        for (int i = 0; i < numVegetables; i++) {
            int weight = sc.nextInt();
            maxWeight += weight;
            weights[i] = weight;
        }
        sc.close();
        int totalWtBaskets = maxWeight;
    }
}