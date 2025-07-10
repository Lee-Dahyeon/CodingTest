import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] balloon =new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            balloon[i] = Integer.parseInt(st.nextToken());
        }
        int[] arrows =new int[1000001];

        int count=0;

        for (int height : balloon){
            if (arrows[height]>0){
                arrows[height]--;
                arrows[height-1]++;
            }else {
                count++;
                arrows[height-1]++;
            }
        }
        System.out.println(count);
    
}
}
