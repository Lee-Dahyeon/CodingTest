import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    
    for (int i = 0; i < n; i++) {
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> temp = new ArrayList<>(); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
            int num = Integer.parseInt(st.nextToken());
            temp.add(num);
        }

        long addition = 0; 
        int max = -10000;
        
        for (int j = m-1; j >= 0; j--) {
            if (temp.get(j) > max) { 
                max = temp.get(j);     
            } else {
                addition += max - temp.get(j);
            }
        }
        System.out.println(addition);
    }
}
}