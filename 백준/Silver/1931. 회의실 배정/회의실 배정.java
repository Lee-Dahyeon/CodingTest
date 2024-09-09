import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
public class Main {
    static class Meeting{
        int start;
        int end;
        Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Meeting> meetings=new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }

        Collections.sort(meetings,(a,b)->{
            if (a.end==b.end){
                return a.start-b.start; 
            }else{
                return a.end-b.end; 
            }
        });
        int count = 0;
        int lastEnd = 0;

        for (Meeting meeting : meetings) {
            if (meeting.start >= lastEnd) {
                lastEnd=meeting.end;
                count++;
            }
        }
        System.out.println(count);

    }

}
