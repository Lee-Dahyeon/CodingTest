
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        arr=new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
        }
        System.out.println(dp());


    }
    static int dp(){
        int maxSum=0;
        for (int i = 1; i <= n; i++) {
            dp[i]=arr[i];
            for (int j=1; j<i;j++){
                if (arr[i]>arr[j]){
                    dp[i] = Math.max(dp[j]+arr[i], dp[i]);
                }
            }
            maxSum=Math.max(maxSum,dp[i]);
        }
        return maxSum;
    }
}
