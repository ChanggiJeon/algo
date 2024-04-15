import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1926_그림 {
	
	static class Cordinate {
		int r;
		int c;
		public Cordinate(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int[][] map;
	static boolean[][] visited;
	static int MaxArea = 0;
	static int AreaCount = 0;
	static int N, M;
	static int[] mr = new int[]{-1,0,1,0};
	static int[] mc = new int[]{0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					AreaCount++;
					bfs(i, j);
				}
			}
		}
		System.out.println(AreaCount);
		System.out.print(MaxArea);
	}
	
	private static void bfs(int r, int c) {
		Queue<Cordinate> que = new LinkedList();
		int area = 1;
		visited[r][c] = true;
		que.add(new Cordinate(r, c));
		
		while(!que.isEmpty()) {
			Cordinate o = que.poll();
			for(int d=0; d<4; d++) {
				int nr = o.r + mr[d];
				int nc = o.c + mc[d];
				if(boundary(nr, nc) && !visited[nr][nc]&& map[nr][nc] == 1) {
					visited[nr][nc] = true;
					que.add(new Cordinate(nr, nc));
					area++;
				}
			}
		}
		if(MaxArea < area ) {
			MaxArea = area;
		}
	}
	private static boolean boundary(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
