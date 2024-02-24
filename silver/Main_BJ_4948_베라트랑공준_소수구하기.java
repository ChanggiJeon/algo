import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_4948_베라트랑공준_소수구하기 {
	
	static final int MAX = 123_456;
	static final boolean[] isPrimeNumber = new boolean[2*MAX+1];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Arrays.fill(isPrimeNumber, true);
		isPrimeNumber[1] = false;
		getPrimeNumber();
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) {
				System.out.print(sb.toString());
				break;
			}
			int res = getPrimeCount(N);
			sb.append(res+"\n");
		}
	}

	private static void getPrimeNumber() {
		int max = (int)Math.ceil(Math.sqrt(2*MAX));
		
		for(int i=2; i<=max; i++) {
			if(!isPrimeNumber[i]) continue;
			for(int j=i*i; j<=2*MAX; j+=i) {
				if(j%i == 0) {
					isPrimeNumber[j] = false;
				}
			}
		}
	}
	private static int getPrimeCount(int N) {
		int count = 0;
		for(int i=N+1; i<=2*N; i++) {
			if(isPrimeNumber[i]) {
				count ++;
			}
		}
		return count;
	}
}
