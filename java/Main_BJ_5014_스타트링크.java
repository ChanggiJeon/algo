import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_5014_스타트링크 {

	static int res = -1;
	static int MAX;
	static int[] floor;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		MAX = Integer.parseInt(st.nextToken());
		int curFloor = Integer.parseInt(st.nextToken());
		int goalFloor = Integer.parseInt(st.nextToken());
		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());
		
		if(curFloor == goalFloor) {
			System.out.println(0);
			System.exit(0);
		}
		
		floor = new int[MAX+1];
		Arrays.fill(floor, -1);
		simulate(curFloor, goalFloor, up, down);
		
		if(res == -1) {
			System.out.println("use the stairs");
		}else {
			System.out.println(res);
		}
	}

	private static void simulate(int cur, int goal, int up, int down) {
		Queue<Integer> que = new LinkedList<>();
		que.add(cur);
		int tryCount = 1;
		while(!que.isEmpty()) {
			int size = que.size();
			for(int i=0; i<size; i++) {
				int o = que.poll();
				int nu = o + up;
				int nd = o - down;
				if(nu == goal || nd == goal) {
					res = tryCount;
					return;
				}
				if(nu <= MAX && floor[nu] == -1) {
					floor[nu] = tryCount;
					que.add(nu);
				}
				if(nd >0 && floor[nd] == -1) {
					floor[nd] = tryCount;
					que.add(nd);
				}
			}
			tryCount++;
		}
	}
}
