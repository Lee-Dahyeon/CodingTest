import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] rectangle = new Integer[n + 1];
        if (n == 1) {
            System.out.println(1);
            return;
        }

        rectangle[0] = 0;
        rectangle[1] = 1;
        rectangle[2] = 2;
        for(int i = 3; i <= n; i++) {
            rectangle[i] = (rectangle[i - 1] + rectangle[i - 2])%10007;
        }
        System.out.println(rectangle[n]);
    }
}
