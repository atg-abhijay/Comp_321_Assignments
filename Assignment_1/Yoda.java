import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Yoda {
    public static void main(String[] args) {
        List<Integer> inputList = read();
        for (Integer num: inputList) {
            System.out.println(num);
        }
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
}