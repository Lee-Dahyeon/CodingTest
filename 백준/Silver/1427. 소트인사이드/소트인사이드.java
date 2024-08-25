import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next(); 
        int[] arr = new int[n.length()];
        for (int i = 0; i < n.length(); i++) {
            arr[i] = Integer.parseInt(n.substring(i,i+1));}
        for (int i = 0; i < n.length(); i++) {
            for (int j = i+1; j < n.length(); j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j]=temp;
                }
            }
        }
        for (int i = 0; i < n.length(); i++) {
            System.out.print(arr[i]);
        }
    }
}
