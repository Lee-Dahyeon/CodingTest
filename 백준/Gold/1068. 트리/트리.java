import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rootNode=0;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a!=-1){
                list.get(a).add(i);
            }else{
                rootNode = i;
            }
        }
        int cutNode= Integer.parseInt(br.readLine());
        if (cutNode==rootNode){
            System.out.println("0");
        }else {
            visited=new boolean[n];
            dfs(cutNode);
            int ansCount=0;
            for (int i = 0; i < n; i++) {
                boolean flag=false;
                if(!visited[i]){
                    for (int node: list.get(i)){
                        if (!visited[node]){
                            flag=true;
                            break;
                        }
                    }
                    if(!flag){
                        ansCount++;
                    }
                }
            }
            System.out.println(ansCount);
        }

    }
    public static void dfs(int v){
        visited[v]=true;
        for (int nextNode:list.get(v)) {
            if (!visited[nextNode]){
                dfs(nextNode);
            }
        }

    }
}
