package Trie;

public class UniquePrefix {
    // find unique substring 

    // find all the suffix of word and then insert into tries
    // tries store unique prefix and is called prefix tree.
    // then count total number of nodes in tries and return it.

    static class Node{
        Node arr[]=  new Node[26];
        boolean eow=false;
        Node(){
            for(int i=0;i<26;i++){
                arr[i]=null;
            }
        }
    }

    public static Node root= new Node();

    public static void insert(String word){
        Node curr= root;
        for(int i=0;i<word.length();i++){
            int idx= word.charAt(i)-'a';
            if(curr.arr[idx]==null){
                curr.arr[idx]= new Node();
            }
            curr=curr.arr[idx];
        }
        curr.eow=true;
    }

    public static int countNode(Node root){
        if(root==null) return 0;
        int count=0;
        for(int i=0;i<26;i++){
            if(root.arr[i]!=null){
                count+=countNode(root.arr[i]);
            }
        }
        return count+1;

    }

    public static void main(String[] args) {
        String s="apple";

        for(int i=0;i<s.length();i++){
            String s1=s.substring(i);
            System.out.println(s1);
            insert(s1);
        }
        
        System.out.println(countNode(root));
    }
}
