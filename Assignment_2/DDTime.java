import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DDTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numRequests = sc.nextInt();
        int serverCapacity = sc.nextInt();
        List<Integer[]> timeInOrOut = new ArrayList<>();
        for(int i = 0; i < numRequests; i++) {
            int newRequest = sc.nextInt();
            Integer[] timeIn = new Integer[2];
            Integer[] timeOut = new Integer[2];
            timeIn[0] = newRequest;
            timeIn[1] = 1;
            timeOut[0] = newRequest + 1000;
            timeOut[1] = -1;
            timeInOrOut.add(timeIn);
            timeInOrOut.add(timeOut);
        }
        sc.close();

        Collections.sort(timeInOrOut, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] timeAndType1, Integer[] timeAndType2) {
                int time1 = timeAndType1[0];
                int time2 = timeAndType2[0];
                return Integer.compare(time1, time2);
            }
        });

        double maxSimultaneousRequests = 0;
        int count = 0;
        for(Integer[] timeAndType: timeInOrOut) {
            count += timeAndType[1];
            if (count > maxSimultaneousRequests) {
                maxSimultaneousRequests = count;
            }
        }
        int maxServers = (int) Math.ceil(maxSimultaneousRequests/serverCapacity);
        System.out.println(maxServers);
    }
}