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

        int[] endArray = new int[n];
        int[] dArray = new int[n];
        int[] tempArray = new int[n];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            endArray[i]= Integer.parseInt(st1.nextToken());
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dArray[i] = Integer.parseInt(st2.nextToken())-1;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                tempArray[dArray[j]] = endArray[j];

            }
            System.arraycopy(tempArray, 0, endArray, 0, n);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(tempArray[i]+" ");
        }
    }
}
