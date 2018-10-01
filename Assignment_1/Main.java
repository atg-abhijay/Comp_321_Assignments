import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			int opCount=Integer.parseInt(s);
			Stack<Integer> stk=new Stack<>(); boolean stkOK=true;
			Queue<Integer> q=new LinkedList<>(); boolean qOK=true;
			PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder()); boolean pqOK=true;

			for (int i=0;i<opCount;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				String op=st.nextToken();
				int value=Integer.parseInt(st.nextToken());
				if (op.equals("1")) {
					if (stkOK) stk.push(value);
					if (qOK) q.offer(value);
					if (pqOK) pq.offer(value);
				} else if (op.equals("2")) {
					if (stkOK && (stk.size()==0 || !stk.pop().equals(value))) stkOK=false;
					if (qOK && (q.size()==0 || !q.poll().equals(value))) qOK=false;
					if (pqOK && (pq.size()==0 || !pq.poll().equals(value))) pqOK=false;
				}
			}

			if (!stkOK && !qOK && !pqOK) System.out.println("impossible");
			else if ((stkOK && qOK) || (stkOK && pqOK) || (qOK && pqOK)) System.out.println("not sure");
			else if (stkOK) System.out.println("stack");
			else if (qOK) System.out.println("queue");
			else if (pqOK) System.out.println("priority queue");
		}
	}
}