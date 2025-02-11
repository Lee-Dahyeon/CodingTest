import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
        }

        if (!nextPermutation()){
            System.out.println(-1);
        }else{
        for (int i = 0; i < n; i++) {
        System.out.print(arr[i]+" ");
        }
        }

    }
    private static boolean nextPermutation() {
        int i=n-1; 
        while (i>0 && arr[i] <= arr[i-1]) i--;
        if (i<=0) return false;

        int j=n-1;
        while (arr[j] <= arr[i-1]) j--;

        
        swap(i-1, j);
        j = n-1;
        while (i <j){
            swap(i,j);
            i++; j--;
        }
        return true;
    }
    private static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }
}
