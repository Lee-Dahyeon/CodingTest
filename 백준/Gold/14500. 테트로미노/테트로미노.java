import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int M;
    static int[][] board;
    static int maxSum = 0;
    static int[][][] tetromino = {
        {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
        {{0, 0}, {1, 0}, {2, 0}, {3, 0}},

        {{0, 0}, {0, 1}, {1, 0}, {1, 1}},

        {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
        {{0, 0}, {1, 0}, {2, 0}, {2, -1}},
        {{0, 0}, {1, 0}, {2, 0}, {0, -1}},
        {{0, 0}, {1, 0}, {2, 0}, {0, 1}},
        {{0, 0}, {0, 1}, {0, 2}, {1, 0}},
        {{0, 0}, {0, 1}, {0, 2}, {-1, 0}},
        {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
        {{0, 0}, {0, 1}, {0, 2}, {-1, 2}},

        {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
        {{0, 0}, {1, 0}, {1, -1}, {2, -1}},
        {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
        {{0, 0}, {0, 1}, {-1, 1}, {-1, 2}},

        {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
        {{0, 0}, {0, 1}, {0, 2}, {-1, 1}},
        {{0, 0}, {1, 0}, {2, 0}, {1, 1}},
        {{0, 0}, {1, 0}, {2, 0}, {1, -1}},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] NM = reader.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] row = reader.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }
       

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                
                for (int[][] tetro : tetromino) {
                    int sum = 0;
                    boolean isValid = true;
                    for (int[] block : tetro) {
                        int nx = i + block[0];
                        int ny = j + block[1];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                            isValid = false;
                            break;
                        } 
                      
                        sum += board[nx][ny];
                        
                    }
       
                    if (isValid) {
                        if(sum > maxSum) {
                            
                            maxSum = sum;
                        }
                    }
                }
            }
        }

        System.out.println(maxSum);
    }
}