import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean found = false;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int goalDepth=5;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        graph = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] eachCount = new int[N];
        for (int i = 1; i <= M; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            dfs(i,1);
            if (found){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);

    }
    private static void dfs(int i, int goalDepth) {
        if (goalDepth==5) {
            found=true;
            return;
        }
        visited[i] = true;
        for (int v: graph[i]) {
            if (!visited[v]) {
                dfs(v,goalDepth+1);

            }
        }
        visited[i] = false;

    }
}
