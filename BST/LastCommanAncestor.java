package BST;
import java.util.*;

public class LastCommanAncestor {
     // creating a Node class.
     static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static void kLevel(Node root, int level, int k){
        if(root== null){
            return;
        }
        // if(level==k){
        //     System.out.print(root.data+" ");
        //     return;
        // }
        // kLevel(root.left,level+1,k);
        // kLevel(root.right,level+1,k);

        Queue<Node> q= new LinkedList<>();
        q.add(root); q.add(null);

        while(!q.isEmpty()){
            Node curr= q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                    level++;
                }
            }else{
                if(level==k){
                    System.out.print(curr.data+" ");
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
    }

    public static Node lca(Node root, int n1, int n2){ // tc->O(n) ,sc-> O(n) traversig nd storing in arraylist;
        ArrayList<Node> path =  new ArrayList<>();
        ArrayList<Node> path1 =  new ArrayList<>();

        getPath(root, n1,path);
        getPath(root, n2,path1);

        int i=0;
        for(;i<path.size() && i<path1.size();i++){
            if(path.get(i)!=path1.get(i)){
                break;
            }
        }
        return path.get(i-1);
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if(root==null) return false;
        path.add(root);
        if(root.data==n) return true;

        boolean leftPath  = getPath(root.left,n,path);
        boolean rightPath = getPath(root.right,n,path);

        if(leftPath||rightPath)return true;
        path.remove(path.size()-1);
        return false;

    }

    public static Node lcaa(Node root, int n1, int n2){ // tc->O(n) ,sc-> O(1)
        if(root==null ||root.data==n1||root.data==n2){
            return root;
        }

        Node leftlca = lcaa(root.left,n1,n2) ;
        Node rightlca = lcaa(root.right,n1,n2) ;

        if(leftlca==null)return rightlca;
        if(rightlca==null)return leftlca;

        return root;
    }

    public static int minDistance(Node root,int n1,int n2){//minimum distance b/w two nodes
        // approch is to find lca of both the nodes
        // then find distance from nodes to lca, sum it up and return.
        Node lca = lcaa(root,n1,n2);
        int dist1= getMinPath(lca,n1);
        int dist2= getMinPath(lca,n2);

        return dist1+dist2;
    }

    private static int getMinPath(Node root, int n) {// helping function for minDistance
        if(root==null) return -1;
        if(root.data==n) return 0;

        int leftval=getMinPath(root.left, n);
        int righttval=getMinPath(root.right, n);

        if(leftval==-1 && righttval==-1){
            return -1;
        }else if(righttval==-1){
            return leftval+1;
        }else{
            return righttval+1;
        }

    }

    public static int kAncestor(Node root, int k, int n){// to find kth ancestor of node
        if(root== null) return -1; // return -1 when a null node is traversed
        if(root.data==n) return 0; // return 0 as its eqauals to the node

        int left=kAncestor(root.left, k, n);
        int right=kAncestor(root.right, k, n);
        if(left==-1 && right==-1)return -1; // if both the subtrees return -1 means the node is not found
                                            //in child of the node bwing traversed
        int max=Math.max(left,right);
        if(max+1==k){ System.out.println(root.data);}
        return max+1;
    }

    public static int sumTrans(Node root){
        if(root==null)return 0;
        int left=sumTrans(root.left);
        int right=sumTrans(root.right);
        int data=root.data;
        int newlt=root.left==null?0:root.left.data;//extra check if we are leave nodes
        int newrt=root.right==null?0:root.right.data; //extra check if we are leave nodes
        root.data=newlt+newrt+left+right;
        return data;
    } 
    public static void printNode(Node root){
        if(root == null) return ;
        printNode(root.left);
        printNode(root.right);
        System.out.print(root.data+" ");

    }

    public static void main(String[] args) {

        // creating a Binary tree 
            //          1
            //         / \
            //        2   3
            //      /  \ /  \
            //     4   5 6   7

        Node root= new Node(1);
        root.left= new Node(2);
        root.right= new Node(3);
        root.left.left= new Node(4);
        root.left.right= new Node(5);
        root.right.left= new Node(6);
        root.right.right= new Node(7);

        // kLevel(root, 1, 3);
        // Node ghe=lcaa(root, 6, 7);
        // System.out.println(ghe.data);
        // System.out.println(minDistance(root, 2, 3));
        // kAncestor(root, 2,4);
        sumTrans(root);
        printNode(root);
       
    }

}