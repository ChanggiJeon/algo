import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_1427_소트인사이드 {

	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int[] number = new int[10];
		for(int i=0; i<input.length(); i++) {
			int n = Character.getNumericValue(input.charAt(i));
			number[n]++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=9; i>=0; i--) {
			for(int j=0; j<number[i]; j++) {
				sb.append(i);
			}
		}
		System.out.println(sb);
	}
}
