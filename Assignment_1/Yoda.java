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

        int l1Size = l1.size();
        int l2Size = l2.size();
        int whichIsBigger = 0;

        // System.out.println(l1 + "\n" + l2);
        List<Integer> leftoverNums = new ArrayList<Integer>();
        int smallerLength = 0;
        if (l1Size > l2Size) {
            smallerLength = l2Size;
            whichIsBigger = 1;
            leftoverNums = l1.subList(smallerLength, l1Size);
        }
        else if (l2Size > l1Size) {
            smallerLength = l1Size;
            whichIsBigger = -1;
            leftoverNums = l2.subList(smallerLength, l2Size);
        }
        else {
            smallerLength = l1Size;
        }

        List<Integer> l1Modified = new ArrayList<Integer>();
        List<Integer> l2Modified = new ArrayList<Integer>();

        for (int i = 0; i < smallerLength; i++) {
            int l1Digit = l1.get(i);
            int l2Digit = l2.get(i);

            if (l1Digit - l2Digit > 0) {
                l1Modified.add(l1Digit);
            }
            else if (l2Digit - l1Digit > 0) {
                l2Modified.add(l2Digit);
            }
            else {
                l1Modified.add(l1Digit);
                l2Modified.add(l2Digit);
            }
        }

        if (whichIsBigger == 1) {
            l1Modified.addAll(leftoverNums);
        }
        else if (whichIsBigger == -1) {
            l2Modified.addAll(leftoverNums);
        }

        // l1Modified.forEach(System.out::println);
        // l2Modified.forEach(System.out::println);
        Collections.reverse(l1Modified);
        Collections.reverse(l2Modified);
        StringBuffer l1Output = new StringBuffer();
        StringBuffer l2Output = new StringBuffer();
        String l1Answer = "";
        String l2Answer = "";
        if (l1Modified.isEmpty()) {
            l1Answer = "YODA";
        }
        else {
            l1Modified.forEach(digit->l1Output.append(digit));
            l1Answer = Integer.parseInt(l1Output.toString()) + "";
        }


        if (l2Modified.isEmpty()) {
            l2Answer = "YODA";
        }
        else {
            l2Modified.forEach(digit->l2Output.append(digit));
            l2Answer = Integer.parseInt(l2Output.toString()) + "";
        }

        System.out.println(l1Answer);
        System.out.println(l2Answer);
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
        // Collections.reverse(numAsList);
        return numAsList;
    }
}