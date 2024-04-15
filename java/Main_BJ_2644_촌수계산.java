import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2644_촌수계산 {

	static boolean[][] map;
	static int goal, start, res, n, m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new boolean[n+1][n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		goal = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		for(int i=0; i<m ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = true;
		}
		res = simulate();
		System.out.print(res);
	}
	
	private static int simulate() {
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		int count = 0;
		while(!que.isEmpty()) {
			int size = que.size();
			for(int i=0; i<size; i++) {
				int o = que.poll();
				for(int j=1; j<=n; j++) {
					if(o == j)continue;
					if(map[o][j]) {
						if(j == goal) {
							return count+1;
						}
						map[o][j] = map[j][o] = false;
						que.add(j);
					}
				}
			}
			count++;
		}
		return  -1;
	}
}
