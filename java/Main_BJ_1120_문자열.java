import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1120_문자열 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		char[] pattern = st.nextToken().toCharArray();
		char[] text = st.nextToken().toCharArray();

		int maxCnt = 0;
		for(int i=0; i<=text.length-pattern.length; i++) {
			int sameCnt = 0;
			for(int j=0; j<pattern.length; j++) {
				if(pattern[j] == text[i+j]) {
					sameCnt++;
				}
			}
			if(sameCnt > maxCnt) {
				maxCnt = sameCnt;
			}
		}
		
		System.out.println(pattern.length - maxCnt);
	}
}
