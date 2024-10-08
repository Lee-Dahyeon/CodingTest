
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        graph= new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i]=new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v); 
            graph[v].add(u);
        }

        int count = 0;
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int i) {
        visited[i]=true;
        for (int nextNode: graph[i]){
            if (!visited[nextNode]){
                dfs(nextNode);
            }
        }
    }
}
