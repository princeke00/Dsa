package Trie;

public class StartsWith {
    static class Node{
        Node arr[] =  new Node[26];
        boolean eow = false;
        Node(){
            for(int i=0;i<26;i++){
                arr[i]= null;
            }
        }
    }

    public static Node root = new Node() ;

    public static void insert(String word){
        Node cur = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a' ;
            if(cur.arr[idx]==null){
                cur.arr[idx] =  new Node();
            }
            cur=cur.arr[idx];
        }
        cur.eow = true;
    }

    public static boolean search(String word){
        Node cur=root;
        for(int i=0;i<word.length();i++){
            int idx= word.charAt(i)-'a';
            if(cur.arr[i]==null){
                return false;
            }
            cur=cur.arr[idx];
        }
        return cur.eow==true;
    }

    public static boolean startsWith(String prefix){
        Node curr= root;
        for(int i=0;i<prefix.length();i++){
            int idx= prefix.charAt(i)-'a';
            if(curr.arr[idx]==null) return false;
            curr= curr.arr[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String words[] = {"apple","app","man","mango","woman"};

        String prefix[] = {"app","we"};

        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }

        for(int i=0;i<prefix.length;i++){
            System.out.println(prefix[i]+" "+startsWith(prefix[i]));
        }
    }
}
