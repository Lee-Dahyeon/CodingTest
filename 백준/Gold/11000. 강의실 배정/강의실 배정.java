
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static  ArrayList<Lecture> lectures=new ArrayList<>();;
    static class Lecture{
        int start;
        int end;
        Lecture(int start, int end){
            this.start=start;
            this.end=end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(start, end));
        }

        lectures.sort((l1, l2) -> l1.start!= l2.start? l1.start - l2.start : l1.end-l2.end );

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Lecture lecture : lectures) {
            if (!pq.isEmpty() && pq.peek() <= lecture.start){
                pq.poll();
            }
            pq.add(lecture.end);
        }
        System.out.println(pq.size());
    }

}
