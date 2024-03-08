import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_1374_강의실 {
	
	static class ClassRoom implements Comparable<ClassRoom>{
		public int startTime, endTime;

		public ClassRoom(int startTime, int endTime) {
			super();
			this.startTime = startTime;
			this.endTime = endTime;
		}

		public int compareTo(ClassRoom compare) {
			return this.endTime - compare.endTime;
		}
	}
	
	static class Lecture implements Comparable<Lecture>{
		public int lecturNumber, startTime;

		public Lecture(int lecturNumber, int startTime) {
			super();
			this.lecturNumber = lecturNumber;
			this.startTime = startTime;
		}
		
		public int compareTo(Lecture o) {
			return this.startTime - o.startTime;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ClassRoom[] arr = new ClassRoom[N+1];
		PriorityQueue<Lecture> que = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int lectureNumber = Integer.parseInt(st.nextToken());
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());
			
			arr[lectureNumber] = new ClassRoom(startTime, endTime);
			que.add(new Lecture(lectureNumber, startTime));
		}
		
		int usedClassRoomCount = 0;
		PriorityQueue<ClassRoom> pq = new PriorityQueue<>();
		pq.add(arr[que.poll().lecturNumber]);
		usedClassRoomCount++;
		
		for(int i=1; i<N; i++) {
			Lecture o = que.poll();
			if(pq.peek().endTime <= o.startTime) {
				pq.poll();
				pq.add(arr[o.lecturNumber]);
			}else {
				pq.add(arr[o.lecturNumber]);
				usedClassRoomCount++;
			}
		}
		System.out.println(usedClassRoomCount);
	}
}
