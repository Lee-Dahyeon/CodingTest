
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] num=new int[n];
        for(int i=0;i<n;i++){
            num[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);
        for(int i=0;i<n;i++){
            System.out.println(num[i]);
        }



    }
}
