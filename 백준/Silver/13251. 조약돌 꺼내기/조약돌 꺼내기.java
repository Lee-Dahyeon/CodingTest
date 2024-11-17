
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static double[][] compareResult;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int colorCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> colors = new ArrayList();
        colors.add(0);
        for (int i = 0; i < colorCnt; i++) {
            colors.add(Integer.parseInt(st.nextToken()));
        }
        int num = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < colorCnt; i++) {
            sum += colors.get(i + 1);
        }

        double part = 0;
        for (int i = 1; i < colorCnt + 1; i++) {
            part += compare(colors.get(i), num);
        }
        
        double wholeProb = part / compare(sum, num);
        System.out.println(wholeProb);
    }
    private static double compare(int a, int b) {
        compareResult=new double[a+1][b+1];
        compareResult[0][0]=1;
        for (int i = 1; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                if (i==j|| j==0) {
                    compareResult[i][j]=1;
                }else{
                    compareResult[i][j]=compareResult[i-1][j-1]+compareResult[i-1][j];
                }
            }
        }
        return compareResult[a][b];
    }
}
