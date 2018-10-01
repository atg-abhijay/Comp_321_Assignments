import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int number = 13;
        int[] bits = new int[3];
        int shifted = number & (1 << 4);
        System.out.println(shifted);
        // for(int i = 2; i >= 0; i--) {
        //     bits[i] = number & (1 << i);
        // }
        // for(int bit: bits) {
        //     System.out.print(bit);
        // }
        // System.out.println();
        // double f = Math.pow(2, 40);
        // System.out.println(f);
    }

    public static void printList(List<Integer> list) {
        System.out.print("List: ");
        for(int num: list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}