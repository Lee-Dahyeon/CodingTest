import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long M=1;
        while (M < N) {
            M=2*M +1;
        }

        if (M == N) {
            System.out.println(1);
            System.out.println(N);
        }else{
            System.out.println(2);
            System.out.println(N^M);
            System.out.println(N);
        }
    }
}
