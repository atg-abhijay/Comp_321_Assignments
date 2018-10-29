import java.util.*;

public class HappyTelephones_260708548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int numCalls = sc.nextInt();
            int numIntervals = sc.nextInt();
            if(numCalls == 0 && numIntervals == 0) {
                break;
            }
            int[] startOfCalls = new int[numCalls];
            int[] endOfCalls = new int[numCalls];
            for(int i = 0; i < numCalls; i++) {
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