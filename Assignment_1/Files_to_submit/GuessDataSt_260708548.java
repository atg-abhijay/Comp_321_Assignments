import java.util.*;

public class GuessDataSt_260708548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            String result = "";
            int numLines = sc.nextInt();

            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            /**
             * have to reverse priority queue since it
             * is minimum by default. we want maximum.
             */
            PriorityQueue<Integer> priorityq = new PriorityQueue<>(Collections.reverseOrder());

            /**
             * boolean values to check
             * what data structure we have
             */
            boolean isStack = true;
            boolean isQueue = true;
            boolean isPriorityQ = true;

            for(int i = 0; i < numLines; i++) {
                int commandType = sc.nextInt();
                int num = sc.nextInt();
                /**
                 * inserting numbers
                 */
                if (commandType == 1) {
                    /**
                     * if the data structure is
                     * still possible, we add
                     * the number to it.
                     */
                    if (isStack) {
                        stack.push(num);
                    }
                    if (isQueue) {
                        queue.add(num);
                    }
                    if (isPriorityQ) {
                        priorityq.add(num);
                    }
                }

                /**
                 * taking out numbers
                 */
                else {
                    int stackSize = stack.size();
                    int queueSize = queue.size();
                    int priorityqSize = priorityq.size();
                    /**
                     * if the data structure is still possible -
                     *      if the data structure is not empty
                     *      or the number to remove doesn't match
                     *      the number removed from the structure,
                     *      then that structure is no longer possible.
                     */
                    if (isStack) {
                        if (stackSize == 0 || !stack.pop().equals(num)) {
                            isStack = false;
                        }
                    }
                    if (isQueue) {
                        if (queueSize == 0 || !queue.remove().equals(num)) {
                            isQueue = false;
                        }
                    }
                    if (isPriorityQ) {
                        if (priorityqSize == 0 || !priorityq.remove().equals(num)) {
                            isPriorityQ = false;
                        }
                    }
                }
            }

            if (isStack && !isQueue && !isPriorityQ) {
                result = "stack";
            }
            else if (!isStack && isQueue && !isPriorityQ) {
                result = "queue";
            }
            else if (!isStack && !isQueue && isPriorityQ) {
                result = "priority queue";
            }
            /**
             * case where more than one structure is possible
             */
            else if ((isStack && isQueue) || (isStack && isPriorityQ) || (isQueue && isPriorityQ)) {
                result = "not sure";
            }
            /**
             * if no structure out of the 3 fits,
             * then we are in the case of impossible
             */
            else if (!isStack && !isQueue && !isPriorityQ) {
                result = "impossible";
            }
            System.out.println(result);
        }
        sc.close();
    }
}