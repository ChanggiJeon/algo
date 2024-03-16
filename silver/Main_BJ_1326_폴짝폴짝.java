import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1326_폴짝폴짝 {
	
	static class Cordinate implements Comparable<Cordinate>{
		public int cur;
		public int cnt;
		
		@Override
		public int compareTo(Main_BJ_1326_폴짝폴짝.Cordinate o) {
			return this.cnt - o.cnt;
		}

		public Cordinate(int cur, int cnt) {
			super();
			this.cur = cur;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Cordinate> pq = new PriorityQueue<>();
		pq.add(new Cordinate(start, 1));
		while(!pq.isEmpty()) {
			Cordinate o = pq.poll();
			int newCur = o.cur + arr[o.cur];
			while(newCur <=N) {
				if(newCur == end) {
					System.out.println(o.cnt);
					System.exit(0);
				}
				pq.add(new Cordinate(newCur, o.cnt+1));
				newCur += arr[o.cur];
			}
			int minusCur = o.cur - arr[o.cur];
			while(minusCur >=1) {
				if(minusCur == end) {
					System.out.println(o.cnt);
					System.exit(0);
				}
				pq.add(new Cordinate(minusCur, o.cnt+1));
				minusCur -= arr[o.cur];
			}
		}
		System.out.println(-1);
	}
}
