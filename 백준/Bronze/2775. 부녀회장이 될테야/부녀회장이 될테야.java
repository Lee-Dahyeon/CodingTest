import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        ArrayList<int[]> data = new ArrayList<>();

        int maxFloor=0;
        int maxRoom=0;
        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            data.add(new int[]{n,m});
            if(maxFloor<n) maxFloor=n;
            if(maxRoom<m) maxRoom=m;
        }

        int[][] A= new int[maxFloor+1][maxRoom+1];
        for (int i = 1; i <= maxRoom; i++) {
            A[0][i] = i;
        }
        for (int i = 1; i <= maxFloor; i++) {
            for (int j = 1; j <= maxRoom; j++) {
                for (int k = 1; k <= j; k++) {
                    A[i][j]+=A[i-1][k];
                }
            }
        }
        for (int[] cur: data){
            System.out.println(A[cur[0]][cur[1]]);
        }
    }
}
