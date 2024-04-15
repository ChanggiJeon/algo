import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1325_효율적인해킹 {

	/**
	 * 1. A가 해킹당했다고 치면, 신뢰하고 있는 B,C,D는 +1되는 이득이 있음. 그런식으로 모든 컴퓨터 탐색
	 * 모든 컴퓨터가 해킹당할때 자동으로 이득보는 컴퓨터들 +1 하다보면 반대로 C해킹시에 몇개의 컴퓨터가 자동으로 해킹되는지 알 수 있다.
	 * 2. bfs, dfs 모두 시도했으나, 시간초과가 매우 자주 남. 메소드 없이 만들어서 돌리니 AC
	 */
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int max;
	static int[] count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n+1];
		count = new int[n+1];
		
		list = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken());
			int shouldBeHacked = Integer.parseInt(st.nextToken());
			list[target].add(shouldBeHacked);
		}
		
		for(int i=1; i<=n; i++) {
			visited = new boolean[n+1];
			Queue<Integer> que = new LinkedList<>();
			que.add(i);
			visited[i] = true;

			while(!que.isEmpty()) {
				int o = que.poll();
				for(int next: list[o]) {
					if(visited[next]) continue;
					count[next]++;
					visited[next] = true;
					que.add(next);
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			if(count[i] > max) {
				max = count[i];
			}
		}
		for(int i=1; i<=n; i++) {
			if(max == count[i]) {
				sb.append(i+" ");
			}
		}
		System.out.println(sb.toString());
	}
}
