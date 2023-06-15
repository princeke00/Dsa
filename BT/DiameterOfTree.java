package BT;

public class DiameterOfTree {
    static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data=data;
            this.right=this.left=null;
        }
    }

    static class Info{
        int height,dia;

        public Info(int height, int dia){
            this.height= height;
            this.dia= dia;
        }
    }

    public static int dia(Node root){// tc-> O(n^2) becouse each time it have to traverse the node 2 time 
                                    // 1 for dia function and other for height function.
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

    public static Info dia2(Node root){
        if(root==null) return new Info(0,0);
        Info leftInfo=dia2(root.left);
        Info rightInfo= dia2(root.right);

        int dia=Math.max( Math.max(leftInfo.dia,rightInfo.dia),leftInfo.height+rightInfo.height+1);
        int ht= Math.max(leftInfo.height,rightInfo.height)+1;
        return new Info(ht,dia);
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
        
        System.out.println("diameter is "+dia2(node).dia+" and height is "+dia2(node).height);

    }
}
