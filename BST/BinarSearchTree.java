package BST;

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

    public static boolean find(Node root, int value){
        if(root==null) return false;
        if(root.data==value){ return true;}
        if(root.data>value){
            return find(root.left,value);
        }else{
            return find(root.right,value);
        }
    }

    public static void main(String[] args) {
        int val[] = {7,5,3,9,1,10,2,6,8,4,}; //{5,1,3,4,2,7};
        Node root=null;
        for(int i=0;i<val.length;i++){
            root=buildBst(root, val[i]);
        }

        // inOrder(root);
        System.out.println(find(root,0));
    }

}
