import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1850_최대공약수 {

	static long res;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		res = gcd(Math.max(A, B), Math.min(A, B));
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<res; i++) {
			sb.append("1");
		}
		System.out.println(sb.toString());
	}
	private static long gcd(long a, long b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}
}
