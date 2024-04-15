import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1439_뒤집기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int zero = 0;
		int one = 0;
		boolean flag = false;
		for(int i=0; i<input.length(); i++) {
			int number = Character.getNumericValue(input.charAt(i));
			if(number !=0) {
				if(!flag) {
					flag = true;
					zero ++;
				}
			}else {
				flag = false;
			}
		}
		flag = false;
		for(int i=0; i<input.length(); i++) {
			int number = Character.getNumericValue(input.charAt(i));
			if(number!= 1) {
				if(!flag) {
					flag = true;
					one ++;
				}
			}else {
				flag = false;
			}
		}
		System.out.println(Math.min(zero, one));
	}
}
