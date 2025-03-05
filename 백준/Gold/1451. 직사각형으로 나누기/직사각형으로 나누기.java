
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long max=0;
    static int [][] list;
    static int n,m;
    static long[][] prefixSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new int[n+1][m+1];
        prefixSum = new long[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j=1;j<=m;j++) {
                list[i][j] = line.charAt(j-1)-'0';
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] = list[i][j] + prefixSum[i][j-1] + prefixSum[i-1][j] - prefixSum[i-1][j-1];
            }
        }

        System.out.println(solve());

    }
    static long sum(int r1, int c1, int r2, int c2) {
        return  prefixSum[r2][c2] - prefixSum[r2][c1-1] - prefixSum[r1-1][c2] + prefixSum[r1-1][c1-1];

    }
    static long solve(){

        for (int i = 1; i <= m-2; i++) {
            for (int j = i+1; j <= m-1; j++) {
                long r1= sum(1,1,n,i);
                long r2= sum(1,i+1,n,j);
                long r3= sum(1,j+1,n,m);

                max=Math.max(max,r1*r2*r3);
            }
        }

        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                long r1 = sum(1, 1, i, m);
                long r2 = sum(i + 1, 1, j, m);
                long r3 = sum(j + 1, 1, n, m);

                max=Math.max(max,r1*r2*r3);
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                long r1= sum(1,1,n,j);
                long r2= sum(1,j+1,i,m);
                long r3= sum(i+1,j+1,n,m);

                max=Math.max(max,r1*r2*r3);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                long r1= sum(1,1,i,j);
                long r2= sum(i+1,1,n,j);
                long r3= sum(1,j+1,n,m);

                max=Math.max(max,r1*r2*r3);            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                long r1= sum(1,1,i,j);
                long r2= sum(i+1,1,n,m);
                long r3= sum(1,j+1,i,m);

                max=Math.max(max,r1*r2*r3);            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                long r1= sum(1,1,i,m);
                long r2= sum(i+1,1,n,j);
                long r3= sum(i+1,j+1,n,m);

                max=Math.max(max,r1*r2*r3);
            }
        }
        return max;
    }
}
