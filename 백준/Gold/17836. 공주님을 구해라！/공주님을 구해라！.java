
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, T;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { 1, -1, 0, 0 };
    static class Node{
        int x,y,time;
        boolean sword;

        public Node(int x,int y,int time, boolean sword){
            this.x=x;
            this.y=y;
            this.time=time;
            this.sword=sword;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result =bfs();

        if (result == -1 || result >T) System.out.println("Fail");
        else System.out.println(result);
    }

    static int bfs() {
        Queue<Node> queue= new LinkedList<>();
        queue.add(new Node(0,0,0,false));
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int time = cur.time;
            boolean sword = cur.sword;

            if (cur.time >T) break;
            if (x == N - 1 && y == M - 1) return time;

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >=0 && newY>=0 && newX <N && newY<M) {
                    if (sword){
                        if(!visited[newX][newY][1]){
                            queue.add(new Node(newX,newY,time+1,sword));
                            visited[newX][newY][1]=true;
                        }
                    }else {
                        if(!visited[newX][newY][0] && map[newX][newY]==0){
                            queue.add(new Node(newX,newY,time+1,sword));
                            visited[newX][newY][0]=true;
                        }else if(!visited[newX][newY][0]&& map[newX][newY]==2){
                            queue.add(new Node(newX,newY,time+1,true));
                            visited[newX][newY][0]=true;
                        }
                    }

                }

            }
        }
        return -1; 
    }
}
