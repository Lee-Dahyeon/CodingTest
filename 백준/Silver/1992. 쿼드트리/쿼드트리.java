import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int[][] arr;
    static ArrayList<String> result=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        arr=new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            String line=br.readLine();
            for (int j = 1; j <= n; j++) {
                arr[i][j] = line.charAt(j-1)-'0';
            }
        }
        func(1,1,n);
        for (int i = 0; i < result.size(); i++) System.out.print(result.get(i));

    }
    static void func(int a, int b, int n) {
        boolean flag=false;
        int temp=arr[a][b];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[a+i][b+j]!=temp) flag=true;
            }
        }
        if (flag) {
            n=n/2;
            result.add("(");
            func(a,b,n);
            func(a,b+n,n);
            func(a+n,b,n);
            func(a+n,b+n,n);
            result.add(")");
        }else {
            result.add(String.valueOf(temp));
        }
    }
}
