import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Flower{
        int startDate;
        int endDate;
        Flower(int startDate, int endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Flower> flowers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startM = Integer.parseInt(st.nextToken())*100;
            int startD = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken())*100;
            int endD = Integer.parseInt(st.nextToken());

            flowers.add(new Flower(startM + startD, endM+endD));
        }

        flowers.sort((f1,f2)-> f1.startDate==f2.startDate? f1.endDate- f2.endDate:f1.startDate-f2.startDate );

        int count = 0;
        int endNum=1201, startDate=301, endDate=301,idx=0;
        
        while (startDate<endNum){
            boolean found = false;
            while (idx<n && flowers.get(idx).startDate<=startDate){
                endDate=Math.max(endDate,flowers.get(idx).endDate);
                idx++;
                found = true;
            }
            if (!found) {
                System.out.println(0);
                return;
            }
            count++;
            startDate=endDate;
        }
        System.out.println(count);
    }
}
