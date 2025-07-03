import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] white =new int[1001];
    static int[] black =new int[1001];
    static int n=0;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line;
        while ((line = br.readLine())!=null){
            n++;
            st=new StringTokenizer(line);
            white[n]= Integer.parseInt(st.nextToken());
            black[n]= Integer.parseInt(st.nextToken());
        }

        dp=new int[n+1][16][16];
        process(n,15,15);
        System.out.println(dp[n][15][15]);
    }
    static int process(int index, int whiteMember, int blackMember ){

        if (index==0) return 0;
        if (whiteMember==0 && blackMember==0){
            return 0;
        }
        int best = dp[index][whiteMember][blackMember];
        if (best != 0){
            return best;
        }
        if (whiteMember>0){
            best = Math.max(best,process(index-1,whiteMember-1, blackMember)+white[index]);
        }
        if (blackMember>0){
            best = Math.max(best,process(index-1,whiteMember, blackMember-1)+black[index]);
        }
        best = Math.max(best, process(index - 1, whiteMember, blackMember));

        dp[index][whiteMember][blackMember]=best;
        return best;
    }
}
