import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int min =1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr= new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        if (n>2){
            for (int i=0;i<n-1; i++){ 
                for(int j=n-1;j>=0;j--){ 
                    if (i+1==j)break;
                    if (arr[i] + arr[i + 1] > arr[j]) {
                        min= Math.max(min, j - i + 1);
                        break;
                    }
                }
            }
        }
        if (min==1 && n>=2){
            min=2;
        }
        System.out.println(min);
    }
}
