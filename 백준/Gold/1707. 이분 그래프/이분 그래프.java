
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    enum status {
        NOT_VISITED, RED, BLACK
    }

    static status[] colorStatus;
    static List<List<Integer>> storeList;
    static List<Boolean> ans = new ArrayList<>();
    static int NodeN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcaseN = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcaseN; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            NodeN = Integer.parseInt(st.nextToken());
            int EdgeN = Integer.parseInt(st.nextToken());

            storeList = new ArrayList<>();
            for (int j = 0; j <= NodeN; j++) {
                storeList.add(new ArrayList<>());
            }

            for (int j = 0; j < EdgeN; j++) {
                st = new StringTokenizer(br.readLine());
                int Node1 = Integer.parseInt(st.nextToken());
                int Node2 = Integer.parseInt(st.nextToken());
                storeList.get(Node1).add(Node2);
                storeList.get(Node2).add(Node1);
            }

            colorStatus = new status[NodeN + 1];

            ans.add(bfs());

        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i) ? "YES" : "NO");
        }


    }

    private static boolean bfs() {
        Arrays.fill(colorStatus, status.NOT_VISITED);

        Queue<Integer> queue = new LinkedList<>();
        for (int start = 1; start <= NodeN; start++) {
            if (colorStatus[start] == status.NOT_VISITED) {
                colorStatus[start] = status.RED;
                queue.add(start);

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int nextNode : storeList.get(node)) {
                        if (colorStatus[nextNode] == status.NOT_VISITED) {
                            colorStatus[nextNode] = switchColor(colorStatus[node]);
                            queue.add(nextNode);
                        } else if (colorStatus[nextNode] == colorStatus[node]) {
                            return false;
                        }

                    }
                }
            }
        }
        return true;
    }

    private static status switchColor(status color) {
        if (color == status.BLACK) {
            return status.RED;
        }
        return status.BLACK;
    }
}
