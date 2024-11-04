
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static int n=0;
    static int[] depth;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());



        graph=new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
             st= new StringTokenizer(br.readLine());
             int u = Integer.parseInt(st.nextToken());
             int v = Integer.parseInt(st.nextToken());
             graph.get(u).add(v);
        }
        depth=new int[n+1];
        visited=new boolean[n+1];

        bfs(x);
        depth[x]=0;
        boolean found=false;
        ArrayList<Integer> ans=new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            if(depth[i]==k){
                ans.add(i);
                found=true;
            }
        }
        if(found){
            for(int i=0;i<ans.size();i++){
                System.out.println(ans.get(i));
            }
        }else{
            System.out.println("-1");
        }

    }


    private static void bfs(int i){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(i);
        while(!queue.isEmpty()){
            int current=queue.poll();
            for(int nextNode:graph.get(current)){
                if(!visited[nextNode]){
                    visited[nextNode]=true;
                    depth[nextNode]=depth[current]+1;
                    queue.add(nextNode);
                }
            }
        }

    }
}
