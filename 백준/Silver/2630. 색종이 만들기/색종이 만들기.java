import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int blue;
    static int white;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        func(1,1,n);
        System.out.println(white);
        System.out.println(blue);
    }
    static void func(int a, int b, int n) {
        boolean flag = false;
        int temp = arr[a][b];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[a+i][b+j] != temp) {
                    flag=true;
                    break;
                }
            }
        }
        if (flag) {
            n=n/2;
            func(a,b,n);
            func(a+n,b+n,n);
            func(a,b+n,n);
            func(a+n,b,n);
        }else{
            if (temp==0) white++;
            else blue++;
        }

    }

}
