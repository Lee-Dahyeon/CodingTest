import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
         if (n<2){
            System.out.println(0);
            return;

        }
        long[] dp = new long[n+1];
        dp[1] = 0L;
        dp[2] = 1L;
        for (int i = 3; i <= n; i++) {
            dp[i] = ((i-1)*(dp[i - 1] + dp[i - 2]))%1000000000;
        }
        System.out.println(dp[n]);
    }
}
