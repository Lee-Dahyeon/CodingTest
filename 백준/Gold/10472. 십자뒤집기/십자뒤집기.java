
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class Main {
    static int[] dx={0,-1,0,1,0};
    static int[] dy={0,0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            int board=0;
            for (int j = 0; j < 3; j++) {
                String input = br.readLine();
                for (int k = 0; k < 3; k++) {
                    if (input.charAt(k) == '*') {
                        int idx=j*3+k;
                        board |= (1<<idx);
                    }
                }

            }sb.append(bfs(board)).append('\n');
        }
        System.out.println(sb);

    }
    public static int bfs(int start) {
        int step=0;
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[512];
        visited[start]=true;
        q.add(start);

        boolean stop=false;
        while (!q.isEmpty() && !stop) {
            int size=q.size();
            for (int i=0; i<size; i++){
                int now=q.poll();
                if (now ==0){
                    return step;
                }
                for (int j=0; j<3; j++){
                    for (int k=0; k<3; k++){
                        int next=now;
                        for (int l=0; l<5; l++){
                            int nx= j+dx[l];
                            int ny= k+dy[l];
                            if (nx<0 || nx>=3 || ny<0 || ny>=3) continue;
                            int pos=nx*3+ny;

                            if ((next & (1<<pos))>0){
                                next &= ~(1<<pos);
                            }
                            else {
                                next |= (1<<pos);
                            }
                        }if (!visited[next]){
                            visited[next]=true;
                            q.add(next);
                        }
                    }
                }
            }step++;
        } return step;
    }
}
