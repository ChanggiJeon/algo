import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1051_숫자정사각형 {

	static int N, M;
	static int minLength, maxLength;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		minLength = Math.min(N, M) - 1;
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(N-i < maxLength || M-j <maxLength) {
					continue;
				}
				findSquare(i, j);
			}
		}
		System.out.println((int)Math.pow(maxLength, 2));
	}
	private static void findSquare(int r, int c) {
		int cur = map[r][c];
		for(int d=minLength; d>=0; d--) {
			if(maxLength >= d+1) continue;
			if(boundary(r,c,d) && isSameNumber(r,c,d, cur)) {
				if(maxLength < d+1) {
					maxLength = d+1;
				}
			}
		}
	}
	private static boolean boundary(int r, int c, int d) {
		return r+d<N && c+d <M;
	}
	
	private static boolean isSameNumber(int r, int c, int d, int cur) {
		return cur == map[r+d][c] && cur == map[r][c+d] && cur== map[r+d][c+d];
	}
}
