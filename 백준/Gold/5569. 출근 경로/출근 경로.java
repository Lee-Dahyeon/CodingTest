import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int mod=100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][][] dp = new int[w+1][h+1][2][2];

        for (int x =1; x<=w;x++){
            dp[x][1][0][0]=1;
        }
        for (int y =1; y<=h;y++){
            dp[1][y][1][0]=1;
        }

        for (int x=2; x <= w; x++) {
            for (int y = 2; y <= h; y++) {
                dp[x][y][0][0] = (dp[x - 1][y][0][0] + dp[x-1][y][0][1]) % mod;
                dp[x][y][1][0] = (dp[x][y-1][1][1] + dp[x][y - 1][1][0]) % mod; // 이전에 꺾였거나 그대로 왔거나
                dp[x][y][0][1] = dp[x - 1][y][1][0]% mod;
                dp[x][y][1][1] = dp[x][y-1][0][0]% mod; 
            }
        }

        int result = (dp[w][h][0][0] + dp[w][h][1][0] + dp[w][h][0][1] + dp[w][h][1][1]) % mod;
        System.out.println(result);
    }
}
