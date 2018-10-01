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
        /**
         * make a Hashmap to store all the servers
         */
        HashMap<Integer, List<Integer>> servers = new HashMap<>();
        List<Integer> serv = new ArrayList<Integer>();
        /**
         * initialize the hashmap with one empty server
         */
        servers.put(0, serv);
        for(int i = 0; i < upcomingRequests; i++) {
            boolean addedRequest = false;
            int newRequest = sc.nextInt();
            while (!addedRequest) {
                for (int j = 0; j < servers.size(); j++) {
                    List<Integer> server = servers.get(j);
                    server = updateServer(server, newRequest);
                    if (server.size() != serverRequestsPerSecond) {
                        server.add(newRequest);
                        // printList(server);
                        addedRequest = true;
                        servers.put(j, server);
                        break;
                    }
                }
                if (!addedRequest) {
                    List<Integer> new_serv = new ArrayList<Integer>();
                    new_serv.add(newRequest);
                    servers.put(servers.size(), new_serv);
                    addedRequest = true;
                    break;
                }
            }
        }
        sc.close();
        System.out.println(servers.size());
    }


    public static List<Integer> updateServer(List<Integer> server, int newRequest) {
        for(int i = server.size() - 1; i > -1; i--) {
            if (newRequest - server.get(i) >= 1000) {
                if (i == server.size() - 1) {
                    server = new ArrayList<Integer>();
                    return server;
                }
                else{
                    server = server.subList(i+1, server.size());
                    return server;
                }
            }
        }

        return server;
    }


    public static void printList(List<Integer> list) {
        System.out.print("List: ");
        for(int num: list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}