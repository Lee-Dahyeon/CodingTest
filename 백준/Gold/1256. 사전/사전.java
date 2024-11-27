import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int max=1000000000;

        long[][] dp = new long[201][201];
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= i; j++) {
                if (i ==j || j == 0) dp[i][j] = 1;
                else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                    if (dp[i][j] > max) dp[i][j] = max+1;
                    
                }
            }
        }

        if (dp[n+m][m] < k) {
            System.out.println("-1");
            return;
        }else {
            while (!(n==0 && m==0)) { 
                if (dp[n+m-1][m]>=k) { 
                    System.out.print("a");
                    n--;
                }else {
                    System.out.print("z");
                    k-=dp[n+m-1][m]; 
                    m--;
                }
            }
        }
    }
}
