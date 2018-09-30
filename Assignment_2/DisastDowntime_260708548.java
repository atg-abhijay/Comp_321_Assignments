import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DisastDowntime_260708548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int upcomingRequests = sc.nextInt();
        int serverRequestsPerSecond = sc.nextInt();
        HashMap servers = new HashMap<Integer, List<Integer>>();
        int num_servers = servers.size();
        List<Integer> serv = new ArrayList<Integer>();
        servers.put(0, serv);
        // System.out.println(servers.get(0));
        // List<List<Integer>> serversList = new ArrayList<List<Integer>>();
        // List<Integer> server = new ArrayList<>();
        // for(int i = 0; i < serversList.size(); i++) {
        //     /**
        //      * more time efficient to initialize the size of
        //      * the arraylists than to not specify the size
        //      */
        //     serversList.add(new ArrayList<Integer>(serverRequestsPerSecond));
        // }
        for(int i = 0; i < upcomingRequests; i++) {
            boolean addedRequest = false;
            int newRequest = sc.nextInt();
            while (!addedRequest) {
                for (int j = 0; j < servers.size(); j++) {
                    server = servers.get(j);
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
                    break;
                }
            }
        }
        sc.close();
        System.out.println(serversList.size());
    }


    public static void updateServer(List<Integer> server, int newRequest) {
        /**
         * more test cases solved
         * with this than with removeIf()
         */
        // boolean requestProcessed = false;
        // int i = 0;
        // int last = server.size()-1;
        // while(true) { //requestProcessed
        //     if(newRequest - server.get(last-i) >= 1000) {
        //         server = server.subList(last-i+1, server.size());
        //         // requestProcessed = true;
        //         break;
        //     }
        //     else {
        //         i++;
        //     }
        // }
        for(int i = server.size()-1; i > -1; i--) {
            if (newRequest - server.get(i) >= 1000) {
                server = server.subList(i+1, server.size());
                break;
            }
        }
    }


    // public static int binarySearch(List<Integer> server, int newRequest) {
    //     int position = server.size()/2;
    //     int difference = newRequest - server.get(position);
    //     if ()
    // }
}