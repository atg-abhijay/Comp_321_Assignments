import java.util.HashMap;
import java.util.Scanner;

public class AboutThatBase_260708548 {
    public static void main(String[] args) {
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

            for(int base = 2; base < 37; base++) {
                int firstNum = 0;
                int secondNum = 0;
                int resultNum = 0;
                try {
                    firstNum = Integer.parseInt(firstExpr, base);
                    secondNum = Integer.parseInt(secondExpr, base);
                    resultNum = Integer.parseInt(resultExpr, base);
                } catch (NumberFormatException e) {
                    continue;
                }

                boolean isEqual = checkEquality(firstNum, op, secondNum, resultNum);
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
}
