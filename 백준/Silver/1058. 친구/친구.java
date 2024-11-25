
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int INF = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 1; j <= n; j++) {
                if (temp[j-1] == 'Y') {
                    graph[i][j] = 1;
                }else{
                    graph[i][j] = INF;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if(i==j) continue;
                    else{
                        graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);
                    }
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            int count=0;
            for (int j = 1; j <= n; j++) {
                if(graph[i][j]==1 || graph[i][j]==2){
                    count++;
                }
            }
            max = Math.max(max,count);
        }
        System.out.println(max);
    }

}
