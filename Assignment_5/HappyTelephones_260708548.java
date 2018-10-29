import java.util.*;

public class HappyTelephones_260708548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int numCalls = sc.nextInt();
            int numIntervals = sc.nextInt();
            /**
             * Marks end of test cases
             */
            if(numCalls == 0 && numIntervals == 0) {
                break;
            }
            /**
             * maintain two arrays to keep track
             * of the start and end of calls
             */
            int[] startOfCalls = new int[numCalls];
            int[] endOfCalls = new int[numCalls];
            for(int i = 0; i < numCalls; i++) {
                /**
                 * the source and destination
                 * of the calls are never used,
                 * so we can disregard them.
                 */
                sc.nextInt();
                sc.nextInt();
                int callStart = sc.nextInt();
                startOfCalls[i] = callStart;
                endOfCalls[i] = callStart + sc.nextInt();
            }
            for(int i = 0; i < numIntervals; i++) {
                int intervalStart = sc.nextInt();
                int intervalEnd = intervalStart + sc.nextInt();
                int numActive = 0;
                for(int j = 0; j < numCalls; j++) {
                    /**
                     * if the call ends before the interval starts
                     * or the call starts after the interval ends,
                     * then we have nothing to do.
                     *
                     * if this is not the case, then that call is
                     * active in the interval we are interested in.
                     */
                    if(endOfCalls[j] <= intervalStart || startOfCalls[j] >= intervalEnd) {
                        // do nothing
                    }
                    else {
                        numActive += 1;
                    }
                }
                System.out.println(numActive);
            }
        }
        sc.close();
    }
}