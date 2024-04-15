import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1205_등수구하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long score = Long.parseLong(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		if(N == 0) {
			System.out.println(1);
			System.exit(0);
		}
		st = new StringTokenizer(br.readLine());
		
		long[] scoreList = new long[N+1];
		
		for(int i=0; i<N; i++) {
			scoreList[i] = Long.parseLong(st.nextToken());
		}
		
		int rank = 1;
		for(int i=0; i<N; i++) {
			if(score < scoreList[i]) {
				rank ++;
			}else {
				break;
			}
		}
		
		if(rank > P) {
			System.out.println(-1);
			System.exit(0);
		}
		
		for(int i=rank-1; i<N; i++) {
            if(i + 1 == P && score == scoreList[i]) {
                rank = -1;
                break;
            }
            if(i + 1 < N && scoreList[i] == scoreList[i + 1]) {
                continue;
            } else {
                break;
            }
        }
		System.out.println(rank);
	}
}
