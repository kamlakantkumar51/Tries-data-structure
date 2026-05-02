import java.util.*;
class Main {
    static class Node {
        Node children[] = new Node[26];
        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
    static Node root = new Node();
    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
    }
    public static int countNodes(Node root) {
        if (root == null) return 0;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += countNodes(root.children[i]);
        }
        return count + 1; 
    }
    public static void main(String args[]) {
        String str = "ababa";  
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }
        int totalNodes = countNodes(root);
        System.out.println("Unique substrings = " + (totalNodes - 1));
    }
}
