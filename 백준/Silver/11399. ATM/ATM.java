import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        int[] sum = new int[n];
        int result =0;
        Arrays.sort(p);

        for (int i = 0; i < n; i++) {
            if(i==0){
                sum[i]=p[i];
                result=sum[i];
            }else {
                sum[i] = sum[i - 1] + p[i];
                result+=sum[i];
            }
        }
        System.out.println(result);
    }
}
