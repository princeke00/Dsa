package Trie;

public class ShortPrefix {
    // to find the shortest unique prefix 

    // we need to create a trie
    // it will have a variable 'freq' that keeps track of character frequency
    // useful because when we have a char with frequency 1 means that its unique for its word to be a prefix
    // if a char is having frequncy>1 means it's comman for atleast 2 word that it should be prefix of  
    // all the word and we will have to travel till we encounter a char with freq equals to 1 to get unique prefix
    static class Node{
        Node arr[]= new Node[26];
        boolean eow= false;
        int freq;
        Node(){
            for(int i=0;i<26;i++){
                arr[i]= null;
            }
            freq=1;
        }
    }

    private static Node root = new Node();

    private static void prefix(Node root, String ans){
        if(root==null) return;
        if(root.freq==1) {
            System.out.println(ans);
            return;
        }
        for(int i=0;i<root.arr.length;i++){
            if(root.arr[i]!=null){
                prefix(root.arr[i], ans+(char)(i+'a'));
            }
        }
    }

    private static void insert(String word){
        Node cur= root;
        for(int i=0;i<word.length();i++){
            int index= word.charAt(i)-'a';
            if(cur.arr[index]==null){
                cur.arr[index]= new Node();
            }else cur.arr[index].freq++;
            cur= cur.arr[index];
        }
        cur.eow=true;
    }

    public static void main(String[] args) {
        String array[] = {"zebra","dog","dove","duck"};
        for(int i=0;i<array.length;i++){
            insert(array[i]);
        }

        root.freq=-1;

        prefix(root, new String());
    }
}
