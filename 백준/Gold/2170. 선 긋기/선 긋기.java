import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int[][] pos=new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pos[i][0]=a;
            pos[i][1]=b;
        }
        Arrays.sort(pos, (o1, o2)->
                o1[0]==o2[0]?Integer.compare(o1[1],o2[1]):Integer.compare(o1[0],o2[0]));

        int min=pos[0][0];
        int max=pos[0][1];
        int len=max-min;
        for (int i = 1; i < n; i++) {
            int start=pos[i][0];
            int end=pos[i][1];

            if (start<=max){
                if (end>max){
                    len+= end-max;
                    max=end;
                }
            }else{
                len+= end-start;
                min=start;
                max=end;
            }
        }
        System.out.println(len);
}}

