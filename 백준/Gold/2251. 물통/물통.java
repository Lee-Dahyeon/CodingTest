import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer> curWater;
    static boolean [][][] visited;
    static List<Integer> ans;
    static List<Integer> from= Arrays.asList(0,0,1,1,2,2);
    static List<Integer> to= Arrays.asList(1,2,0,2,0,1);
    static int[] maxCapacity;
    static List<Integer> currentWater;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        maxCapacity=new int[3];
        maxCapacity[0] = Integer.parseInt(st.nextToken());
        maxCapacity[1] = Integer.parseInt(st.nextToken());
        maxCapacity[2] = Integer.parseInt(st.nextToken());
        visited = new boolean[maxCapacity[0]+1][maxCapacity[1]+1][maxCapacity[2]+1];
        currentWater= Arrays.asList(0,0,maxCapacity[2]);

        ans= new ArrayList<>();

         bfs(currentWater);
         Collections.sort(ans);

        for (int answer : ans) {
            System.out.print(answer+" ");
        }

    }
    private static void bfs(List<Integer> currentWater) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(currentWater);
        visited[currentWater.get(0)][currentWater.get(1)][currentWater.get(2)] = true;
        while (!queue.isEmpty()) {
            List<Integer> cur = queue.poll();
            int a = cur.get(0);
            int b = cur.get(1);
            int c = cur.get(2);

            if (a == 0 && !ans.contains(c)) {
                ans.add(c);
            }
            for (int i = 0; i < 6; i++) {
                int fromBucket = from.get(i);
                int toBucket = to.get(i);
                int toCapacity = maxCapacity[toBucket];

                int fromAmount=cur.get(fromBucket);
                int toAmount=cur.get(toBucket);

                int moveAmount=Math.min(fromAmount, toCapacity-toAmount);
                if (moveAmount == 0) continue;

                List<Integer> nextWater = new ArrayList<>(cur);
                nextWater.set(fromBucket, fromAmount-moveAmount);
                nextWater.set(toBucket, toAmount+moveAmount);

                if (!visited[nextWater.get(0)][nextWater.get(1)][nextWater.get(2)]) {
                    visited[nextWater.get(0)][nextWater.get(1)][nextWater.get(2)] = true;
                    queue.add(nextWater);
                }
            }
        }
    }
}
