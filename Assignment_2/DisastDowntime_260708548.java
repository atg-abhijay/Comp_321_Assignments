import java.util.ArrayList;
import java.util.Scanner;

public class DisastDowntime_260708548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int upcomingRequests = sc.nextInt();
        int serverRequestsPerSecond = sc.nextInt();
        ArrayList<ArrayList<Integer>> serversList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> server = new ArrayList<>();
        for(int i = 0; i < serversList.size(); i++) {
            serversList.add(new ArrayList<Integer>(serverRequestsPerSecond));
        }
        for(int i = 0; i < upcomingRequests; i++) {
            boolean addedRequest = false;
            int newRequest = sc.nextInt();
            while (!addedRequest) {
                for (int j = 0; j < serversList.size(); j++) {
                    server = serversList.get(j);
                    updateServer(server, newRequest);
                    if (server.size() != serverRequestsPerSecond) {
                        server.add(newRequest);
                        addedRequest = true;
                        break;
                    }
                }
                if (!addedRequest) {
                    serversList.add(new ArrayList<Integer>(serverRequestsPerSecond));
                    serversList.get(serversList.size()-1).add(newRequest);
                    addedRequest = true;
                }
            }
        }
        sc.close();
        System.out.println(serversList.size());
    }


    public static void updateServer(ArrayList<Integer> server, int newRequest) {
        for(int i = 0; i < server.size(); i++) {
            if (newRequest - server.get(i) >= 1000) {
                server.remove(i);
            }
        }
    }
}