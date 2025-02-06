import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        Stack<Integer> stack = new Stack<>();
        Map<Character, Integer> map = Map.of('H', 1, 'C', 12, 'O', 16);
        for ( char c : data.toCharArray() ) {
            if ( c=='('){
                stack.push(0);
            } else if ( c==')'){
                int sum = 0;
                while (!stack.isEmpty() && stack.peek() != 0){
                    sum+=stack.pop();
                }
                stack.pop();
                stack.push(sum);
            } else if (map.containsKey(c)){
                stack.push(map.get(c));
            } else { 
                int num = stack.pop();
                stack.push(num * (c-'0'));
            }
        }
        int total = 0;
        while (!stack.isEmpty()){
            total += stack.pop();
        }
        System.out.println(total);

    }

}
