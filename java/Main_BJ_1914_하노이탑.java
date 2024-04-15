import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_BJ_1914_하노이탑 {

	static long res = 0;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		if(n <= 20) {
			hanoi(n, 1, 2, 3);
			System.out.println(res);
			System.out.print(sb.toString());
		}else {
			BigInteger bi = new BigInteger("2");
			for(int i=0; i<n-1; i++) {
				bi = bi.multiply(BigInteger.valueOf(2));
			}
			System.out.println(bi.subtract(BigInteger.valueOf(1)));
		}
	}
	
	static void hanoi(int N, int start, int middle, int goal) {
		if(N == 1) {
			sb.append(start + " " + goal+"\n");
			res++;
			return;
		}
		hanoi(N-1, start, goal, middle);
		sb.append(start + " " + goal+"\n");
		res ++;
		hanoi(N-1, middle, start, goal);
	}
}
