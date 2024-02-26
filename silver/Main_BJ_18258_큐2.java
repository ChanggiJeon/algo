import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ArrayBlockingQueue;

public class Main_BJ_18258_큐2 {

	/**
	 * Queue 대표적 구현체
	 * 1. LinkedList
	 * 2. ArrayDeque => Null허용을 하지 않는다. + 크기가 정해져있으면 효율적
	 */
	static int[] que = new int[2000001];
	static int start = 0;
	static int cur = 0;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Arrays.fill(que, -1);
		int N = Integer.parseInt(br.readLine());
		o : for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
				case "push":
					push(Integer.parseInt(st.nextToken()));
					continue o;
				case "pop":
					sb.append(pop());
					break;
				case "size":
					sb.append(size());
					break;
				case "empty":
					sb.append(empty());
					break;
				case "front":
					sb.append(front());
					break;
				case "back":
					sb.append(back());
					break;
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void push(int N){
		que[cur++] = N;
	}
	private static int pop(){
		if(start == cur) {
			return -1;
		}
		return que[start++];
	}
	private static int size(){
		return cur - start;
	}
	private static int empty(){
		return cur == start ? 1: 0;
	}
	private static int front(){
		if(start == cur) {
			return -1;
		}
		return que[start];
	}
	private static int back(){
		if(start == cur) {
			return -1;
		}
		return que[cur-1];
	}
}
