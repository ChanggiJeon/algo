import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BJ_1268_임시반장정하기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n+1][6];
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Set<Integer>[] freindsSet = new Set[n+1];
		for(int i=1; i<=n; i++) {
			freindsSet[i] = new HashSet<Integer>();
		}
		
		for(int c=1; c<=5; c++) {
			for(int i=1; i<=n; i++) {
				for(int j=i+1; j<=n; j++) {
					if(map[i][c] == map[j][c]) {
						freindsSet[i].add(j);
						freindsSet[j].add(i);
					}
				}
			}
		}
		int max = -1;
		int res = 0;
		for(int i=1; i<=n; i++) {
			if(freindsSet[i].size() > max) {
				max = freindsSet[i].size();
				res = i;
			}
		}
		System.out.println(res);
	}
}
