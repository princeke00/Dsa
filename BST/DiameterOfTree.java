package BST;

public class DiameterOfTree {
    static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data=data;
            this.right=this.left=null;
        }
    }

    public static int dia(Node root){
        if(root==null) return 0;
        int leftdia=dia(root.left);
        int rightdia=dia(root.right);
        int leftht=height(root.left);
        int rightht=height(root.right);
        return Math.max(Math.max(leftdia,rightdia),leftht+rightht+1);
    }

    private static int height(Node root) {
        if(root==null)
            return 0;
        int leftht=height(root.left);
        int rightht=height(root.right);

        return Math.max(leftht,rightht)+1;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        // node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        // node.right.left = new Node(6);
        // node.right.right = new Node(7);
        System.out.println("diameter is :"+dia(node));

    }
}
