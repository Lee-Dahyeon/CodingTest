import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < V+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[] {v, cost});
        }
        int[] dist=new int[V+1];
        for (int i = 0; i < V+1; i++) {
            dist[i]=Integer.MAX_VALUE;
        }
        dist[start]=0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));
        pq.add(new int[]{start,0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int costToU = cur[1];

            if (dist[u]<costToU) continue;

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int costUV = neighbor[1];
                int newCost=dist[u]+costUV;

                if (newCost<dist[v]) {
                    dist[v]=newCost;
                    pq.add(new int[]{v,newCost});
                }
            }

        }
        for (int i = 1; i < V+1; i++) {
            if (dist[i]==Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}
