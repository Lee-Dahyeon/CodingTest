import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//투포인터관련
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] num = new int[N];//N만큼 배열 만들기
        for (int i = 0; i < N; i++) {
            num[i]=sc.nextInt();
        }
        Arrays.sort(num);

        int count = 0;
        int startPoint=0;
        int endPoint=N-1;

        while(startPoint<endPoint){
            int sum=num[startPoint]+num[endPoint];
            if (sum==M){
                count++;
                startPoint++;
                endPoint--;
            }else if (sum>M){
                endPoint--;
            }else{//sum<M
                startPoint++;
            }
        }
            
        System.out.println(count);

    }
}


