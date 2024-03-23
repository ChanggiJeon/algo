import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1059_좋은구간 {

	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] numberList = new int[L];
		for(int i=0; i<L; i++) {
			numberList[i] = Integer.parseInt(st.nextToken());
		}
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<L; i++) {
			if(numberList[i] == n) {
				System.out.println(0);
				System.exit(0);
			}
		}
		
		Arrays.sort(numberList);
		int min = 1;
		int max = numberList[L-1];
		
		for(int i=0; i<L; i++) {
			if(numberList[i] < n) {
				min = numberList[i] + 1;
			}
		}
		for(int i=L-1; i>=0; i--) {
			if(numberList[i] > n) {
				max = numberList[i] - 1;
			}
		}
		int res = 0;
		
		for(int i=min; i<max; i++) {
			for(int j=i+1; j<=max; j++) {
				if(i<=n && n<=j) {
					res++;
				}
			}
		}
		System.out.println(res);
	}
}
