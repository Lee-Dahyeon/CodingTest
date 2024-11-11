import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int result = fibo(n)/(fibo(n-k)*fibo(k));
        System.out.println(result);
    }
    private static Integer fibo(int n) {
        if (n > 1 ){
            return n*fibo(n-1);
        }
        else{
            return 1;
        }

    }
}
