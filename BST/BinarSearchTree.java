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

    // build a new bst
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

    //inorder traversal of bst
    public static void inOrder(Node root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    //level order if bst
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

    // searching a node
    public static boolean find(Node root, int value){
        if(root==null) return false;
        if(root.data==value){ return true;}
        if(root.data>value){
            return find(root.left,value);
        }else{
            return find(root.right,value);
        }
    }

    // deleting a node
    public static Node delete(Node root, int value){ 
        if(root.data<value){
            root.right=delete(root.right, value);
        }else if(root.data>value){
            root.left=delete(root.left, value);
        }else{
            // if both the child are null(leaf node), simply return null
            if(root.left ==null && root.right==null){ 
                return null;
            }
            // if right child is null(single child),return left child
            if(root.right==null){ 
                return root.left;
            }
            // if left child is null(single child),return right child
            else if(root.left==null){ 
                return root.right;
            }
            //3rd case if both child are present, find the sucessor
            Node inOrderS= sucessor(root.right); 
            root.data=inOrderS.data;
            root.right=delete(root.right, inOrderS.data);
        }
        return root;
    }

    // helper function to find the inorder sucessor
    // inorder sucessor is the leftmost node in right subtree havinf=g '0' or '1' child.
    public static Node sucessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    
    //printing number in given range
    public static void printRange(Node root, int k1, int k2){ 
        if(root==null) return;
        if(root.data>=k1 && root.data<=k2){
            printRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printRange(root.right, k1, k2);
        }
        // if root value is lower than k1(begning no), search and print from right subtree
        else if(root.data<k1){ 
            printRange(root.right, k1, k2);
        }
        // if root value is grater than k2(begning no), search and print from left subtree
        else { 
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

    //traverse to leaf node from root(preorder traversal)
    public static void leafPath(Node root, ArrayList<Integer> path){
        if(root==null) return;
        path.add(root.data);
        if(root.left==null && root.right==null){
            printPath(path);
        }
        leafPath(root.left, path);
        leafPath(root.right, path);
        path.remove(path.size()-1);
    }

    //check with each node value that it should be grater than
    // its inorder predecessor and less than inorder sucessor.
    static boolean isBst(Node root, Node min, Node max){
        if(root==null) return true;

        if(min!=null && root.data<=min.data) return false;
        else if(max!=null && root.data>=max.data) return false;

        return isBst(root.left, min, root) && isBst(root.right, root, max);
    }

    // creates a mirror image of given bst;
    public static Node mirrorNode(Node root){
        if(root==null)
            return null;
        //assining the values
        Node left=mirrorNode(root.left);
        Node right=mirrorNode(root.right);
        // swaping the values in node.
        root.left=right;
        root.right=left;
        return root;
    }

    // create a balnce bst o fmiminmum height.
    public static Node balanceBst(int[] arr,int st, int end){ 
        if(st>end) return null;

        int mid= (st+end)/2;
        Node root= new Node(arr[mid]);
        root.left=balanceBst(arr, st, mid-1);
        root.right=balanceBst(arr, mid+1, end);

        return root;
    }

    // create a balnce bst o fmiminmum height.
    public static Node balancedBst1(ArrayList<Integer> al, int st, int end){
        if(st>end) return null;
        int mid=(st+end)/2;
        Node root= new Node(al.get(mid));
        root.left=balancedBst1(al, st, mid-1);
        root.right=balancedBst1(al, mid+1, end);
        return root;
    }

    // return a list containing inorder sequence
    public static void getInorderSequence(Node root,ArrayList<Integer> list){
        // of a binary tree.
        if(root==null)  return;
        getInorderSequence(root.left,list);
        list.add(root.data);
        getInorderSequence(root.right, list);    
    }

    public static void main(String[] args) {
        int val[] ={1,2,3,4,5,6,7,8,9}; //{8,5,3,1,4,6,10,11,14}; 
        // Node root=null;
        // for(int i=0;i<val.length;i++){
        //     root=buildBst(root, val[i]);
        // }

        // levelOrder(root);
        // delete(root, 1);
        System.out.println();
        // levelOrder(root);
        // printRange(root, 1, 7);
        // leafPath(root, new ArrayList<>());
        // System.out.println(isBst(root, null, null));
        // Node ex=mirrorNode(root);
        // levelOrder(ex);
        // Node root=balanceBst(val, 0, val.length-1);
        // inOrder(root);
        Node root= new Node(8);
        root.left=new Node(6);
        root.left.left= new Node(5);
        root.left.left.left= new Node(4);
        root.right= new Node(10);
        root.right.right= new Node(11);
        root.right.right.right= new Node(12);

        ArrayList<Integer> al=new ArrayList<>();
        getInorderSequence(root, al);
        
        Node hehe=balancedBst1(al, 0, al.size()-1);

        inOrder(hehe);

        // for(int i=0;i<al.size();i++){
        //     System.out.print(al.get(i)+" ");
        // }

    }
}
