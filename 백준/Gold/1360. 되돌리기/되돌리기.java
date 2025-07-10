import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        String value;
        int time;
        public Node(String value, int time) {
            this.value = value;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n+1];
        nodes[0] = new Node("", 0);

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            String value = st.nextToken();
            int second = Integer.parseInt(st.nextToken());
            if (operation.equals("type")) {
                Node prev = nodes[i-1];
                String nextText = prev.value + value;
                nodes[i]= new Node(nextText, second);
            }else{
                int secondsBack = Integer.parseInt(value);
                int targetTime  = second - secondsBack;

                int j= i - 1;
                while (j>0&& nodes[j].time>= targetTime) {
                    j--;
                }

                nodes[i] = new Node(nodes[j].value, second);
            }
        }
        System.out.println(nodes[n].value);
    }
}

