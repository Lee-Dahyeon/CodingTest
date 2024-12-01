
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] matrix = new char[n + 1][n + 1];
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= n; j++) {
                if (s.charAt(j-1) == 'G') {
                    matrix[i][j] = 'G';
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        if (minX == maxX && minY == maxY) System.out.println(0);
        else if (minX == maxX) {
            System.out.println(Math.min(n - minY, maxY-1));
        } else if (minY == maxY) {
            System.out.println(Math.min(n - minX, maxX-1));
        } else {
            int xForward = Math.min(n - minX, maxX-1);
            int yForward = Math.min(n - minY, maxY-1);
            System.out.println(xForward + yForward);
        }


    }
}
