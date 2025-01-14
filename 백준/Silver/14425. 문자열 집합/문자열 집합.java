
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<String> setList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            setList.add(temp);
        }
        int count=0;
        for (int i = 0; i < m; i++) {
            String test = br.readLine();
            for (int j = 0; j < setList.size(); j++) {
                if (setList.get(j).equals(test)) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
