import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_1904_01타일 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] DP = new long[n+2];
		DP[1] = 1;
		DP[2] = 2;
		for(int i=3; i<=n; i++){
			DP[i] = (DP[i-2]+DP[i-1])%15746;
		}
		System.out.println(DP[n]);
	}

}

