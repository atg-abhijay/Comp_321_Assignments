import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Yoda_260708548 {
    public static void main(String[] args) {
        List<Integer> inputList = readInput();
        List<Integer> l1 = makeList(inputList.get(0));
        List<Integer> l2 = makeList(inputList.get(1));

        int l1Size = l1.size();
        int l2Size = l2.size();
        int whichIsBigger = 0;

        /**
         * list which stores the leftover digits
         * from whichever list of digits is bigger
         */
        List<Integer> leftoverDigits = new ArrayList<Integer>();
        int smallerLength = 0;
        if (l1Size > l2Size) {
            smallerLength = l2Size;
            whichIsBigger = 1;
            leftoverDigits = l1.subList(smallerLength, l1Size);
        }
        else if (l2Size > l1Size) {
            smallerLength = l1Size;
            whichIsBigger = -1;
            leftoverDigits = l2.subList(smallerLength, l2Size);
        }
        else {
            /**
             * the two lists are
             * of equal lengths
             */
            smallerLength = l1Size;
        }

        /**
         * these lists will store whatever digits
         * are left for the respective numbers
         * after the comparisons are done
         */
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
                /**
                 * if the digits are the same,
                 * both of them get added to
                 * their respective lists
                 */
                l1Modified.add(l1Digit);
                l2Modified.add(l2Digit);
            }
        }

        /**
         * depending on which list was
         * bigger, we add the leftover
         * digits to that modified list
         */
        if (whichIsBigger == 1) {
            l1Modified.addAll(leftoverDigits);
        }
        else if (whichIsBigger == -1) {
            l2Modified.addAll(leftoverDigits);
        }

        /**
         * the digits in the (modified) lists
         * are in reverse order to how they were
         * present in the numbers. we needed them
         * in reverse order till now since we were
         * making comparisons. now that we are finished
         * making comparions, we can put them back in order.
         */
        Collections.reverse(l1Modified);
        Collections.reverse(l2Modified);

        /**
         * more efficient to use StringBuffer
         * than to repeatedly concatenate to a String
         */
        StringBuffer l1Output = new StringBuffer();
        StringBuffer l2Output = new StringBuffer();

        /**
         * these will store the final answers
         */
        String l1Answer = "";
        String l2Answer = "";

        if (l1Modified.isEmpty()) {
            l1Answer = "YODA";
        }
        else {
            /**
             * the answer would have been just l1Output.toString() but
             * for cases where we have '00' as the output, it needs to
             * be converted to '0'. we use parseInt for that and then
             * convert that to a String once again.
             */
            l1Modified.forEach(digit->l1Output.append(digit));
            l1Answer = Integer.parseInt(l1Output.toString()) + "";
        }


        if (l2Modified.isEmpty()) {
            l2Answer = "YODA";
        }
        else {
            /**
             * same logic as for l1 above
             */
            l2Modified.forEach(digit->l2Output.append(digit));
            l2Answer = Integer.parseInt(l2Output.toString()) + "";
        }

        System.out.println(l1Answer);
        System.out.println(l2Answer);
    }


    /**
     *
     * @return list of input numbers
     */
    public static List<Integer> readInput() {
        List<Integer> inputList = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            inputList.add(sc.nextInt());
        }
        sc.close();

        return inputList;
    }


    /**
     *
     * @param num
     * @return the number is broken down into its
     * component digits and returned as a list of ints
     * whose order is REVERSED to that of the number.
     * we don't fix this while returning the list since
     * we need this reverse ordering to compare the numbers.
     *
     * e.g. numbers are 4567 and 389
     * currently, the lists returned would be -
     * [7, 6, 5, 4]
     * [9, 8, 3]
     * this is correct since the digits in the
     * right places/positions would be compared.
     * if the lists were reversed and returned -
     * [4, 5, 6, 7]
     * [3, 8, 9]
     * 4 is in the thousands place while 3 is in the
     * hundreds place. this would be incorrect since
     * they should not be compared.
     */
    public static List<Integer> makeList(int num) {
        List<Integer> numAsList = new ArrayList<Integer>();
        while (num > 0) {
            int digit = num % 10;
            numAsList.add(digit);
            num = num / 10;
        }
        return numAsList;
    }
}