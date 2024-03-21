import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_1094_막대기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int res = simulate(64, 64, 1, N);
		System.out.println(res);
	}
	public static int simulate(int cur, int min, int cnt, int goal) {
		if(cur > goal) {
			int half = min / 2;
			if(cur - half >= goal) {
				return simulate(cur - half, half, cnt, goal);
			}else {
				return simulate(cur, half, cnt+1, goal);
			}
		}
		return cnt;
	}
}