import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Yoda {
    public static void main(String[] args) {
        List<Integer> inputList = read();
        // for (Integer num: inputList) {
        //     System.out.println(num);
        // }
        List<Integer> l1 = makeList(inputList.get(0));
        List<Integer> l2 = makeList(inputList.get(1));
        System.out.println(l1 + "\n" + l2);
    }


    public static List<Integer> read() {
        List<Integer> inputList = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            inputList.add(sc.nextInt());
        }
        sc.close();

        return inputList;
    }


    public static List<Integer> makeList(int num) {
        List<Integer> numAsList = new ArrayList<Integer>();
        while (num > 0) {
            int digit = num % 10;
            numAsList.add(digit);
            num = num / 10;
        }
        Collections.reverse(numAsList);
        return numAsList;
    }
}