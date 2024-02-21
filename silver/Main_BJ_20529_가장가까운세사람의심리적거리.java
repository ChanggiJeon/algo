import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_20529_가장가까운세사람의심리적거리 {

	static char[] firstCharList = {'E', 'N', 'T', 'J'};
	static int sum;
	static int[] pick = new int[3];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			if(N > 32) {
				br.readLine();
				sb.append(0+"\n");
				continue;
			}
			
			ArrayList<Integer> mbtiArray = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				String mbtiString = st.nextToken();
				int mbti = 0;
				for(int j=0; j<4; j++) {
					if(mbtiString.charAt(j) == firstCharList[j]) {
						mbti = mbti | 1<<j;
					}
				}
				mbtiArray.add(mbti);
			}
			sum = Integer.MAX_VALUE;
			getMiniDiff(mbtiArray, 0, 0);
			
			sb.append(sum + "\n");
		}
		System.out.print(sb.toString());
	}
	
	private static void getMiniDiff(ArrayList<Integer> arr, int flag, int N) {
		if(N == 3) {
			int min = 0;
			int first = pick[0];
			int second = pick[1];
			int third = pick[2];
			
			for(int i=0; i<4; i++) {
				if(first %2 != second %2) {
					min ++;
				}
				if(second %2 != third %2) {
					min ++;
				}
				if(first %2 != third %2) {
					min ++;
				}
				first /= 2;
				second /= 2;
				third /= 2;
			}
			sum = Math.min(sum, min);
			return;
		}
		for(int i=0; i<arr.size(); i++) {
			if((flag&1<< i)!=0) continue;
			pick[N] = arr.get(i);
			getMiniDiff(arr, flag|1<<i, N+1);
		}
	}
}
