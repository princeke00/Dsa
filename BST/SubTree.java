package BST;

public class SubTree {
    static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data=data;
            this.right=this.left=null;
        }
    }

    public static boolean subtree(Node root, Node subRoot){
        if(root==null) return false ; // retruning false as the sbutree root is not null.
        if(root.data==subRoot.data){
            if(isSame(root,subRoot)) return true;
        }

        return subtree(root.left, subRoot) || subtree(root.right, subRoot);
    }

    private static boolean isSame(Node root, Node subRoot) {
        if(root==null && subRoot==null) return true;// if botth of roots are null meaning on leaf  node
        if(root==null || subRoot==null || root.data!=subRoot.data) return false; // if any of them is null means structure is not same or
        //  if data is not same then it's not same

        if(!isSame(root.left, subRoot.left)) return false;
        if(!isSame(root.right,subRoot.right)) return false;
        
        return true;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        Node subRoot=new Node(2);
        subRoot.left=new Node(4);
        subRoot.right= new Node(5);

        System.out.println(subtree(node, subRoot));
    }
}
