package BST;
import java.util.*;

public class SumInRange {

    public static class Node{
        int data;
        Node left, right;

        public Node(int data){
            this.data=data;
            this.right=this.left=null;
        }
    }

    public static int maxsum =0, sum=0, lsum,rsum;

    // finding the sum in range
    public static void sumRange(Node root,int l,int r){
        if(root==null) return;

        if(root.data>l && root.data<r){
            sumRange(root.left, l, r);
            sum+=root.data;
            sumRange(root.right, l, r);
        }
        
        if(root.data<l) sumRange(root.right, l, r);
        else sumRange(root.left, l, r);
    }
    
    // to find the nearest element to given key;
    static int min= Integer.MAX_VALUE, value=-1;
    public static void closest(Node root, int key){
        if(root==null) return;

        if(min>Math.abs(root.data-key)){
            min=Math.abs(root.data-key);
            value=root.data;
        }

        if(root.data<key)closest(root.right, key);
        else closest(root.left, key);

        // if(root.data<key){
        //     closest(root.right, key, tm);
        //     int diff=key-root.data;
        //     tm.put(diff,root.data);
        // }else{
        //     closest(root.left, key, tm);
        //     int diff=root.data-key;
        //     tm.put(diff,root.data);
        // }
    }

    // to find the kth largest/smallest node
    public static void kthSmall(Node root, ArrayList<Integer> list){
        if(root==null) return;
        kthSmall(root.left, list);
        list.add(root.data);
        kthSmall(root.right, list);
    }

    // masSumBst-> sum of all nodes of bst present in binary tree
    public static int maxSum(Node root,int min, int max){
        if(root==null) return 0;
        if(isBst(root,min,max)){
            sum=lsum+rsum+root.data;
            
        }
        int leftsum=maxSum(root.left, min, root.data);
        int rightsum=maxSum(root.right, min, max);
        int rootsum=leftsum+rightsum+sum;
        return Math.max(maxsum,rootsum);
    }

    private static boolean isBst(Node root, int min, int max) {
        if(root==null) {
            lsum=0;
            rsum=0;
            return true;
        }
        if(root.data<min) return false;
        else if(root.data>max) return false;

        return isBst(root.left, min, max)&&isBst(root.right, min, max);
    }

    public static void main(String[] args) {
        Node root= new Node(8);
        root.left= new Node(5);
        root.left.left= new Node(3);
        root.left.right= new Node(6);
        root.right= new Node(11);
        root.right.right= new Node(20);

        // sumRange(root, 9, 19);
        // System.out.println(sum);

        // TreeMap<Integer,Integer> tm =new TreeMap<>();
        // closest(root, 19);
        // int val=tm.firstKey();
        // System.out.println(tm.get(val));
        // System.out.println(value);

        ArrayList<Integer> list= new ArrayList<>();
        kthSmall(root, list);
        int key=5;
        // for kthsmallest
        System.out.println(list.get(list.size()-key));

        // for kthsmallest
        System.out.println(list.get(key-1));

        System.out.println(maxSum(root,0,0));
        
    }

}
