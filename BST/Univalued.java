package BST;

import javax.sql.rowset.spi.SyncResolver;

public class Univalued {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }
    public static boolean isUniValued(Node root){
        if(root==null){
            return true;
        }
        if(root.left!=null && root.data != root.left.data){
            return false;
        }else if(root.right!=null && root.data!=root.right.data){
            return false;
        }
        boolean a=isUniValued(root.left);
        boolean b=isUniValued(root.right);
        return a&&b;
    }

    public static void main(String[] args) {
        Node node= new Node(1);
        node.left=new Node(1);
        node.right= new Node(1);
        node.left.left= new Node(1);
        node.left.right= new Node(1);

        System.out.println(isUniValued(node));
        
    }
}
