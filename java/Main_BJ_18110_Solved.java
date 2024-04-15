import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_18110_Solved {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] scoreList = new int[N];
		
		for(int n=0; n<N; n++) {
			int score = Integer.parseInt(br.readLine());
			scoreList[n] = score;
		}
		
		Arrays.sort(scoreList);
		int exceptNumber = (int)Math.round(N * 0.15);
		
		int sum = 0;
		for(int i=0; i<(N - exceptNumber*2); i++) {
			sum += scoreList[i+exceptNumber];
		}
		System.out.println(Math.round((double)sum / (N - 2*exceptNumber)));
	}
}
