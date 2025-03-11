import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Case{
        int m;
        int n;
        int x;
        int y;
        Case(int m, int n, int x, int y){
            this.m = m;
            this.n = n;
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        ArrayList<Case> cases = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            cases.add(new Case(m,n,x,y));
        }
        for (Case c : cases) {
            boolean check = false;
            for (int i = c.x; i < (c.m*c.n); i+=c.m) {
                if (i%c.n ==c.y) {
                    System.out.println(i+1);
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println(-1);
            }
        }


    }
}
