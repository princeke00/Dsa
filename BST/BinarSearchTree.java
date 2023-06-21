package BST;
import java.util.*;

public class BinarSearchTree {

    static class Node{
        int data;
        Node right,left;

        public Node(int data){
            this.data=data;
            this.right=this.left=null;
        }
    }

    public static Node buildBst(Node root, int value){
        if(root==null){
            return new Node(value);
        }
        if(root.data> value){
            root.left=buildBst(root.left, value);
        }else{
            root.right=buildBst(root.right, value);
        }
        return root;
    }

    public static void inOrder(Node root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void levelOrder(Node root){
        if(root== null){
            return;
        }

        Queue<Node> q= new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node curr= q.remove();
            if(curr==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(curr.data+" ");
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
    }

    public static boolean find(Node root, int value){// searching a node
        if(root==null) return false;
        if(root.data==value){ return true;}
        if(root.data>value){
            return find(root.left,value);
        }else{
            return find(root.right,value);
        }
    }

    public static Node delete(Node root, int value){ // deleting a node
        if(root.data<value){
            root.right=delete(root.right, value);
        }else if(root.data>value){
            root.left=delete(root.left, value);
        }else{
            if(root.left ==null && root.right==null){ // if both the child are null(leaf node), simply return null
                return null;
            }
            if(root.right==null){ // if right child is null(single child),return left child
                return root.left;
            }else if(root.left==null){ // if left child is null(single child),return right child
                return root.right;
            }

            Node inOrderS= sucessor(root.right); //3rd case if both child are present, find the sucessor
            root.data=inOrderS.data;
            root.right=delete(root.right, inOrderS.data);
        }
        return root;
    }

    public static Node sucessor(Node root){// helper function to find the inorder sucessor
        // inorder sucessor is the leftmost node in right subtree havinf=g '0' or '1' child.
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    
    public static void printRange(Node root, int k1, int k2){ //printing number in given range
        if(root==null) return;
        if(root.data>=k1 && root.data<=k2){
            printRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printRange(root.right, k1, k2);
        }else if(root.data<k1){ // if root value is lower than k1(begning no), search and print from right subtree
            printRange(root.right, k1, k2);
        }else { // if root value is grater than k2(begning no), search and print from left subtree
            printRange(root.left, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path){//to print path
        Iterator it=path.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+"->");
        }
        System.out.println("Null");
    }

    public static void leafPath(Node root, ArrayList<Integer> path){//traverse to leaf node from root
        if(root==null) return;
        path.add(root.data);
        if(root.left==null && root.right==null){
            printPath(path);
        }
        leafPath(root.left, path);
        leafPath(root.right, path);
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        int val[] = {8,5,3,1,4,6,10,11,14}; //{5,1,3,4,2,7};
        Node root=null;
        for(int i=0;i<val.length;i++){
            root=buildBst(root, val[i]);
        }

        levelOrder(root);
        // delete(root, 1);
        System.out.println();
        // levelOrder(root);
        // printRange(root, 1, 7);
        leafPath(root, new ArrayList<>());
    }
}
