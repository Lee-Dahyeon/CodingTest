
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        //받은 숫자 배열 생성
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        int temp = 0;//누적합
        int result =0; //최종 시간

        //오름차순 정리
        Arrays.sort(p);

        //기다리는 시간 계산
        for (int i = 0; i < n; i++) {
            temp += p[i];
            result+=temp;

        }
        System.out.println(result);
    }
}
