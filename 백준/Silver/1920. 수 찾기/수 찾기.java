import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for(int i=0;i<n;i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2=new StringTokenizer(br.readLine());
        int[] B = new int[m];
        for(int i=0;i<m;i++){
            B[i]=Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(A);//12345

        int start;
        int end;
        int mid;
        boolean found;
        for(int target: B) {
            start=0; end=A.length-1;mid=0;
            found=false;

            while (start <= end) {
                mid=(start+end)/2;
                if (target== A[mid]) {
                    found=true;
                    break;
                } else if (target > A[mid]) {
                    start = mid + 1;
                } else if (target<A[mid]) {
                    end = mid - 1;
                }
            }
            if (found) {
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }
    }
}
