import java.util.ArrayList;
import java.util.Scanner;

public class DisastDowntime_260708548 {
    public static void main(String[] args) {
        // test();
        Scanner sc = new Scanner(System.in);
        int upcomingRequests = sc.nextInt();
        int serverRequestsPerSecond = sc.nextInt();
        ArrayList<ArrayList<Integer>> serversList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < serversList.size(); i++) {
            serversList.add(new ArrayList<Integer>(serverRequestsPerSecond));
        }
        for(int i = 0; i < upcomingRequests; i++) {
            boolean addedRequest = false;
            int newRequest = sc.nextInt();
            while (!addedRequest) {
                for (int j = 0; j < serversList.size(); j++) {
                    ArrayList<Integer> server = serversList.get(j);
                    if (server.size() != serverRequestsPerSecond) {
                        server.add(newRequest);
                        addedRequest = true;
                        break;
                    }
                }
                if (!addedRequest) {
                    serversList.add(new ArrayList<Integer>(serverRequestsPerSecond));
                    serversList.get(serversList.size()-1).add(newRequest);
                }
            }
        }
    }

    public static void test() {
        ArrayList<Integer> arr = new ArrayList<>(6);
        arr.trimToSize();
        for(int i = 0; i < 10; i++) {
            arr.add(i);
        }
        arr.forEach(System.out::println);
    }
}