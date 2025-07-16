import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long min = arr[0];
        long max = arr[n-1]+k;
        while (min<= max){
            long mid = (min+max)/2;
            if (check(mid, arr, k)){
                ans = mid;
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }
        System.out.println(ans);
    }
    static boolean check(long mid, int[] arr, long k){
        long sum=0;
        for( int i=0; i<arr.length;i++){
            if (arr[i]<mid){
                sum+= mid - arr[i];
            }
        }
        return sum<=k;

    }
}
