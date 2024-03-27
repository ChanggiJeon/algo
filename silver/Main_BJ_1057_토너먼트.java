import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1057_토너먼트 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken()) - 1;
		int B = Integer.parseInt(st.nextToken()) - 1;
		int cnt = 0;
		while(A != B) {
			A /= 2;
			B /= 2;
			cnt++;
		}
		System.out.println(cnt);
	}

}
