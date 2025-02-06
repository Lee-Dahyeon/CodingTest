import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());//지원자 수
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int work[]= new int [n+1];
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                work[a]=b;
            }
            int count = 1;
            int temp = work[1];
            for (int j = 2; j <= n; j++) {
                if (work[j] < temp) {
                    temp = work[j];
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
