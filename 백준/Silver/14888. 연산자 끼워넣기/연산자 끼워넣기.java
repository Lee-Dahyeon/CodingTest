import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[] nums;
    static int n;
    static boolean[] visitedDfs;
    static int[] operation;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        nums= new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        operation = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visitedDfs= new boolean[n];
        dfs(nums[0],1);
        System.out.println(max);
        System.out.println(min);

    }
    static void dfs(int a, int index) { 
        if (index == n) {
            max = Math.max(max, a);
            min = Math.min(min, a);
            return;
        }
        for (int i = 0; i < 4; i++){
            if (operation[i]>0){
                operation[i]--;
                switch (i){
                    case 0: dfs(a+nums[index],index+1); break;
                    case 1: dfs(a-nums[index],index+1); break;
                    case 2: dfs(a*nums[index],index+1); break;
                    case 3: dfs(a/nums[index],index+1); break;
                }
                operation[i]++;
            }

        }
    }
}
