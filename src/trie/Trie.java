package trie;

public class Trie {

    private Node root; //dummy node

    class Node{
        public char c;
        public boolean isWord;
        public Node[] children;


        public Node(char c){
            this.c = c;
            isWord = false;
            children = new Node[26]; // apenas letras minusculas - a-z
        }
    }

    public Trie(){
        root = new Node('\0'); //empty char
    }

    public void insert(String word){
        Node current = root;
        for(int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            if(current.children[c - 'a'] == null) current.children[c - 'a'] = new Node(c);
            current = current.children[c - 'a'];
        }
        current.isWord = true;
    }

    public boolean search(String word){
        Node node = getNode(word);
        return node != null  && node.isWord;
    }

    public boolean startsWith(String prefix){
        return getNode(prefix) != null;
    }

    private Node getNode(String word){
        Node current = root;
        for(int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            if(current.children[c - 'a'] == null) return null;
            current = current.children[c - 'a'];
        }
        return current;
    }


    public static void main(String[] args) {
        var trie = new Trie();
        trie.insert("mouse");
        trie.insert("cat");
        trie.insert("moon");

        System.out.println(trie.search("mouse"));
        System.out.println(trie.search("mouses"));
        System.out.println(trie.search("cat"));
        System.out.println(trie.search("car"));
        System.out.println(trie.search("moon"));
        System.out.println(trie.search("mo"));
    }
}
