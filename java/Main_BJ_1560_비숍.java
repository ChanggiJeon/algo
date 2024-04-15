import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_BJ_1560_비숍 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		if(input.equals("1")) {
			System.out.println(1);
			System.exit(0);
		}
		BigInteger bi = new BigInteger(input);
		System.out.println(bi.add(bi.subtract(new BigInteger("2"))));
	}
}
