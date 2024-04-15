import java.io.*;
import java.util.StringTokenizer;

public class Main_BJ_2630_색종이만들기 {

	static int blueColor = 0;
	static int whiteColor = 0;
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		countColor(N, map, 0, 0);
		System.out.println(whiteColor);
		System.out.println(blueColor);
	}

	private static void countColor(int size, int[][]map, int r, int c) {
		int start = map[r][c];
		int halfSize = size/2;
		
		boolean flag = true;

		o: for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(map[i][j]!= start) {
					flag = false;
					break o;
				}
			}
		}
		
		if(size == 1 || flag) {
			if(start == 1) {
				blueColor += 1;
			}else {
				whiteColor += 1;
			}
			return;
		}
		
		countColor(halfSize, map, r, c);
		countColor(halfSize, map, r+halfSize, c);
		countColor(halfSize, map, r, c+halfSize);
		countColor(halfSize, map, r+halfSize, c+halfSize);
	}
}
