
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

        int[][] sum = new int[n + 1][m + 1];


        for (int i = 1; i <= n; i++) {
            String line = br.readLine(); 
            for (int j = 1; j <= m; j++) {
                sum[i][j] = line.charAt(j - 1) - '0'; 
            }
        }

        int maxLen = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (sum[i][j] == 1) {
                    sum[i][j] = Math.min(sum[i - 1][j], Math.min(sum[i][j - 1], sum[i - 1][j - 1])) + 1;
                    maxLen = Math.max(maxLen, sum[i][j]);
                }
            }
        }

        System.out.println(maxLen * maxLen);
    }
}
