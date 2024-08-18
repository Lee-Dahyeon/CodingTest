import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//슬라이딩 윈도우
public class Main {
    static int[] currentArr=new int[4];//현재 배열-각 문자 개수 셈
    static int[] checkArr = new int[4];//조건 배열-각 문자별 개수 조건
    static int result=0; //최종 조건 성립 여부 판별시 사용
    static int resultCheck=0; //중간중간 조건 성립 개수 확인용
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int P = sc.nextInt();

        sc.nextLine();//개행 문자 처리
         //현재 상태 배열
        String dna =sc.nextLine();

        //조건 배열
        for (int i = 0; i < 4; i++) {
            checkArr[i]=sc.nextInt();
            if(checkArr[i]==0){
                resultCheck++;
            }
        }

        //초기 윈도우 설정
        for (int i = 0; i < P; i++) {
            addition(dna.charAt(i));
        }
        if(resultCheck==4)result++;

        //슬라이딩 윈도우
        for (int i = P; i < S; i++) {
            int j = i-P;
            addition(dna.charAt(i));
            remove(dna.charAt(j));
            if (resultCheck == 4) {
                result++;
            }
        }
        System.out.println(result);

        }
    private static void addition(char i){
            if (i == 'A') {
                currentArr[0]++;
                if (currentArr[0] == checkArr[0]) resultCheck++;
            } else if (i == 'C') {
                currentArr[1]++;
                if (currentArr[1] == checkArr[1]) resultCheck++;
            } else if (i == 'G') {
                currentArr[2]++;
                if (currentArr[2] == checkArr[2]) resultCheck++;
            } else if (i == 'T') {
                currentArr[3]++;
                if (currentArr[3] == checkArr[3]) resultCheck++;
            }

    }
    private static void remove(char i){
            if (i == 'A') {
                if (currentArr[0] == checkArr[0]) resultCheck--;
                currentArr[0]--;
            } else if (i == 'C') {
                if (currentArr[1] == checkArr[1]) resultCheck--;
                currentArr[1]--;
            } else if (i == 'G') {
                if (currentArr[2] == checkArr[2]) resultCheck--;
                currentArr[2]--;
            } else if (i == 'T') {
                if (currentArr[3] == checkArr[3]) resultCheck--;
                currentArr[3]--;
            }


    }}



