import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] square = new int[n][n];
        int curRow=n/2;
        int curCol=n/2;
        int limit=1;
        int value=1;

        while (true) {
            for (int i = 0; i < limit; i++) {
                square[curRow--][curCol]=value++; 
            }
            if (value - 1 == n * n) break; 
            for (int i = 0; i < limit; i++) {
                square[curRow][curCol++]=value++; 
            }
            limit++;
            for (int i = 0; i < limit; i++) {
                square[curRow++][curCol]=value++;
            }
            for (int i = 0; i < limit; i++) {
                square[curRow][curCol--]=value++; 
            }
            limit++;
        }

        StringBuilder sb = new StringBuilder();
        int x=0,y=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(square[i][j]).append(" ");
                if (square[i][j] == m){
                    x=i+1;
                    y=j+1;
                }
            }
            sb.append("\n");
        }
        sb.append(x+" "+y);
		System.out.println(sb.toString());
    }

}
