
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        int resultAdd=0;

        for (int i = n-2; i >=0 ; i--) {
            if (list.get(i) >= list.get(i+1)) {
                int temp = list.get(i+1)-1;
                resultAdd += list.get(i)-temp;
                list.set(i,temp);
            }
        }
        System.out.println(resultAdd);
    }
}
