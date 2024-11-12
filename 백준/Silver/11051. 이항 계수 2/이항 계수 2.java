import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] store= new int[N+1][N+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                if (i==j||j==0) store[i][j]=1;
                else store[i][j]=(store[i-1][j]+store[i-1][j-1])% 10007;
            }
        }

        System.out.println( store[N][K]);
    }
}
