
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Character, Node> tree = new HashMap<>();
    static StringBuilder sb=new StringBuilder();
    static class Node{
        private char value;
        private Node left;
        private Node right;

        Node(char value){
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            createNode(parent,left,right);

        }

        sb.setLength(0);
        preOrder(tree.get('A'));
        System.out.println(sb.toString());

        sb.setLength(0);
        inOrder(tree.get('A'));
        System.out.println(sb.toString());


        sb.setLength(0);
        postOrder(tree.get('A'));
        System.out.println(sb.toString());

    }
    static void createNode(char parent, char left, char right){
        tree.putIfAbsent(parent, new Node(parent));
        Node parentNode = tree.get(parent);

        if (left != '.') {
            parentNode.left = new Node(left);
            tree.put(left, parentNode.left);
        }
        if (right != '.') {
            parentNode.right = new Node(right);
            tree.put(right, parentNode.right);
        }

    }

    static void preOrder(Node node) {
        if (node != null) {
            sb.append(node.value);
            if (node.left != null) preOrder(node.left);
            if (node.right != null) preOrder(node.right);
        }
    }
    static void inOrder(Node node) {
        if (node != null){
            if(node.left != null) inOrder(node.left);
            sb.append(node.value);
            if(node.right != null) inOrder(node.right);
        }
    }
    static void postOrder(Node node) {
        if (node != null) {
            if(node.left != null) postOrder(node.left);
            if(node.right != null) postOrder(node.right);
            sb.append(node.value);
        }
    }

}
