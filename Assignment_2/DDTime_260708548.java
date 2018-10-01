import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DDTime_260708548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numRequests = sc.nextInt();
        int serverCapacity = sc.nextInt();
        /**
         * a list where each entry is an
         * Integer[] of size 2. the first entry in the
         * array is the time of the request and
         * the second entry is 1, if the time
         * denotes the arrival time of the request
         * or, it is (-1) if the time denotes the
         * ending time of the request.
         */
        List<Integer[]> timeInOrOut = new ArrayList<>();
        for(int i = 0; i < numRequests; i++) {
            int newRequest = sc.nextInt();
            Integer[] timeIn = new Integer[2];
            Integer[] timeOut = new Integer[2];
            timeIn[0] = newRequest;
            timeIn[1] = 1;
            /**
             * the request ends 1000 ms
             * after its arrival
             */
            timeOut[0] = newRequest + 1000;
            timeOut[1] = -1;
            timeInOrOut.add(timeIn);
            timeInOrOut.add(timeOut);
        }
        sc.close();

        /**
         * calling Collections.sort() to sort
         * the timeInOrOut list based on the
         * time values stored in the Integer
         * arrays. override the compare method
         * to compare the Integer arrays based
         * on the time values stored in the 0th index.
         */
        Collections.sort(timeInOrOut, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] timeAndType1, Integer[] timeAndType2) {
                int time1 = timeAndType1[0];
                int time2 = timeAndType2[0];
                return Integer.compare(time1, time2);
            }
        });

        /**
         * for each (+1) that we encounter,
         * we increase the count (or number
         * of simultaneous requests) by 1 and
         * for each (-1) encountered, we
         * decrease count by 1. record the
         * maximum number of simultaneous
         * requests throughout the process.
         */
        double maxSimultaneousRequests = 0;
        int count = 0;
        for(Integer[] timeAndType: timeInOrOut) {
            count += timeAndType[1];
            if (count > maxSimultaneousRequests) {
                maxSimultaneousRequests = count;
            }
        }
        /**
         * the max number of servers required
         * is calculated by taking the max number
         * of simultaneous requests, dividing it by
         * the server capacity and taking the ceiling
         * of the result.
         */
        int maxServers = (int) Math.ceil(maxSimultaneousRequests/serverCapacity);
        System.out.println(maxServers);
    }
}