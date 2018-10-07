import java.util.HashMap;
import java.util.Scanner;

public class AboutThatBase_260708548 {
    public static void main(String[] args) {
        // test();
        /**
         * creating a mapping for each
         * number to a number/letter
         */
        HashMap<Integer, String> mapping = new HashMap<>();
        for(int i = 1; i < 10; i++) {
            mapping.put(i, i + "");
        }
        int start = 10;
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            mapping.put(start, alphabet + "");
            start += 1;
        }
        mapping.put(36, "0");
        // System.out.println("Mapping: " + mapping.get(2));

        /**
         * checking hashmap key, values
         */
        // for(int key: mapping.keySet()) {
        //     System.out.println(key + ": " + mapping.get(key));
        // }

        Scanner sc = new Scanner(System.in);
        int numExpressions = sc.nextInt();
        for(int i = 0; i < numExpressions; i++) {
            /**
             * obtaining the parts of the expression
             */
            String firstExpr = sc.next();
            String op = sc.next();
            String secondExpr = sc.next();
            // skipping over '=' symbol
            sc.next();
            String resultExpr = sc.next();
            StringBuilder outcome = new StringBuilder();
            boolean anyBaseAppended = false;
            /**
             * checking for base = 1
             */
            boolean base1 = isBase1(firstExpr, op, secondExpr, resultExpr);
            if (base1) {
                outcome.append("1");
                anyBaseAppended = true;
            }
            // System.out.println(firstExpr + ", " + op + ", " + secondExpr + ", " +  resultExpr);
            for(int base = 2; base < 37; base++) {
                int firstNum = 0;
                int secondNum = 0;
                int resultNum = 0;
                try {
                    firstNum = Integer.parseInt(firstExpr, base);
                    secondNum = Integer.parseInt(secondExpr, base);
                    resultNum = Integer.parseInt(resultExpr, base);
                    // System.out.println(firstNum + ", " + secondNum + ", " + resultNum);
                } catch (NumberFormatException e) {
                    continue;
                }

                boolean isEqual = checkEquality(firstNum, op, secondNum, resultNum);
                // System.out.println(base);
                // System.out.println(isEqual);

                if(isEqual) {
                    outcome.append(mapping.get(base));
                    anyBaseAppended = true;
                }
            }

            if (!anyBaseAppended) {
                System.out.println("invalid");
            }
            else {
                System.out.println(outcome.toString());
            }
        }
        sc.close();
        // test();
    }

    public static boolean checkEquality(int firstNum, String op, int secondNum, int resultNum) {
        boolean isEqual = false;
        switch (op) {
            case "+": isEqual = (firstNum + secondNum) == resultNum;
                        return isEqual;
            case "-": isEqual = (firstNum - secondNum) == resultNum;
                        return isEqual;
            case "*": isEqual = (firstNum * secondNum) == resultNum;
                        return isEqual;
            case "/": isEqual = ((double) firstNum / secondNum) == resultNum;
                        return isEqual;
        }
        return isEqual;
    }


    public static boolean isBase1(String firstExpr, String op, String secondExpr, String resultExpr) {
        String regex = "[1]+";
        boolean base1 = false;
        if(firstExpr.matches(regex) && secondExpr.matches(regex) && resultExpr.matches(regex)) {
            int firstNum = firstExpr.length();
            int secondNum = secondExpr.length();
            int resultNum = resultExpr.length();
            base1 = checkEquality(firstNum, op, secondNum, resultNum);
        }
        return base1;
    }

    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        StringBuilder sbReversed = sb.reverse();
        return sbReversed.toString();
    }

    public static void test() {
        // for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
        //     System.out.println(alphabet);
        // }
        // int result = Integer.parseInt("111111", 2);
        // System.out.println(result);
        String num = "1";
        String regex = "[1]+";
        if(num.matches(regex)) {
            System.out.println("yes - true");
        }
        else {
            System.out.println("no - false");
        }
    }
}