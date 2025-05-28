
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int k = Integer.parseInt(st1.nextToken());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int[] list = new int[n];
            for (int j=0;j<n;j++){
                list[j] = Integer.parseInt(st2.nextToken());
            }

            Arrays.sort(list);

            int left=0,right=n-1;
            int minDiff=Integer.MAX_VALUE;
            int count=0;

            while(left<right){
                int sum=list[left]+list[right];
                int diff=Math.abs(sum-k);
                if (diff<minDiff){
                    minDiff=diff;
                    count=1;
                }else if(diff==minDiff){
                    count++;
                }

                if (sum <k){
                    left++;
                }else {
                    right--;
                }
            }

            System.out.println(count);
        }
    }
}
