import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] graph;
    static boolean visitedDfs[];
    static boolean visitedBfs[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int startV = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];  
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        visitedDfs = new boolean[n + 1];
        dfs(startV);
        System.out.println();  
        visitedBfs = new boolean[n + 1];
        bfs(startV);
    }

    private static void dfs(int i) {
        visitedDfs[i] = true;
        System.out.print(i + " ");
        for (int nextNode : graph[i]) {
            if (!visitedDfs[nextNode]) {
                dfs(nextNode);
            }
        }
    }

    private static void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visitedBfs[i] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");
            for (int nextNode : graph[cur]) {
                if (!visitedBfs[nextNode]) {
                    queue.add(nextNode);
                    visitedBfs[nextNode] = true;
                }
            }
        }
    }
}
