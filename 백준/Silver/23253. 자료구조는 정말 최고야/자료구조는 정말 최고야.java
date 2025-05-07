import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> bookLists = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int bookCnt= Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < bookCnt; j++) {
                int bookOrder = Integer.parseInt(st.nextToken());
                list.add(bookOrder);
            }
            bookLists.add(list);
        }
        boolean flag=true;
        for (int i = 0; i < bookLists.size(); i++) {
            for (int j = 0; j < bookLists.get(i).size()-1; j++) {
                if (bookLists.get(i).get(j)<=bookLists.get(i).get(j+1) ) {
                    flag=false;
                    break;
                }
            }
        }
        System.out.println(flag?"Yes":"No");
    }

}

