
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine());
        ArrayList result = new ArrayList();
        for (int i = 0; i < testcases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            result.add(compare(N,M));
        }

        for (int i = 0; i < testcases; i++) {
            System.out.println(result.get(i));
        }
    }

    private static int compare(int a, int b) {
        int[][] temp = new int[b+1][a+1];
        temp[0][0] = 1;
        for (int i = 1; i <= b; i++) {
            for (int j = 0; j <= a; j++) {
                if (i == j || j == 0) {
                    temp[i][j] = 1;
                }
                else{
                    temp[i][j] = temp[i-1][j-1] + temp[i-1][j];
                }
            }
        }
        return temp[b][a];
    }
}
