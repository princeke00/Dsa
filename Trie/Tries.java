package Trie;

// data structure which help in solving problem based on strings
public class Tries {
    
    static class Node{

        // creating array  of node type and making it of size 26(because of 26 alphabets)
        Node arr[] = new Node[26];
        boolean eow= false;

        public Node(){
            for(int i=0;i<arr.length;i++){
                arr[i]=null;
            }
        }
    }

    private static Node root= new Node();

    // inserting into tries
    private static void insert(String word){
        Node curr= root;
        for(int i=0;i<word.length();i++){
            int idx= word.charAt(i)-'a';
            if(curr.arr[idx]==null){
                curr.arr[idx]=new Node();
            }
            curr= curr.arr[idx];
        }
        curr.eow=true;
    }

    // searching 
    private static boolean search(String key){
        Node curr=root;
        for(int i=0;i<key.length();i++){
            int idx= key.charAt(i) -'a';
            if(curr.arr[idx]==null){
                return false;
            }
            curr= curr.arr[idx];
        }
        return curr.eow==true;
    }

    public static boolean wordBreak(String key){
        
        if(key.length()==0) return true;
        // initializing variable at 1 becouse of substring function
        for(int i=1;i<=key.length();i++){
            // checking if 1st character is present in tries or not
            // then passing new key in function(recurion).
            if(search(key.substring(0, i)) && wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String arr[] = {"i","like","sam","samsung","mobile","ice"};

        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }

        System.out.println(wordBreak("alikeice"));
    }
}
