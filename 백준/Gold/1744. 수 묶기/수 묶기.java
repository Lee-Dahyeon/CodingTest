import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num=Integer.parseInt(br.readLine());
            if (num>=1){
                positive.add(num);
            }else{
                negative.add(num);
            }
        }
        int sum = 0;
        while (positive.size() >= 1) {
            if (positive.size()==1){
                sum += positive.poll();
            }else{
            int first = positive.poll();
            int second = positive.poll();
            if (second==1){
                sum += first+second;
            }else {
                int temp = first * second;
                sum += temp;
            }
            }
        }
        while (negative.size() >= 1) {
            if (negative.size()==1){
                sum += negative.poll();
            }else{
                int first = negative.poll();
                int second = negative.poll();
                int temp = first * second;
                sum += temp;
            }
        }
        System.out.print(sum);
    }
}
