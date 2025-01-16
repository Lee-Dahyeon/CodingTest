
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        depth = new int[n + 1];
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        tree = new ArrayList[n+1];
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < n+1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        bfs(1);

        int m= Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a,b)).append('\n');
        }
        System.out.println(sb);

    }
    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next: tree[cur]){
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                    parent[next] = cur;
                    depth[next]=depth[cur]+1;
                }
            }
        }

    }
    static int LCA(int a, int b){
        while(depth[a]!=depth[b]){
            if(depth[a]>depth[b]){
                a = parent[a];
            }else{
                b = parent[b];
            }
        }
        while(a!=b){
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

}
