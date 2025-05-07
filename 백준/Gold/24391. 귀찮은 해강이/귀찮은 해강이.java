import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) parent[pb] = pa;
    }
    public static int find(int a) {
        if (parent[a]==a) return a;
        return parent[a] = find(parent[a]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }
        int[] timetable=new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            timetable[i] = Integer.parseInt(st.nextToken());
        }
        int count=0;
        for (int i = 0; i < n-1; i++) {
            if (find(timetable[i])!=find(timetable[i+1])) {
                count++;
            }
        }
        System.out.println(count);
    }
}

