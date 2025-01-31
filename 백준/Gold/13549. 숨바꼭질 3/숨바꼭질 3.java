import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int max=100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited=new boolean[max+1];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, 0}); 

        int answer=Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int current = tmp[0]; 
            int time= tmp[1];
            visited[current] = true;

            if (current == k) { 
                answer=Math.min(answer,time);
            }
            if (current*2<= max && !visited[current*2]) {
                q.add(new int[]{current*2, time});
            }
            if (current+1<= max && !visited[current+1]) {
                q.add(new int[]{current+1, time+1});
            }
            if (current-1>=0 && !visited[current-1]) {
                q.add(new int[]{current-1, time+1});
            }
        }
        System.out.println(answer);
    }
}
