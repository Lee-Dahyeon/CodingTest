
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m,n;
    static int[][] arr;
    static int[][] odd = {{-1,0},{0,-1},{1,0},{1,1},{0,1},{-1,1}};
    static int[][] even = {{-1,-1},{0,-1},{1,-1},{1,0},{0,1},{-1,0}};
    static boolean[][] visit;
    static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m+2][n+2];
        visit = new boolean[m+2][n+2];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
    }
    static void bfs(){
        queue.offer(new Point(0,0));
        visit[0][0]=true;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int x = now.x;
            int y = now.y;
            for (int i=0;i<6;i++){
                int newX, newY;
                if (x%2==0){
                    newX = x + even[i][0];
                    newY = y + even[i][1];
            }
            else {
                newX = x + odd[i][0];
                newY = y + odd[i][1];
            }
            if (newX>=0 && newX <= m+1 && newY >=0 && newY <= n+1){
                if(!visit[newX][newY]){
                    if (arr[newX][newY] == 0) {
                        visit[newX][newY] = true;
                        queue.offer(new Point(newX, newY));
                  }
                }
            }

            }
        }
        int sum=0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }
                for (int a=0; a<6;a++){
                    int nx; int ny;
                    if (i%2==0){
                        nx = i + even[a][0];
                        ny = j + even[a][1];
                    }else{
                        nx = i + odd[a][0];
                        ny = j + odd[a][1];
                    }
                    if (visit[nx][ny]) {
                        sum++;
                    }
                }
            }
        }
        System.out.println(sum);
        //https://codingrapper.tistory.com/207
    }
}
